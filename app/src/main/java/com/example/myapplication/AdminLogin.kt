package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AdminLogin : AppCompatActivity() {
    var EditTextUserName: EditText? = null
    var EditTextPassword: EditText? = null
    var ButtonLogin: Button? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login_page)
        EditTextUserName = findViewById<View>(R.id.appCompatEditText) as EditText
        EditTextPassword = findViewById<View>(R.id.appCompatEditText1) as EditText
        ButtonLogin = findViewById<View>(R.id.appCompatButton) as Button
        ButtonLogin!!.setOnClickListener {
            val username = EditTextUserName!!.text.toString()
            val password = EditTextPassword!!.text.toString()
            if (username.isEmpty()) {
                EditTextUserName!!.error = "User Name cannot be empty"
            } else if (password.isEmpty()) {
                EditTextPassword!!.error = "Password cannot be empty"
            } else if (username != "Pumuduxmaster" && password != "xmaster123") {
                Toast.makeText(
                    this@AdminLogin,
                    "Wrong Credentials. Check username and password again",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val `in` = Intent(this@AdminLogin, AdminHome::class.java)
                startActivity(`in`)
            }
        }
    }
}