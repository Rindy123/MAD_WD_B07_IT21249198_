package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView

class PendingProduct : ComponentActivity(){
    var mRecyclerView: RecyclerView? = null
    var databaseHelper: DBHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pending_product)
        mRecyclerView = findViewById<View>(R.id.recylceView) as RecyclerView
        databaseHelper = DBHelper(this@PendingProduct)
        showRercord()
    }

    fun showRercord() {
        val adapter = Adapter(this@PendingProduct, databaseHelper.getAllDataPendingProduct())
        mRecyclerView!!.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        showRercord()
    }
}
