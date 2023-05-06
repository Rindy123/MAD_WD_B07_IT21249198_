package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.Cursor

import android.widget.Toast

    object {
        fun InsertComment(
            customer: String?,
            toString: String,
            toString1: String,
            id: String?
        ): Any {
            TODO("Not yet implemented")
        }
    }

}

object Models {

}

public class DBHelper(private val con: Context, nothing: Nothing?) {
    private var db: SQLiteDatabase? = null
    fun OpenDB(): DBHelper {
        val dbCon = DBConnector(con)
        db = dbCon.writableDatabase
        db = dbCon.readableDatabase
        return this
    }

    fun RegisterCustomer(customer: Customer): Boolean {
        return try {
            val cv = ContentValues()
            cv.put("UserName", customer.getUserName())
            cv.put("Tel", customer.getTel())
            cv.put("Address", customer.getAddress())
            cv.put("Password", customer.getPassword())
            db!!.insert("customerInfo", null, cv)
            true
        } catch (ex: Exception) {
            Toast.makeText(con, ex.message, Toast.LENGTH_LONG).show()
            false
        }
    }

    fun RegisterSupplier(supplier: Supplier): Boolean {
        return try {
            val cv = ContentValues()
            cv.put("UserName", supplier.getUserName())
            cv.put("Tel", supplier.getTel())
            cv.put("Address", supplier.getAddress())
            cv.put("Password", supplier.getPassword())
            db!!.insert("supplierInfo", null, cv)
            true
        } catch (ex: Exception) {
            Toast.makeText(con, ex.message, Toast.LENGTH_LONG).show()
            false
        }
    }

    fun InsertProduct(product: Product): Boolean {
        return try {
            val cv = ContentValues()
            cv.put("OrganicalF1", product.getOrganicalF1())
            cv.put("OrganicalF2", product.getOrganicalF2())
            cv.put("OrganicalF3", product.getOrganicalF3())
            cv.put("PapSeed", product.getPapSeed())
            cv.put("PomeSeed", product.getPomeSeed())
            cv.put("Riceseed", product.getRiceseed())
            cv.put("CarrotSeed", product.getCarrotSeed())
            cv.put("EggPSeed", product.getEggPSeed())
            cv.put("TotalPrice", product.getTotalPrice())
            cv.put("Photo", product.getPhoto())
            cv.put("Status", product.getStatus())
            cv.put("Customer", product.getCustomer())
            db!!.insert("ProductsDetails", null, cv)
            true
        } catch (ex: Exception) {
            Toast.makeText(con, ex.message, Toast.LENGTH_LONG).show()
            false
        }
    }

    fun InsertComment(product: Models.InsertComment): Boolean {
        return try {
            val cv = ContentValues()
            cv.put("CustomerName", product.getCustomer())
            cv.put("SupplierName", product.getSupllier())
            cv.put("Comment", product.getComment())
            cv.put("JobId", product.getJobId())
            db!!.insert("comment", null, cv)
            true
        } catch (ex: Exception) {
            Toast.makeText(con, ex.message, Toast.LENGTH_LONG).show()
            false
        }
    }

    fun <DataRetriveProduct> getAllDataPendingProduct(): java.util.ArrayList<DataRetriveProduct>? {
        val arrayList: java.util.ArrayList<DataRetriveProduct> = java.util.ArrayList<DataRetriveProduct>()

        //query for select all info in databse
        val selectQuery = "SELECT * FROM ProductsDetails WHERE Status = 'CustomerAdded'"
        val dbCon = DBConnector(con)
        db = dbCon.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        //select all info from databes new gte the data from column
        if (cursor.moveToNext()) {
            do {
                val model = DataRetriveProduct(
                    cursor.getString(0).toInt(),
                    cursor.getString(1).toInt(),
                    cursor.getString(2).toInt(),
                    cursor.getString(3).toInt(),
                    cursor.getString(4).toInt(),
                    cursor.getString(5).toInt(),
                    cursor.getString(6).toInt(),
                    cursor.getString(7).toInt(),
                    cursor.getString(8).toInt(),
                    cursor.getString(9).toInt(),
                    cursor.getString(10),
                    cursor.getString(11),
                    cursor.getString(12)
                )
                arrayList.add(model)
            } while (cursor.moveToNext())
        }
        db.close()
        return arrayList
    }


