package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class AddComment : AppCompatActivity() {
    var id: String? = null
    var customer: String? = null
    var editText1: AppCompatEditText? = null
    var textView1: TextView? = null
    var button: AppCompatButton? = null
    private var dbHelper: DBHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_comment)
        dbHelper = DBHelper(this, null)
        dbHelper!!.OpenDB()
        id = intent.getStringExtra("id")
        customer = intent.getStringExtra("customer")
        editText1 = findViewById<View>(R.id.appCompatEditText) as AppCompatEditText
        textView1 = findViewById<View>(R.id.name) as TextView
        button = findViewById<View>(R.id.appCompatButton) as AppCompatButton
        button!!.setOnClickListener {
            if (editText1!!.text.toString().isEmpty()) {
                editText1!!.error = "Comment required"
            } else {
                val comment = InsertComment(
                    customer,
                    textView1!!.getText().toString(),
                    editText1!!.getText().toString(),
                    id
                )
                System.out.println(comment)
                if (dbHelper!!.InsertComment(comment)) {
                    Toast.makeText(
                        applicationContext,
                        "Comment added Successfully",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(applicationContext, "Comment adding Failed", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }

    private fun InsertComment(customer: String?, toString: String, toString1: String, id: String?): Any {

        return TODO("Provide the return value")
    }
}