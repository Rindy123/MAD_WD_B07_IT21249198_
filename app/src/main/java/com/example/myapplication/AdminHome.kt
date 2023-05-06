package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class AdminHome : AppCompatActivity() {
    var layout1: LinearLayout? = null
    var layout2: LinearLayout? = null
    var layout3: LinearLayout? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_home)
        layout1 = findViewById<View>(R.id.propertybtn1) as LinearLayout
        layout2 = findViewById<View>(R.id.propertybtn2) as LinearLayout
        layout3 = findViewById<View>(R.id.propertybtn3) as LinearLayout

        layout1!!.setOnClickListener {
            val `in` = Intent(this@AdminHome, ManageSuppliers::class.java)
            startActivity(`in`)
        }
        layout2!!.setOnClickListener {
            val `in` = Intent(this@AdminHome, ManageCustomers::class.java)
            startActivity(`in`)
        }
        layout3!!.setOnClickListener {
            val `in` = Intent(this@AdminHome, ManageCustomerComments::class.java)
            startActivity(`in`)
        }
    }
}