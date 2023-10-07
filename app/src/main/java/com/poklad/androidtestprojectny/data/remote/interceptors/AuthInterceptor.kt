package com.poklad.androidtestprojectny.data.remote.interceptors

import android.accounts.NetworkErrorException
import com.poklad.androidtestprojectny.utils.extensions.log
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val apiKey: String) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        try {
            val originalRequest = chain.request()
            val modifiedUrl = originalRequest.url.newBuilder().apply {
                addQueryParameter(API_KEY, apiKey)
            }.build()
            val modifiedRequest = originalRequest.newBuilder().url(modifiedUrl).build()
            return chain.proceed(modifiedRequest)
        } catch (e: Exception) {
            log(e.message.toString())
            throw e
        }
    }

    companion object {
        const val API_KEY = "api-key"
    }
}