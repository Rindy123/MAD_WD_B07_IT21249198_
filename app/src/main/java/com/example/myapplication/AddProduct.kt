package com.example.myapplication

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.analytics.ecommerce.Product
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.DexterError
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.PermissionRequestErrorListener
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AddProduct : AppCompatActivity(){

    var imageView: ImageView? = null
    var editText1: EditText? = null
    var editText2: EditText? = null
    var editText3: EditText? = null
    var editText4: EditText? = null
    var editText5: EditText? = null
    var editText6: EditText? = null
    var editText7: EditText? = null
    var editText8: EditText? = null
    var textView1: TextView? = null
    var textView2: TextView? = null
    var button: Button? = null
    var name: String? = null
    var photoPath: String? = null
    var status = "CustomerAdded"
    private val GALLERY = 1
    private  val CAMERA: Int = 2
    private var dbHelper: DBHelper? = null
    private val RESULT_CANCELED: Any?
        get() {
            TODO()
        }
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_add_product)
        val iin: Intent = getIntent()
        val b = iin.extras
        if (b != null) {
            name = b["username"] as String?
        }
        dbHelper = DBHelper(this, null)
        dbHelper!!.OpenDB()
        imageView = findViewById<View>(R.id.imageView) as ImageView
        editText1 = findViewById<View>(R.id.OrganicalF1) as EditText
        editText2 = findViewById<View>(R.id.OrganicalF2) as EditText
        editText3 = findViewById<View>(R.id.OrganicalF3) as EditText
        editText4 = findViewById<View>(R.id.PapSeed) as EditText
        editText5 = findViewById<View>(R.id.PomeSeed) as EditText
        editText2 = findViewById<View>(R.id.EggPSeed) as EditText
        editText3 = findViewById<View>(R.id.CarrotSeed) as EditText
        editText4 = findViewById<View>(R.id.Riceseed) as EditText
        textView1 = findViewById<View>(R.id.total) as TextView
        textView2 = findViewById<View>(R.id.calPrice) as TextView
        button = findViewById<View>(R.id.savebtn) as Button
        /**
         * call image capture button */
        requestMultiplePermissions()
        imageView!!.setOnClickListener { showPictureDialog() }
        textView2!!.setOnClickListener {
            if (editText1!!.text.toString().isEmpty()) {
                editText1!!.error = "Number of Organical fertillzer packet(5Kg) required"
            } else if (editText2!!.text.toString().isEmpty()) {
                editText2!!.error = "Number of Organical fertillzer packet(1Kg) required"
            } else if (editText3!!.text.toString().isEmpty()) {
                editText3!!.error = "Number of Organical fertillzer packet(500g) required"
            } else if (editText4!!.text.toString().isEmpty()) {
                editText4!!.error = "Number of Papaya seeds required"
            } else if (editText5!!.text.toString().isEmpty()) {
                editText5!!.error = "Number of Pomegrante seeds required"
            } else if (editText6!!.text.toString().isEmpty()) {
                editText6!!.error = "Number of Egg plant seeds required"
            } else if (editText7!!.text.toString().isEmpty()) {
                editText7!!.error = "Number of Carrot seeds required"
            } else if (editText8!!.text.toString().isEmpty()) {
                editText8!!.error = "Number of Rice seeds required"
            } else {
                val OrganicalF1 = editText1!!.text.toString().toInt() * 800
                val OrganicalF2 = editText2!!.text.toString().toInt() * 160
                val OrganicalF3 = editText3!!.text.toString().toInt() * 80
                val PapSeed = editText4!!.text.toString().toInt() * 150
                val PomeSeed = editText5!!.text.toString().toInt() * 180
                val EggPSeed = editText6!!.text.toString().toInt() * 150
                val CarrotSeed = editText7!!.text.toString().toInt() * 200
                val Riceseed = editText8!!.text.toString().toInt() * 150
                val total =
                    OrganicalF1 + OrganicalF2 + OrganicalF3 + PapSeed + PomeSeed + EggPSeed + CarrotSeed + Riceseed
                val finalamout = total.toString()
                textView1!!.text = finalamout
            }
        }
        button!!.setOnClickListener {
            if (editText1!!.text.toString().isEmpty()) {
                editText1!!.error = "Number of Organical fertillzer packet(5Kg) required"
            } else if (editText2!!.text.toString().isEmpty()) {
                editText2!!.error = "Number of Organical fertillzer packet(1Kg) required"
            } else if (editText3!!.text.toString().isEmpty()) {
                editText3!!.error = "Number of fertillzer packet(500g) required"
            } else if (editText4!!.text.toString().isEmpty()) {
                editText4!!.error = "Number of Papaya seeds required"
            } else if (editText5!!.text.toString().isEmpty()) {
                editText5!!.error = "Number of Pomegrante seeds required"
            } else if (editText6!!.text.toString().isEmpty()) {
                editText6!!.error = "Number of Egg plant seeds required"
            } else if (editText7!!.text.toString().isEmpty()) {
                editText7!!.error = "Number of Carrot seeds required"
            } else if (editText8!!.text.toString().isEmpty()) {
                editText8!!.error = "Number of Rice seeds required"
            } else {
                val OrganicalF1 = editText1!!.text.toString().toInt()
                val OrganicalF2 = editText2!!.text.toString().toInt()
                val OrganicalF3 = editText3!!.text.toString().toInt()
                val PapSeed = editText4!!.text.toString().toInt()
                val PomeSeed = editText5!!.text.toString().toInt()
                val EggPSeed = editText6!!.text.toString().toInt()
                val CarrotSeed = editText7!!.text.toString().toInt()
                val Riceseed = editText8!!.text.toString().toInt()
                val total = textView1!!.text.toString().toInt()
                val sdf = SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH)
                val filename = sdf.format(Date())
                try {
                    val path: String = getApplicationContext().getFilesDir().getPath()
                    var fOut: OutputStream? = null
                    val file = File(path, "MYFile")
                    if (!file.exists()) {
                        file.mkdirs()
                    }
                    val file2 = File(file, "$filename.png")
                    try {
                        fOut = FileOutputStream(file2)
                    } catch (e: FileNotFoundException) {
                        e.printStackTrace()
                    }
                    val drawable = imageView!!.drawable as BitmapDrawable
                    val bitmap = drawable.bitmap
                    //Bitmap test = imageview.obtainBitmap();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut)
                    fOut!!.flush()
                    fOut.close()
                    println(file2)
                    println(file2.name)
                    photoPath = file2.toString()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                val product = Product(
                    OrganicalF1,
                    OrganicalF2,
                    OrganicalF3,
                    PapSeed,
                    PomeSeed,
                    EggPSeed,
                    CarrotSeed,
                    Riceseed,
                    total,
                    photoPath,
                    status,
                    name
                )
                System.out.println(product)
                if (dbHelper!!.InsertProduct(product)) {
                    Toast.makeText(
                        getApplicationContext(),
                        "Products added Successfully",
                        Toast.LENGTH_LONG
                    ).show()
                    val `in` = Intent(this@AddProduct, CustomerHomePage::class.java)
                    startActivity(`in`)
                } else {
                    Toast.makeText(
                        getApplicationContext(),
                        "Products adding Failed",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun Product(
        organicalF1: Int,
        organicalF2: Int,
        organicalF3: Int,
        papSeed: Int,
        pomeSeed: Int,
        eggPSeed: Int,
        carrotSeed: Int,
        riceseed: Int,
        total: Int,
        photoPath: String?,
        status: String,
        name: String?
    ): Product {
        TODO("Not yet implemented")
    }

    /**
     * access camere and gallery */
    private fun showPictureDialog() {
        val pictureDialog = AlertDialog.Builder(this)
        pictureDialog.setTitle("Select Action")
        val pictureDialogItems = arrayOf(
            "Select photo from gallery",
            "Capture photo from camera"
        )
        pictureDialog.setItems(
            pictureDialogItems
        ) { dialog, which ->
            when (which) {
                0 -> choosePhotoFromGallary()
                1 -> takePhotoFromCamera()
            }
        }
        pictureDialog.show()
    }

    fun choosePhotoFromGallary() {
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        startActivityForResult(galleryIntent, GALLERY)
    }

    private fun takePhotoFromCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == this.RESULT_CANCELED) {
            return
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                val contentURI = data.data
                try {
                    val bitmap =
                        MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI)
                    //                    photo = saveImage(bitmap);
                    Toast.makeText(this, "Image Saved Successfully", Toast.LENGTH_SHORT).show()
                    imageView!!.setImageBitmap(bitmap)
                    println("MACHAN$bitmap")
                    //                    photo=saveImage(bitmap);
                } catch (e: IOException) {
                    e.printStackTrace()
                    Toast.makeText(this, "Image Saved Failed", Toast.LENGTH_SHORT).show()
                }
            }
        } else if (requestCode == CAMERA) {
            val thumbnail = data!!.extras!!["data"] as Bitmap?
            imageView!!.setImageBitmap(thumbnail)
            //            photo=saveImage(thumbnail);
            println("MACHAN$thumbnail")
            Toast.makeText(this, "Image Saved Successfully", Toast.LENGTH_SHORT).show()
        }
    }

    private fun requestMultiplePermissions() {
        Dexter.withActivity(this)
            .withPermissions(
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                    // check if all permissions are granted
                    if (report.areAllPermissionsGranted()) {
                        Toast.makeText(
                            getApplicationContext(),
                            "All permissions are granted by user!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    // check for permanent denial of any permission
                    if (report.isAnyPermissionPermanentlyDenied()) {
                        // show alert dialog navigating to Settings
                        //openSettingsDialog();
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest?>?,
                    token: PermissionToken
                ) {
                    token.continuePermissionRequest()
                }
            }).withErrorListener(object : PermissionRequestErrorListener {
                override fun onError(error: DexterError?) {
                    Toast.makeText(getApplicationContext(), "Some Error! ", Toast.LENGTH_SHORT)
                        .show()
                }
            })
            .onSameThread()
            .check()
    }
}
