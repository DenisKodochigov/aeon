package com.example.aeon.entity

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.example.aeon.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ErrorApp @Inject constructor(@ApplicationContext val context: Context) {

    fun errorApi (errorMessage:String){

        val toastMessage = when(errorMessage){
            "error_addProduct" -> context.getString(R.string.error_add)
            else -> context.getString(R.string.errorUser)
        }
        if (toastMessage.isNotEmpty()) {
            Handler(Looper.getMainLooper()).post {
                Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

