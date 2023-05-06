package com.example.myapplication

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class StatusProduct : AppCompatActivity() {

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

    var id: String? = null
    var photo:kotlin.String? = null
    var customer:kotlin.String? = null
    var OrganicalF1:kotlin.String? = null
    var OrganicalF2:kotlin.String? = null
    var PapSeed:kotlin.String? = null
    var total:kotlin.String? = null
    var OrganicalF3:kotlin.String? = null
    var PomeSeed:kotlin.String? = null
    var EggPSeed:kotlin.String? = null
    var CarrotSeed:kotlin.String? = null
    var status:kotlin.String? = null
    var Riceseed:kotlin.String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status_product)
        dbHelper = DBHelper(this)
        dbHelper!!.OpenDB()
        imageView = findViewById<View>(R.id.imageViewstatus) as ImageView
        text1 = findViewById<View>(R.id.OrganicalF1status) as TextView
        text2 = findViewById<View>(R.id.OrganicalF2status) as TextView
        text3 = findViewById<View>(R.id.OrganicalF3status) as TextView
        text4 = findViewById<View>(R.id.PapSeedstatus) as TextView
        text1 = findViewById<View>(R.id.PomeSeedstatus) as TextView
        text2 = findViewById<View>(R.id.EggPSeedstatus) as TextView
        text3 = findViewById<View>(R.id.CarrotSeedstatus) as TextView
        text4 = findViewById<View>(R.id.Riceseedstatus) as TextView
        textView1 = findViewById<View>(R.id.totalstatus) as TextView
        button = findViewById<View>(R.id.addstatus) as Button
        id = intent.getStringExtra("id")
        OrganicalF1 = intent.getStringExtra("OrganicalF1")
        OrganicalF2 = intent.getStringExtra("OrganicalF2")
        OrganicalF3 = intent.getStringExtra("OrganicalF3")
        PapSeed = intent.getStringExtra("PapSeed")
        PomeSeed = intent.getStringExtra("PomeSeed")
        EggPSeed = intent.getStringExtra("EggPSeed")
        Riceseed = intent.getStringExtra("Riceseed")
        CarrotSeed = intent.getStringExtra("CarrotSeed")
        total = intent.getStringExtra("total")
        photo = intent.getStringExtra("photo")
        status = intent.getStringExtra("status")
        customer = intent.getStringExtra("customer")
        val file: File = File(photo)
        val uri = Uri.fromFile(file)
        imageView!!.setImageURI(uri)
        text1!!.setText(OrganicalF1)
        text2!!.setText(OrganicalF2)
        text3!!.setText(OrganicalF3)
        text4!!.setText(PapSeed)
        text5!!.setText(PomeSeed)
        text6!!.setText(EggPSeed)
        text7!!.setText(CarrotSeed)
        text8!!.setText(Riceseed)
        textView1!!.setText(total)
        button!!.setOnClickListener {
            dbHelper!!.updateInfoFarmingProducts(id.toString(), "Accepted")
            Toast.makeText(this@StatusProduct, "Accepted", Toast.LENGTH_SHORT).show()
        }
    }

    private fun DBHelper(con: StatusProduct): DBHelper {

        return TODO("Provide the return value")
    }
}