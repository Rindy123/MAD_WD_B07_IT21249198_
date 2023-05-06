package com.example.myapplication

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import java.io.File;
import java.util.ArrayList;

class Adapter(private val context: Context, arrayList: ArrayList<DataRetriveProduct>) :
    RecyclerView.Adapter<com.example.myapplication.Adapters.Adapter.Holder>() {
    private val arrayList: ArrayList<DataRetriveProduct>

    //database object
    var databaseHelper: DBHelper

    init {
        this.arrayList = arrayList

        //inisialize dbhelper
        databaseHelper = DBHelper(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.activity_pending_product, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val model: DataRetriveProduct = arrayList[position]
        //get for view
        val id: Int = model.getId()
        val OrganicalF1: Int = model.getOrganicalF1()
        val OrganicalF2: Int = model.getOrganicalF2()
        val OrganicalF3: Int = model.getOrganicalF3()
        val PapSeed: Int = model.getPapSeed()
        val PomeSeed: Int = model.getPomeSeed()
        val EggPSeed: Int = model.getEggPSeed()
        val CarrotSeed: Int = model.getCarrotSeed()
        val Riceseed: Int = model.getRiceseed()
        val total: Int = model.getTotal()
        val photo: String = model.getPhoto()
        val status: String = model.getStatus()
        val owner: String = model.getOwner()

        //set views
        holder.Name.text = owner
        val file = File(photo)
        val uri = Uri.fromFile(file)
        holder.imageView.setImageURI(uri)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Name: TextView
        var imageView: ImageView

        init {
            Name = itemView.findViewById<TextView>(R.id.name)
            imageView = itemView.findViewById<ImageView>(R.id.prop)
        }
    }
}
