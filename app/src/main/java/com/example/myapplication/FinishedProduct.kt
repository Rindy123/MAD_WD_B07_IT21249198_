package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class FinishedProduct {
    class FinishedProperty : AppCompatActivity() {
        var mRecyclerView: RecyclerView? = null
        var databaseHelper: DBHelper? = null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_finished_product)
            mRecyclerView = findViewById<View>(R.id.recylceView) as RecyclerView
            databaseHelper = DBHelper(this@FinishedProperty)
            showRercord()
        }

        fun showRercord() {
            val adapter = CustomerFinishedProductAdapter(
                this@FinishedProperty,
                databaseHelper.getAllDataFinishedProduct()
            )
            mRecyclerView!!.adapter = adapter
        }

        public override fun onResume() {
            super.onResume()
            showRercord()
        }
    }