package com.example.kokpit.taclife.istantapp.utilClass

import android.app.AlertDialog
import android.content.Context


fun alert(title: String, message: String, objects: Context): AlertDialog.Builder {
        val miaAlert = AlertDialog.Builder(objects)
        miaAlert.setTitle(title)
        miaAlert.setMessage(message)
        miaAlert.setCancelable(false)
        return miaAlert
        }

fun create(alert: AlertDialog.Builder) {
    alert.create()
    alert.show()
}


