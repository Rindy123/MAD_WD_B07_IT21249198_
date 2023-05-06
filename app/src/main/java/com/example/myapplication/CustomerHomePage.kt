package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

public class CustomerHomePage : AppCompatActivity(){
    var st: String? = null
    var tv: TextView? = null
    var ButtonPending: LinearLayout? = null
    var ButtonFinished:LinearLayout? = null
    var ButtonServant:LinearLayout? = null
    var ButtonDeepCleaning:LinearLayout? = null
    var ButtonAdvice:LinearLayout?=null
    var Button: ImageView? = null

    private var dbHelper: DBHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_home_page)
        dbHelper = DBHelper(this, null)
        dbHelper!!.OpenDB()
        tv = findViewById(R.id.textView1)
        st = intent.extras!!.getString("username")
        tv.run { this?.setText(st) }
        ButtonPending = findViewById<View>(R.id.propertybtn1) as LinearLayout
        ButtonFinished = findViewById<View>(R.id.propertybtn) as LinearLayout
        ButtonServant = findViewById<View>(R.id.propertybtn2) as LinearLayout
        ButtonDeepCleaning = findViewById<View>(R.id.propertybtn4) as LinearLayout
        ButtonAdvice = findViewById<View>(R.id.acceptadvice) as LinearLayout
        Button!!.setOnClickListener {
            val intent = Intent(this@CustomerHomePage, AddProduct::class.java)
            intent.putExtra("username", tv.getText().toString())
            startActivity(intent)
        }
        ButtonPending!!.setOnClickListener {
            st = intent.extras!!.getString("username")
            val intent = Intent(this@CustomerHomePage, PendingProduct::class.java)
            //                 intent.putExtra("username",st);
            startActivity(intent)
        }
        ButtonFinished!!.setOnClickListener(View.OnClickListener {
            st = intent.extras!!.getString("username")
            val intent = Intent(this@CustomerHomePage, FinishedProduct::class.java)
            // intent.putExtra("username",st);
            startActivity(intent)
        })
        ButtonServant!!.setOnClickListener(View.OnClickListener {
            st = intent.extras!!.getString("username")
            val intent = Intent(this@CustomerHomePage, SupplierList::class.java)
            intent.putExtra("username", st)
            startActivity(intent)
        })
        ButtonDeepCleaning!!.setOnClickListener(View.OnClickListener {
            st = intent.extras!!.getString("username")
            val intent = Intent(this@CustomerHomePage, AddComment::class.java)
            intent.putExtra("username", st)
            startActivity(intent)
        })
    }
}


