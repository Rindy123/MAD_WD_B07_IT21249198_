package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class RegisterSupplierPage : ComponentActivity() {
    var EditTextUserName: EditText? = null
    var EditTextTel:EditText? = null
    var EditTextAddress:EditText? = null
    var EditTextPassword:EditText? = null
    var EditTextConfirmPassword:EditText? = null
    var ButtonRegister: Button? = null

    private var dbHelper: DBHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supplier_register_page)
        dbHelper = DBHelper(this, null)
        dbHelper!!.OpenDB()
        EditTextUserName = findViewById<View>(R.id.appCompatEditText) as EditText
        EditTextTel = findViewById<View>(R.id.appCompatEditText1) as EditText
        EditTextAddress = findViewById<View>(R.id.appCompatEditText2) as EditText
        EditTextPassword = findViewById<View>(R.id.appCompatEditText3) as EditText
        EditTextConfirmPassword = findViewById<View>(R.id.appCompatEditText4) as EditText
        ButtonRegister = findViewById<View>(R.id.appCompatButton) as Button
        ButtonRegister!!.setOnClickListener {
            if (EditTextUserName!!.text.toString().isEmpty() ||
                EditTextTel!!.getText().toString().isEmpty() ||
                EditTextAddress!!.getText().toString()
                    .isEmpty() || EditTextPassword!!.getText().toString()
                    .isEmpty() || EditTextConfirmPassword!!.getText().toString().isEmpty()
            ) {
                Toast.makeText(applicationContext, "Fields Can't be Blank", Toast.LENGTH_LONG)
                    .show()
            } else if (EditTextPassword!!.getText().toString().length < 5) {
                Toast.makeText(
                    applicationContext,
                    "Password must have more than 5 characters",
                    Toast.LENGTH_LONG
                ).show()
            } else if (EditTextTel!!.getText().toString().length < 10) {
                Toast.makeText(
                    applicationContext,
                    "Please Enter correct phone number",
                    Toast.LENGTH_LONG
                ).show()
            } else if (EditTextPassword!!.getText().toString() != EditTextConfirmPassword!!.getText()
                    .toString()
            ) {
                Toast.makeText(
                    applicationContext,
                    "Password and confirm password should match Login",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val supplier = Supplier(
                    EditTextUserName!!.getText().toString(),
                    EditTextTel!!.getText().toString(),
                    EditTextAddress!!.getText().toString(),
                    EditTextPassword!!.getText().toString()
                )
                if (dbHelper!!.RegisterSupplier(supplier)) {
                    Toast.makeText(applicationContext, "User Created", Toast.LENGTH_LONG).show()
                    val `in` = Intent(this@RegisterSupplierPage, LoginSupplierPage::class.java)
                    startActivity(`in`)
                } else {
                    Toast.makeText(applicationContext, "User Creation Failed", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }

    fun Login(view: View?) {
        val `in` = Intent(this, LoginSupplierPage::class.java)
        startActivity(`in`)
    }
}