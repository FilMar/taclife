package com.example.kokpit.taclife.istantapp.networkclass

import android.content.Context
import com.google.gson.Gson
import okhttp3.FormBody
import okhttp3.RequestBody


class user {

    var utente: String? = null
    var passwd: String? = null
    var dataN: String? = null
    var exp = 0
    var privilegi = false
    val parser = Gson()

    constructor(utente: String, passwd: String, dataN: String) {
        this.utente = utente
        this.passwd = passwd
        this.dataN = dataN
    }

    constructor(utente: String, passwd: String, dataN: String, exp: Int, pri: Boolean) {
        this.utente = utente
        this.passwd = passwd
        this.dataN = dataN
        this.exp = exp
        this.privilegi = pri
    }

    constructor(jsonElement: String) {
        parser.fromJson(jsonElement , this.javaClass)
    }

    fun tojson(): String? {
        return parser.toJson(this)
    }

    fun adduser (context: Context): String? {
        val body = FormBody.Builder()
            .add("utenteReg",this.utente)
            .add("passwReg",this.passwd)
            .add("pass2Reg",this.passwd)
            .add("dataNReg",this.dataN)
            .build()

         return post(body,net.adduser,context)
    }
}
var usercorrente : user? = null