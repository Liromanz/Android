package com.example.pract8_alert

import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateUtils
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var time = Calendar.getInstance()
        timePicker.setOnTimeChangedListener { timePicker, hourOfDay, minute ->
            time.set(Calendar.HOUR_OF_DAY, hourOfDay)
            time.set(Calendar.MINUTE, minute)
        }
        btn_timer.setOnClickListener {
            setAlarm(time)
        }
    }

    private fun setAlarm(time: Calendar) {
        val date = SimpleDateFormat("HH:mm:ss")
        val text_timer = StringBuilder()
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent = Intent(this, MyAlarmReciever::class.java)
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
        intent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
        val pendingIntent =
            PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        alarmManager.set(AlarmManager.RTC_WAKEUP, time.timeInMillis, pendingIntent)
        text_timer.append(date.format(time.timeInMillis)).append("")
        timeText.text = text_timer
        Toast.makeText(this, "Будильник включен", Toast.LENGTH_LONG).show()
    }
}
