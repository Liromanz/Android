package com.example.pract7_sqllite

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.sqlite.DatabaseHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var peopleDB: DatabaseHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.peopleDB = DatabaseHelper(this@MainActivity)
        btnAdd.setOnClickListener { addUser() }
        btnShow.setOnClickListener { showUsers() }

        btnDelete.setOnClickListener { deleteUsers() }
        btnRefresh.setOnClickListener { updateUsers() }
    }

    private fun updateUsers() {
        peopleDB!!.update(edtName.text.toString(),edtEmail.text.toString(),ID.text.toString().toInt())
        Toast.makeText(this, "Данные обновлены", Toast.LENGTH_SHORT).show()
    }

    private fun deleteUsers() {
        val data = peopleDB!!.poisk(ID.text.toString().toInt())
        val buffer = StringBuffer()
        while(data.moveToNext())
        {
            buffer.append("ID: ${data.getString(0)} \n")
            buffer.append("Name: ${data.getString(1)} \n")
            buffer.append("Email: ${data.getString(2)} \n")
        }
        if(peopleDB!!.delete(ID.text.toString().toInt()))
        {
            display("Удален пользователь", buffer.toString())
        }else
        {
            Toast.makeText(this, "Такого пользователя нет", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showUsers() {
        val data: Cursor? = peopleDB!!.showData()

        if (data!!.count == 0) {
            display("Error", "Пусто")
            return
        }
        val buffer = StringBuffer()
        while(data.moveToNext())
        {
            buffer.append("ID: ${data.getString(0)} \n")
            buffer.append("Name: ${data.getString(1)} \n")
            buffer.append("Email: ${data.getString(2)} \n")
        }

        display("Все пользователи", buffer.toString())
    }
    private fun addUser() {
        val name: String = edtName.text.toString()
        val email: String = edtEmail.text.toString()

        val insertData: Boolean = peopleDB!!.addData(name, email)

        if (insertData) {
            Toast.makeText(this, "Запись добавлена", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Ошибка", Toast.LENGTH_SHORT).show()
        }
    }

    private fun display(title: String, message: String) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.show()
    }
}

