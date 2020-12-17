package com.example.alarmservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyAlarmReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Будильник!", Toast.LENGTH_LONG).show()
    }
}