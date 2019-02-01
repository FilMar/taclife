package com.example.kokpit.taclife.istantapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        reg.setOnClickListener {
            startActivity(Intent(this, regActivity::class.java))
        }
        accedi.setOnClickListener {
            startActivity(Intent(this, menuActivity::class.java))
        }
            }


}
