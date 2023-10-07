package com.poklad.androidtestprojectny.utils.extensions

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

fun Any.tag(): String {
    return this::class.simpleName!!
}

fun Any.log(msg: String) {
    Log.d("TAG: ${tag()}", msg)
}

fun Any.logError(msg: String) {
    Log.e("TAG: ${tag()}", msg)
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun View.showSnackbar(message: String, length: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, message, length).show()
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun ImageView.loadImage(url: Any) {
    Glide.with(this)
        .load(url)
        .into(this)
}
