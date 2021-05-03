package com.example.fitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_description.*

class Description : AppCompatActivity() {

    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        val extras = intent.extras
        val Name  = extras!!.getString("Name")
        val Repeat = extras!!.getString("Repeat")
        val Podhod = extras!!.getString("Podhod")
        val Picture = extras!!.getInt("Picture")
        val Weight = extras!!.getString("Weight")


        name.setText(Name)
        repeat.setText(Repeat)
        podhod.setText(Podhod)
        weight.setText("Рекомендуемый вес(кг): " + Weight)
        image.setImageResource(Picture)

    }

    fun startButtonClick(view: View) {
        var done: Boolean
        startActivity(Intent(this, Description::class.java)
            .apply {
                putExtra("Name", "Жим гантелей лежа на наклонной скамье")
                putExtra("Repeat", "12")
                putExtra("Podhod", "3")
                putExtra("Weight", "12")
                putExtra("Picture", R.drawable.jimgantelei)
            })
        Toast.makeText(this, "Упражнение выполнено", Toast.LENGTH_SHORT).show()
    }
}