    //query for select all info in databse
    val allDataSuppliers:

    //select all info from databes new gte the data from column
            ArrayList<Any>
        get() {
            val arrayList: ArrayList<SuppliersDataRetrive> = ArrayList<SuppliersDataRetrive>()

            //query for select all info in databse
            val selectQuery = "SELECT * FROM supplierInfo"
            val dbCon = DBConnector(con)
            db = dbCon.readableDatabase
            val cursor = db.rawQuery(selectQuery, null)

            //select all info from databes new gte the data from column
            if (cursor.moveToNext()) {
                do {
                    val model: SuppliersDataRetrive = SuppliersDataRetrive(
                        cursor.getString(0).toInt(),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                    )
                    arrayList.add(model)
                } while (cursor.moveToNext())
            }
            db.close()
            return arrayList
        }

    //query for select all info in databse
    val allDataCustomers:

    //select all info from databes new gte the data from column
            ArrayList<Any>
        get() {
            val arrayList: ArrayList<CustomersDataRetrive> = ArrayList<CustomersDataRetrive>()

            //query for select all info in databse
            val selectQuery = "SELECT * FROM customerInfo"
            val dbCon = DBConnector(con)
            db = dbCon.readableDatabase
            val cursor = db.rawQuery(selectQuery, null)

            //select all info from databes new gte the data from column
            if (cursor.moveToNext()) {
                do {
                    val model = CustomersDataRetrive(
                        cursor.getString(0).toInt(),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                    )
                    arrayList.add(model)
                } while (cursor.moveToNext())
            }
            db?.run { close() }
            return arrayList
        }

    fun deleteSupplier(id: String) {
        val dbCon = DBConnector(con)
        db = dbCon.writableDatabase
        println("IDDDDDDDDD   $id")
        db.delete("supplierInfo", "id" + " = ? ", arrayOf(id))
        db.close()
    }

    fun deleteCustomer(id: String) {
        val dbCon = DBConnector(con)
        db = dbCon.writableDatabase
        println("IDDDDDDDDD   $id")
        db.delete("customerInfo", "id" + " = ? ", arrayOf(id))
        db.close()
    }

    //query for select all info in databse
    val allDataAcceptedProducts:

