package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class SupplierList:AppCompatActivity() {
    var mRecyclerView: RecyclerView? = null
    var databaseHelper: DBHelper? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supplier_list)
        mRecyclerView = findViewById<View>(R.id.recylceView) as RecyclerView
        databaseHelper = DBHelper(this@SupplierList)
        showRercord()
    }

    private fun DBHelper(con: SupplierList): DBHelper {

        return TODO("Provide the return value")
    }

    fun showRercord() {
        val adapter = CommentsAdapter(this@SupplierList,
            databaseHelper!!.getAllDataComments() as ArrayList<Any>
        )
        mRecyclerView!!.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        showRercord()
    }
}