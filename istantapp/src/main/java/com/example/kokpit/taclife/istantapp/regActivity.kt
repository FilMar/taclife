package com.example.kokpit.taclife.istantapp

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.kokpit.taclife.istantapp.networkclass.*
import com.example.kokpit.taclife.istantapp.utilClass.*
import kotlinx.android.synthetic.main.activity_reg.*


class regActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        nopb.setOnClickListener {
            startActivity(Intent(this, StartActivity::class.java))
        }

        yepb.setOnClickListener {
            if (possibilitaerrore()) {
                usercorrente =
                        user(
                                usertab.text.toString(),
                                passtab.text.toString(),
                                data.toString()
                        )
              //  TODO("aggiunta utente al db")
               // startActivity(Intent(this, menuActivity::class.java))
            }

                var test = usercorrente!!.adduser(this)

                val alert = alert(
                    "test",
                    test.toString(),
                   this
                )

                alert.setNeutralButton("ok") { _: DialogInterface?, _: Int ->  startActivity(Intent(this, regActivity::class.java))
                }
                create(alert)
            }
        }

    fun picker(v: View) {
        val newFragment = dataFragment()
        newFragment.show(supportFragmentManager, "datePicker")
        dateButton.setText(data, TextView.BufferType.EDITABLE)
        this.recreate()
    }

    fun possibilitaerrore(): Boolean {//varie possibilità di errori di inserimento
        if ( (usertab.text.toString() == "") or (passtab.text.toString() == "") or (repasstab.text.toString() == "") or (data == null) ) {

            val alert = alert(
                "errore di inserimento",
                " almeno un campo è vuoto",
                this
            )

            alert.setNeutralButton("ok") { _: DialogInterface?, _: Int ->  startActivity(Intent(this, regActivity::class.java))
            }
            create(alert)
        }
        else if (passtab.text.toString() != repasstab.text.toString()) {

            val alert = alert(
                "errore di inserimento",
                "le password non coincidono",
                this
            )

            alert.setNeutralButton("ok") { _: DialogInterface?, _: Int ->  startActivity(Intent(this, regActivity::class.java))
            }
            create(alert)
        }
        else if (!CheckNetworking.isNetworkAvailable(this)) {
            val alert = alert(
                "errore di connessione",
                "connessione mancante, controllarla prima di riprovare",
                this
            )
            alert.setNeutralButton("ok") { _: DialogInterface?, _: Int -> startActivity(Intent(this, StartActivity::class.java) )}
            create(alert)
        }
        else {
            return true
        }
        return false
    }
}











