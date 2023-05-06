package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity

class SupplierHomePage : AppCompatActivity() {
    var st: String? = null
    var tv: TextView? = null
    var ButtonCleaning: LinearLayout? = null
    var ButtonAccepting: LinearLayout? = null
    var layout3: LinearLayout? = null
    var layout4: LinearLayout? = null
    var layout5: LinearLayout? = null
    private var dbHelper: DBHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_home_page)
        dbHelper = DBHelper(this, null)
        dbHelper!!.OpenDB()
        tv = findViewById(R.id.textView1)
        st = intent.extras!!.getString("username")
        tv.setText(st)
        ButtonCleaning = findViewById<View>(R.id.propertybtn) as LinearLayout
        ButtonAccepting = findViewById<View>(R.id.propertybtn1) as LinearLayout
        layout3 = findViewById<View>(R.id.propertybtn2) as LinearLayout
        layout4 = findViewById<View>(R.id.propertybtn4) as LinearLayout
        layout5 = findViewById<View>(R.id.acceptadvice) as LinearLayout
        layout3!!.setOnClickListener {
            val intent = Intent(this@SupplierHomePage, SupplierList::class.java)
            startActivity(intent)
        }
        layout4!!.setOnClickListener {
            val intent = Intent(this@SupplierHomePage, PendingDeepCleaningProperty::class.java)
            startActivity(intent)
        }
        layout5!!.setOnClickListener {
            val intent = Intent(this@SupplierHomePage, ProductList::class.java)
            startActivity(intent)
        }
        ButtonCleaning!!.setOnClickListener {
            val intent = Intent(this@SupplierHomePage, ProductList::class.java)
            startActivity(intent)
        }
        ButtonAccepting!!.setOnClickListener {
            val intent = Intent(this@SupplierHomePage, Acceptsupply::class.java)
            startActivity(intent)
        }
    }
}



}
