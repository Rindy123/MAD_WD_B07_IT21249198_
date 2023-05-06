package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentsAdapter(private val context: Context, arrayList: ArrayList<InsertComment>) :
    RecyclerView.Adapter<CommentsAdapter.Holder>() {
    private val arrayList: ArrayList<InsertComment>

    //database object
    var databaseHelper: DBHelper

    init {
        this.arrayList = arrayList

        //inisialize dbhelper
        databaseHelper = DBHelper(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.custom_supplier_comment, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val model: InsertComment = arrayList[position]
        //get for view
        val owner: String = model.getOwner()
        val cleaner: String = model.getCleaner()
        val comment: String = model.getComment()

        //set views
        holder.Name.text = cleaner
        holder.comment.text = comment
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Name: TextView
        var comment: TextView

        init {
            Name = itemView.findViewById<TextView>(R.id.suppliername)
            comment = itemView.findViewById<TextView>(R.id.comment)
        }
    }
}