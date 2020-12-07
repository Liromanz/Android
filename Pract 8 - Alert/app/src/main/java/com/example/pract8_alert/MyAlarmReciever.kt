package com.example.pract8_alert

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyAlarmReciever : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context!!, "Будильник сработал", Toast.LENGTH_LONG).show()
    }
}