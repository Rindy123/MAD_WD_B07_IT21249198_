package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class EditSupplierInfo : ComponentActivity(){
    var EditTextUserName: EditText? = null
    var EditTextTel:EditText? = null
    var EditTextAddress:EditText? = null
    var EditTextPassword:EditText? = null
    var EditTextConfirmPassword:EditText? = null
    var ButtonRegister: Button? = null

    private var dbHelper: DBHelper? = null

    var id: String? = null
    var name:kotlin.String? = null
    var tel:kotlin.String? = null
    var address:kotlin.String? = null
    var password:kotlin.String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_suplier_info)
        dbHelper = DBHelper(this)
        dbHelper!!.OpenDB()
        EditTextUserName = findViewById<View>(R.id.appCompatEditText) as EditText
        EditTextTel = findViewById<View>(R.id.appCompatEditText1) as EditText
        EditTextAddress = findViewById<View>(R.id.appCompatEditText2) as EditText
        EditTextPassword = findViewById<View>(R.id.appCompatEditText3) as EditText
        ButtonRegister = findViewById<View>(R.id.appCompatButton) as Button
        id = intent.getStringExtra("id")
        name = intent.getStringExtra("name")
        tel = intent.getStringExtra("tel")
        address = intent.getStringExtra("address")
        password = intent.getStringExtra("password")
        EditTextUserName.setText(name)
        EditTextTel.setText(tel)
        EditTextAddress.setText(address)
        EditTextPassword.setText(password)
        ButtonRegister!!.setOnClickListener {
            if (EditTextUserName!!.text.toString().isEmpty() || EditTextTel.getText().toString()
                    .isEmpty() || EditTextAddress.getText().toString()
                    .isEmpty() || EditTextPassword.getText().toString().isEmpty()
            ) {
                Toast.makeText(applicationContext, "Fields Can't be Blank", Toast.LENGTH_LONG)
                    .show()
            } else if (EditTextPassword.getText().toString().length < 5) {
                Toast.makeText(
                    applicationContext,
                    "Password must have more than 5 characters",
                    Toast.LENGTH_LONG
                ).show()
            } else if (EditTextTel.getText().toString().length < 10) {
                Toast.makeText(
                    applicationContext,
                    "Please Enter correct phone number",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                dbHelper.updateCleanerInfo(
                    id,
                    EditTextUserName!!.text.toString(),
                    EditTextTel.getText().toString(),
                    EditTextAddress.getText().toString(),
                    EditTextPassword.getText().toString()
                )
                Toast.makeText(this@EditCleanerInfo, "Updated", Toast.LENGTH_SHORT).show()
            }
        }
    }

}