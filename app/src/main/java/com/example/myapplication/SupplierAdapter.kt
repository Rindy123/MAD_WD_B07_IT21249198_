package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class SupplierAdapter(private val context: Context, arrayList: ArrayList<DataRetriveProduct>) :
    RecyclerView.Adapter<SupplierAdapter.Holder>() {
    private val arrayList: ArrayList<DataRetriveProduct>

    //database object
    var databaseHelper: DBHelper

    init {
        this.arrayList = arrayList

        //inisialize dbheler
        databaseHelper = DBHelper(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
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
        val customer: String = model.getCustomer()

        //set views
        holder.Name.text = customer
        val file = File(photo)
        val uri = Uri.fromFile(file)
        holder.imageView.setImageURI(uri)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, StatusProperty::class.java)
            intent.putExtra("id", java.lang.String.valueOf(model.getId()))
            intent.putExtra("OrganicalF1", java.lang.String.valueOf(model.getOrganicalF1()))
            intent.putExtra("OrganicalF2", java.lang.String.valueOf(model.getOrganicalF2()))
            intent.putExtra("OrganicalF3", java.lang.String.valueOf(model.getOrganicalF3()))
            intent.putExtra("PapSeed", java.lang.String.valueOf(model.getPapSeed()))
            intent.putExtra("PomeSeed", java.lang.String.valueOf(model.getPomeSeed()))
            intent.putExtra("EggPSeed", java.lang.String.valueOf(model.getEggPSeed()))
            intent.putExtra("CarrotSeed", java.lang.String.valueOf(model.getCarrotSeed()))
            intent.putExtra("Riceseed", java.lang.String.valueOf(model.getRiceseed()))
            intent.putExtra("total", java.lang.String.valueOf(model.getTotal()))
            intent.putExtra("photo", model.getPhoto())
            intent.putExtra("status", model.getStatus())
            intent.putExtra("customer", model.getCustomer())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Name: TextView
        var imageView: ImageView

        init {
            Name = itemView.findViewById<TextView>(R.id.name)
            imageView = itemView.findViewById<ImageView>(R.id.prop)
        }
    }
}
