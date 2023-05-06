package com.example.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBConnector(context: Context?) :
    SQLiteOpenHelper(context, "MyDb.db", null, 1) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL("create table supplierInfo(id INTEGER PRIMARY KEY AUTOINCREMENT, UserName VARCHAR UNIQUE, Tel VARCHAR, Address VARCHAR, Password VARCHAR)")
        sqLiteDatabase.execSQL("create table customerInfo(id INTEGER PRIMARY KEY AUTOINCREMENT, UserName VARCHAR UNIQUE, Tel VARCHAR, Address VARCHAR, Password VARCHAR)")
        sqLiteDatabase.execSQL("create table comment(id INTEGER PRIMARY KEY AUTOINCREMENT,OwnerName VARCHAR,SupplierName VARCHAR, Comment VARCHAR, supId String)")
        sqLiteDatabase.execSQL("create table ProductDetails(id INTEGER PRIMARY KEY AUTOINCREMENT,OrganicalF1 INTEGER, OrganicalF2 INTEGER,OrganicalF3 INTEGER,PapSeed INTEGER, PomeSeed INTEGER,EggPSeed INTEGER,CarrotSeed, Riceseed INTEGER,TotalPrice INTEGER, Photo VARCHAR, Status VARCHAR, Owner VARCHAR)")
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {}
}

