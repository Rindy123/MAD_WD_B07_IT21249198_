package com.example.myapplication

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import java.io.File


class DoneProduct(var id: String? = null, var total: String? = null, var OrganicalF1: String? = null,var OrganicalF2: String? = null,var OrganicalF3: String? = null,var PapSeed: String? = null,var PomeSeed: String? = null,var EggPSeed: String? = null,var CarrotSeed: String? = null,var photo: String? = null,var customer: String? = null,var Riceseed: String? = null,var status: String? = null) : ComponentActivity() {
    var imageView: ImageView? = null
    var text1: TextView? = null
    var text2: TextView? = null
    var text3: TextView? = null
    var text4: TextView? = null
    var text5: TextView? = null
    var text6: TextView? = null
    var text7: TextView? = null
    var text8: TextView? = null
    var textView1: TextView? = null
    var button: Button? = null
    private var dbHelper: DBHelper? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_myorders)
        dbHelper = DBHelper(this, null)
        dbHelper!!.OpenDB()

        imageView = findViewById<View>(R.id.imageViewfi) as ImageView
        text1 = findViewById<View>(R.id.OrganicalF1fi) as TextView
        text2 = findViewById<View>(R.id.OrganicalF2fi) as TextView
        text3 = findViewById<View>(R.id.OrganicalF3fi) as TextView
        text4 = findViewById<View>(R.id.PapSeedfi) as TextView
        text5 = findViewById<View>(R.id.PomeSeedfi) as TextView
        text6 = findViewById<View>(R.id.EggPSeedfi) as TextView
        text7 = findViewById<View>(R.id.CarrotSeedfi) as TextView
        text8 = findViewById<View>(R.id.Riceseedfi) as TextView
        textView1 = findViewById<View>(R.id.totfi) as TextView
        button = findViewById<View>(R.id.finish) as Button

        id = intent.getStringExtra("id")
        OrganicalF1 = intent.getStringExtra("Organical fertillzer packet(5Kg)")
        OrganicalF2 = intent.getStringExtra("Organical fertillzer packet(1Kg)")
        OrganicalF3 = intent.getStringExtra("Organical fertillzer packet(500g)") /* !!! Hit visitElement for element type: class org.jetbrains.kotlin.nj2k.tree.JKErrorExpression !!! */
        PapSeed = intent.getStringExtra("Papaya seeds")
        PomeSeed = intent.getStringExtra("Pomegrante seeds")
        EggPSeed = intent.getStringExtra("Egg plant seeds")
        CarrotSeed = intent.getStringExtra("Carrot seeds")
        Riceseed = intent.getStringExtra("Rice seeds")
        total = intent.getStringExtra("total")
        photo = intent.getStringExtra("photo")
        status = intent.getStringExtra("status")
        customer = intent.getStringExtra("customer")

        val file: File = File(photo)
        val uri = Uri.fromFile(file)
        imageView!!.setImageURI(uri)
        text1!!.setText(OrganicalF2)
        text2!!.setText(OrganicalF2)
        text3!!.setText(OrganicalF3)
        text4!!.setText(PapSeed)
        text5!!.setText(PomeSeed)
        text6.setText(EggPSeed)
        text7.setText(CarrotSeed)
        text8.setText(Riceseed)
        textView1!!.text = total
        button!!.setOnClickListener {
            dbHelper!!.updateInfoDoneProduct(id, "Finished")
            Toast.makeText(this@DoneProduct, "Finished", Toast.LENGTH_SHORT).show()
        }
    }
}
