package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView

class ManageCustomers: ComponentActivity() {

    ///
    var mRecyclerView: RecyclerView? = null
    var databaseHelper: DBHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_customers)
        mRecyclerView = findViewById<View>(R.id.recylceView) as RecyclerView
        databaseHelper = DBHelper(this@ManageCustomers)
        showRercord()
    }

    fun showRercord() {
        val adapter: customerAdapterAdmin =
            CustomerAdapterAdmin(this@ManageCustomers, databaseHelper.getAllDataCustomers())
        mRecyclerView!!.adapter = adapter
    }

    public override fun onResume() {
        super.onResume()
        showRercord()
    }
}