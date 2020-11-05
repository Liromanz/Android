package com.example.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "people.db", null, 1) {

    val TABLE_NAME = "people_table"
    val COL2 = "NAME"
    val COL3 = "EMAIL"

    private val DROP_USER_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable =
            "CREATE TABLE $TABLE_NAME (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, EMAIL TEXT, TVSHOW TEXT)"
        db?.execSQL(createTable);
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DROP_USER_TABLE)
        onCreate(db)
    }

    fun addData(name: String?, email: String?):Boolean
    {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL2,name)
        contentValues.put(COL3,email)
        val result = db.insert(TABLE_NAME,null, contentValues)
        return result != -1L;
    }

    fun showData(): Cursor?{
        val db = this.writableDatabase
        return  db.rawQuery("SELECT * FROM $TABLE_NAME",null)
    }

    fun poisk(id: Int?):Cursor
    {
        val db = this.writableDatabase
        return  db.rawQuery("SELECT * FROM $TABLE_NAME WHERE ID = $id",null)
    }

    fun delete(id: Int?):Boolean
    {
        val db = this.writableDatabase
        val count = db.delete(TABLE_NAME,"ID = $id" ,null)
        return count != 0
    }

    fun update(name: String?, Email:String?,id:Int?)
    {
        var cv = ContentValues()
        cv.put(COL2,name)
        cv.put(COL3,Email)
        var db = this.writableDatabase
        db.update(TABLE_NAME,cv,"ID = $id",null)
    }
}