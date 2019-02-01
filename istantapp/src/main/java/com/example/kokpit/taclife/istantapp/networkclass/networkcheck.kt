package com.example.kokpit.taclife.istantapp.networkclass

import android.content.Context
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.util.Log
import okhttp3.*
import java.io.IOException
import java.lang.Exception
import kotlin.math.log


object CheckNetworking {
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}

object net {
    private val url = "http://taclife.altervista.org/"

    val adduser = url + "loginadd.php"

    val usercheck = url + "logincheck.php"

    val exp = url + "expupgrade.php"
}

fun loginadd(body:RequestBody, url : String, context: Context): String? {
    var resu: String? = null
    var client: OkHttpClient? = null
    var request: Request? = null
    try {
        request = Request.Builder()
                .url(url)
                .post(body)
                .build()
        client = OkHttpClient()

    } catch (e: Exception) {
        Log.e("strano1", e.message)
    }
    client?.newCall(request)?.enqueue(object : Callback{
        override fun onResponse(call: Call, response: Response) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            Log.e("strano2si",response.body().toString())
            resu= response.body().toString()

        }

        override fun onFailure(call: Call, e: IOException) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            Log.e("strano2si",e.javaClass.toString() + e.message)

        }

    })
    return resu
}


