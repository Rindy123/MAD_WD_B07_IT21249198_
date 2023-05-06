package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class SupplierAdapterAdmin(
    private val context: Context,
    arrayList: ArrayList<SuppliersDataRetrive>
) :
    RecyclerView.Adapter<SupplierAdapterAdmin.Holder>() {
    private val arrayList: ArrayList<SuppliersDataRetrive>

    //database object
    var databaseHelper: DBHelper

    init {
        this.arrayList = arrayList

        //inisialize dbheler
        databaseHelper = DBHelper(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_users, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val model: SuppliersDataRetrive = arrayList[position]
        //get for view
        val id: Int = model.getId()
        val name: String = model.getUserName()
        val tel: String = model.getTel()
        val address: String = model.getAddress()
        val password: String = model.getPassword()

        //set views
        holder.Name.text = name
        holder.tel.text = tel
        holder.address.text = address
        holder.itemView.setOnClickListener {
            val builder1 = AlertDialog.Builder(
                context
            )
            builder1.setMessage("Choose your option!")
            builder1.setCancelable(true)
            builder1.setPositiveButton(
                "Update"
            ) { dialog, id ->
                val intent = Intent(context, EditCleanerInfo::class.java)
                intent.putExtra("id", java.lang.String.valueOf(model.getId()))
                intent.putExtra("name", model.getUserName())
                intent.putExtra("tel", model.getTel())
                intent.putExtra("address", model.getAddress())
                intent.putExtra("password", model.getPassword())
                context.startActivity(intent)
            }
            builder1.setNegativeButton(
                "cancel"
            ) { dialog, id -> dialog.cancel() }
            val alert11 = builder1.create()
            alert11.show()
        }
        holder.itemView.setOnLongClickListener {
            DeleteItem(
                "" + id
            )
            false
        }
    }

    private fun DeleteItem(id: String) {
        val builder = android.app.AlertDialog.Builder(context)
        builder.setTitle("Delete")
        builder.setMessage("Are you want to delete ?")
        builder.setCancelable(false)
        builder.setIcon(R.drawable.delete)
        builder.setPositiveButton(
            "Yes"
        ) { dialog, which ->
            databaseHelper.deleteSupplier(id)
            (context as ManageSuppliers).onResume()
            Toast.makeText(context, "Delete Successful", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton(
            "No"
        ) { dialog, which -> dialog.cancel() }
        builder.create().show()
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    internal class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Name: TextView
        var tel: TextView
        var address: TextView
        var imageView: ImageView

        init {
            Name = itemView.findViewById(R.id.name)
            tel = itemView.findViewById(R.id.tel)
            address = itemView.findViewById(R.id.address)
            imageView = itemView.findViewById(R.id.prop)
        }
    }
}
