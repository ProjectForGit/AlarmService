package com.example.alarmservice

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun setAlarm(view: View) {
        val timePicker = findViewById<TimePicker>(R.id.timePicker)
        val calendar = Calendar.getInstance()
        with(calendar) {
            set(Calendar.HOUR, timePicker.hour)
            set(Calendar.MINUTE, timePicker.minute)
        }
        (getSystemService(ALARM_SERVICE) as AlarmManager).set(AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis, PendingIntent.getBroadcast(this, 0,
                Intent(this, MyAlarmReceiver::class.java), 0))
        Toast.makeText(this, "Будильник заведен", Toast.LENGTH_SHORT).show()
    }
}