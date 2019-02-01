package com.example.kokpit.taclife.istantapp.networkclass

import android.content.Context
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
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

fun post (body:RequestBody, url : String, context: Context): String? {
    var resu: String? = null
    var client : OkHttpClient? =null
    var request : Request? = null
    try {
            request = Request.Builder()
            .url(url)
            .post(body)
            .build()
            client = OkHttpClient()

    }catch (e:Exception){
        Log.e("strano1",e.message)
    }

    class async : AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg params: Void?): String? {
            try {
                Log.e("strano2", "arriva qui!")
                val test = client!!.newCall(request).execute()
                Log.e("strano2", test.body().toString())
                return test.body().toString()

            } catch (e: Exception) {
                Log.e("strano2", e.javaClass.toString()+e.message)
            }
            return "mela"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Log.e("strano2", "principale")
            resu = result

        }
    }
        try {


        async().execute()
        return resu

        }catch (e:Exception){
            Log.e("strano3",e.message)
        }
        return null
    }