    //select all info from databes new gte the data from column
            ArrayList<Any>
        get() {
            val arrayList: ArrayList<DataRetriveProduct> = ArrayList<DataRetriveProduct>()

            //query for select all info in databse
            val selectQuery = "SELECT * FROM ProductsDetails WHERE Status = 'Accepted'"
            val dbCon = DBConnector(con)
            db = dbCon.readableDatabase
            val cursor = db.rawQuery(selectQuery, null)

            //select all info from databes new gte the data from column
            if (cursor.moveToNext()) {
                do {
                    val model = DataRetriveProduct(
                        cursor.getString(0).toInt(),
                        cursor.getString(1).toInt(),
                        cursor.getString(2).toInt(),
                        cursor.getString(3).toInt(),
                        cursor.getString(4).toInt(),
                        cursor.getString(5).toInt(),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8)
                    )
                    arrayList.add(model)
                } while (cursor.moveToNext())
            }
            db.close()
            return arrayList
        }

    //query for select all info in databse
    val allDataFinishedProducts:

    //select all info from databes new gte the data from column
            ArrayList<Any>
        get() {
            val arrayList: ArrayList<DataRetriveProduct> = ArrayList<DataRetriveProduct>()

            //query for select all info in databse
            val selectQuery = "SELECT * FROM ProductsDetails WHERE Status = 'Finished'"
            val dbCon = DBConnector(con)
            db = dbCon.readableDatabase
            val cursor = db.rawQuery(selectQuery, null)

            //select all info from databes new gte the data from column
            if (cursor.moveToNext()) {
                do {
                    val model = DataRetriveProduct(
                        cursor.getString(0).toInt(),
                        cursor.getString(1).toInt(),
                        cursor.getString(2).toInt(),
                        cursor.getString(3).toInt(),
                        cursor.getString(4).toInt(),
                        cursor.getString(5).toInt(),
                        cursor.getString(6).toInt(),
                        cursor.getString(7).toInt(),
                        cursor.getString(8).toInt(),
                        cursor.getString(9).toInt(),
                        cursor.getString(11),
                        cursor.getString(12),
                        cursor.getString(13)
                    )
                    arrayList.add(model)
                } while (cursor.moveToNext())
            }
            db.close()
            return arrayList
        }

    //query for select all info in databse
    val allDataComments:

    //select all info from databes new gte the data from column
            ArrayList<Any>
        get() {
            val arrayList: ArrayList<InsertComment> = ArrayList<InsertComment>()

            //query for select all info in databse
            val selectQuery = "SELECT * FROM comment"
            val dbCon = DBConnector(con)
            db = dbCon.readableDatabase
            val cursor = db.rawQuery(selectQuery, null)

            //select all info from databes new gte the data from column
            if (cursor.moveToNext()) {
                do {
                    val model = InsertComment(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                    )
                    arrayList.add(model)
                } while (cursor.moveToNext())
            }
            db.close()
            return arrayList
        }

    fun updateInfoFarmingProducts(id: String, status: String?) {
        val dbCon = DBConnector(con)
        db = dbCon.writableDatabase
        val cv = ContentValues()
        cv.put("Status", status)
        db.run {
            this!!.update("ProductsDetails", cv, "id" + " = ?", arrayOf(id))
            close()
        }
    }

    fun updateInfoDoneProduct(id: String?, status: String?) {
        val dbCon = DBConnector(con)
        db = dbCon.writableDatabase
        val cv = ContentValues()
        cv.put("Status", status)
        db.run {
            this!!.update("ProductsDetails", cv, "id" + " = ?", arrayOf(id))
            close()
        }
    }

    fun updateSupplierInfo(
        id: String,
        name: String?,
        tel: String?,
        address: String?,
        password: String?
    ) {
        val dbCon = DBConnector(con)
        db = dbCon.writableDatabase
        val cv = ContentValues()
        cv.put("UserName", name)
        cv.put("Tel", tel)
        cv.put("Address", address)
        cv.put("Password", password)
        db.update("supplierInfo", cv, "id" + " = ?", arrayOf(id))
        db.close()
    }

    fun updateCustomerInfo(
        id: String,
        name: String?,
        tel: String?,
        address: String?,
        password: String?
    ) {
        val dbCon = DBConnector(con)
        db = dbCon.writableDatabase
        val cv = ContentValues()
        cv.put("UserName", name)
        cv.put("Tel", tel)
        cv.put("Address", address)
        cv.put("Password", password)
        db.update("customerInfo", cv, "id" + " = ?", arrayOf(id))
        db.close()
    }

    fun LoginCustomer(UserName: String, Password: String): ArrayList<customer> {
        val customerList: ArrayList<Customer> = ArrayList<Customer>()
        try {
            val cursor = db!!.rawQuery(
                "Select * from customerInfo where UserName='$UserName' and Password='$Password'",
                null
            )
            if (cursor.moveToFirst()) {
                do {
                    val customer = Customer(
                        customer.setUserName(cursor.getString(0))
                                customer.setPassword(cursor.getString(1))
                                customerList.add(customer)
                    )
                } while (cursor.moveToNext())
            }
        } catch (ex: Exception) {
            Toast.makeText(con, ex.message, Toast.LENGTH_LONG).show()
        }
        return customerList
    }

    fun LoginSupplier(UserName: String, Password: String): ArrayList<Supplier> {
        val userList: ArrayList<Supplier> = ArrayList<Supplier>()
        try {
            val cursor = db!!.rawQuery(
                "Select * from supplierInfo where UserName='$UserName' and Password='$Password'",
                null
            )
            if (cursor.moveToFirst()) {
                do {
                    val supplier = Supplier()
                    supplier.setUserName(cursor.getString(0))
                    supplier.setPassword(cursor.getString(1))
                    userList.add(supplier)
                } while (cursor.moveToNext())
            }
        } catch (ex: Exception) {
            Toast.makeText(con, ex.message, Toast.LENGTH_LONG).show()
        }
        return userList
    }

    fun getAllDataComments(): Any {
        TODO("Not yet implemented")
    }




}

