package com.example.cosscan

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context:Context): SQLiteOpenHelper(context, "cosscan", null, 1 ) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE INGREDIENTS(INGID INTEGER PRIMARY KEY AUTOINCREMENT, ING TEXT) ")
        db?.execSQL("CREATE TABLE INGREDIENTS1(INGID INTEGER PRIMARY KEY AUTOINCREMENT, ING TEXT) ")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS INGREDIENTS")
        db!!.execSQL("DROP TABLE IF EXISTS INGREDIENTS1")
        onCreate(db)

    }

    fun insertIng(ing: String): Long{

        var db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("ING", ing)
        val success = db.insert("INGREDIENTS", null, contentValues)
        db.close()
        return success
    }


    fun drop(){
        var db = this.writableDatabase
        val contentValues = ContentValues()
        onUpgrade(db,1,1)

    }


    fun getAllING(): ArrayList<String> {
        val list: ArrayList<String> = ArrayList()
        val selectQuery = "SELECT ING FROM INGREDIENTS"
        val db = this.readableDatabase
        val cursor: Cursor?
        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: Exception){
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var ing:String
        if(cursor.moveToFirst()){
            do{
                ing = cursor.getString(cursor.getColumnIndexOrThrow("ING"))
                list.add(ing)

            }while(cursor.moveToNext())
        }
        return list





    }


}

