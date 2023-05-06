package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class LoginSupplierPage: ComponentActivity() {
    var EditTextUserName: EditText? = null
    var EditTextPassword:EditText? = null
    var ButtonLogin: Button? = null
    var st: String? = null

    private var dbHelper: DBHelper? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supplier_login_page)
        dbHelper = DBHelper(this, null)
        dbHelper!!.OpenDB()
        EditTextUserName = findViewById<View>(R.id.appCompatEditText) as EditText
        EditTextPassword = findViewById<View>(R.id.appCompatEditText1) as EditText
        ButtonLogin = findViewById<View>(R.id.appCompatButton) as Button
        ButtonLogin!!.setOnClickListener {
            st = EditTextUserName!!.text.toString()
            val userDetails = dbHelper!!.LoginSupplier(
                EditTextUserName!!.text.toString(),
                EditTextPassword!!.getText().toString()
            )
            if (userDetails.size != 0) {
                val supplier = userDetails[0]
                Toast.makeText(applicationContext, "Valid User", Toast.LENGTH_LONG).show()
                val intent = Intent(this@LoginSupplierPage, SupplierHomePage::class.java)
                intent.putExtra("username", st)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Invalid User", Toast.LENGTH_LONG).show()
            }
        }
    }


    fun SignIn(view: View?) {
        val `in` = Intent(this, RegisterSupplierPage::class.java)
        startActivity(`in`)
    }
}