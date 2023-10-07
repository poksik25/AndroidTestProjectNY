package com.poklad.androidtestprojectny.di.module

import com.poklad.androidtestprojectny.data.remote.api.NYTimesApi
import com.poklad.androidtestprojectny.data.remote.interceptors.AuthInterceptor
import com.poklad.androidtestprojectny.di.annotations.ApplicationScope
import com.poklad.androidtestprojectny.di.annotations.AuthInterceptorQualifier
import com.poklad.androidtestprojectny.utils.ApiConstants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class NetworkModule {
    @Provides
    @ApplicationScope
    fun providesStoreApi(retrofit: Retrofit): NYTimesApi {
        return retrofit.create(NYTimesApi::class.java)
    }

    @Provides
    @ApplicationScope
    fun provideOkHttpClient(@AuthInterceptorQualifier authInterceptor: AuthInterceptor): OkHttpClient {
        val client = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        client.addInterceptor(authInterceptor)
        client.addInterceptor(interceptor)
        return client.build()
    }

    @Provides
    @AuthInterceptorQualifier
    @ApplicationScope
    fun providesAuthInterceptors(): AuthInterceptor {
        return AuthInterceptor(ApiConstants.API_KEY)
    }

    @Provides
    @ApplicationScope
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}