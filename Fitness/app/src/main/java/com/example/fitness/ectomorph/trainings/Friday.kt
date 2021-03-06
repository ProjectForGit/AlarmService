package com.example.fitness.ectomorph.trainings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import com.example.fitness.Description
import com.example.fitness.ListAdapter.Model
import com.example.fitness.ListAdapter.MyListAdapter
import com.example.fitness.R
import kotlinx.android.synthetic.main.activity_monday.*

class Friday : AppCompatActivity() {

    lateinit var listView: ListView
    var on: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friday)


        listView = findViewById(R.id.listView)
        var list = mutableListOf<Model>()

        list.add(
            Model("Приседания со штангой", "4х12",
                R.drawable.prised
            )
        )
        list.add(
            Model("Жим ногами", "3х10",
                R.drawable.zhim_nogami
            )
        )
        list.add(
            Model("Румынская тяга с гантелями", "4х12 кг",
                R.drawable.rumynskaya_yaga_ganteli
            )
        )
        list.add(
            Model("Сгибания ног лежа в тренажере", "3х12",
                R.drawable.sgibaniya_nog
            )
        )
        list.add(
            Model("Подъем на носки стоя в тренажере", "4х15 кг",
                R.drawable.podem_na_noski
            )
        )

        listView.adapter = MyListAdapter(this,
            R.layout.row, list)

        listView.setOnItemClickListener { parent, view, position, id ->

            if (position == 0) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Приседания со штангой")
                            putExtra("Repeat", "12")
                            putExtra("Podhod", "4")
                            putExtra("Weight", "10")
                            putExtra("Picture", R.drawable.prised)
                        })
            }
            if (position == 1) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Жим ногами")
                            putExtra("Repeat", "10")
                            putExtra("Podhod", "3")
                            putExtra("Weight", "20")
                            putExtra("Picture", R.drawable.zhim_nogami)
                        })
            }
            if (position == 2) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Румынская тяга с гантелями")
                            putExtra("Repeat", "12")
                            putExtra("Podhod", "4")
                            putExtra("Weight", "8")
                            putExtra("Picture", R.drawable.rumynskaya_yaga_ganteli)
                        })
            }
            if (position == 3) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Сгибания ног лежа в тренажере")
                            putExtra("Repeat", "12")
                            putExtra("Podhod", "3")
                            putExtra("Weight", "20")
                            putExtra("Picture", R.drawable.sgibaniya_nog)
                        })
            }
            if (position == 4) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Подъем на носки стоя в тренажере")
                            putExtra("Repeat", "15")
                            putExtra("Podhod", "4")
                            putExtra("Weight", "25")
                            putExtra("Picture", R.drawable.podem_na_noski)
                        })
            }
        }
    }

    fun startButton(view: View) {
        if (!on)
        {
            chronometer.visibility = view.visibility
            chronometer.start()
            Toast.makeText(this, "Тренировка начата", Toast.LENGTH_SHORT).show()
            startButton.setText("Завершить тренировку")
            on = true
        }
        else if (on)
        {
            chronometer.stop()
            Toast.makeText(this, "Тренировка завершена", Toast.LENGTH_SHORT).show()
        }
    }
}