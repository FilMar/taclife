package com.example.kokpit.taclife.istantapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*
import com.example.kokpit.taclife.istantapp.networkclass.*

class menuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

       dettagli.text= " Nome " + (usercorrente?.utente) + "\n Exp" + usercorrente!!.exp

        All.setOnClickListener {
          //  TODO("fetch cicli DB")
            startActivity(Intent(this, cicliActivity::class.java))
        }

        mciclo.setOnClickListener {
           // TODO("fetch es + crea nuovo ciclo e add new es")
            startActivity(Intent(this, createActivity::class.java))
        }
        logout.setOnClickListener {
         //   TODO("server logout")
            usercorrente=null
            startActivity(Intent(this, StartActivity::class.java))
        }



    }
}
