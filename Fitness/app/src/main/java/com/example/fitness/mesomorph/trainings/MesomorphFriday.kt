package com.example.fitness.mesomorph.trainings

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

class MesomorphFriday : AppCompatActivity() {

    lateinit var listView: ListView
    var on: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mesomorph_friday)


        listView = findViewById(R.id.listView)
        var list = mutableListOf<Model>()

        list.add(
            Model(
                "Приседания со штангой", "4х12 кг",
                R.drawable.prised
            )
        )
        list.add(
            Model(
                "Фронтальные приседания", "4х12 кг",
                R.drawable.front_prised
            )
        )
        list.add(
            Model(
                "Выпады со штангой", "4х20 кг",
                R.drawable.vipady_so_shtangoi
            )
        )
        list.add(
            Model(
                "Сгибания ног лежа в тренажере", "3х15 кг",
                R.drawable.sgibaniya_nog
            )
        )
        list.add(
            Model(
                "Подъем на носки стоя в тренажере", "4х15 кг",
                R.drawable.podem_na_noski
            )
        )
        list.add(
            Model(
                "Обратные скручивания на скамье", "3х15 кг",
                R.drawable.obratnie_skruchivaniya
            )
        )
        list.add(
            Model(
                "Скручивания в тренажере", "3х15 кг",
                R.drawable.skruchivaniya_na_trenajere
            )
        )

        listView.adapter = MyListAdapter(
            this,
            R.layout.row, list
        )

        listView.setOnItemClickListener { parent, view, position, id ->

            if (position == 0) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Приседания со штангой")
                            putExtra("Repeat", "12")
                            putExtra("Podhod", "4")
                            putExtra("Weight", "25")
                            putExtra("Picture", R.drawable.prised)
                        })
            }
            if (position == 1) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Фронтальные приседания")
                            putExtra("Repeat", "12")
                            putExtra("Podhod", "4")
                            putExtra("Weight", "20")
                            putExtra("Picture", R.drawable.front_prised)
                        })
            }
            if (position == 2) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Выпады со штангой")
                            putExtra("Repeat", "20")
                            putExtra("Podhod", "4")
                            putExtra("Weight", "15")
                            putExtra("Picture", R.drawable.vipady_so_shtangoi)
                        })
            }
            if (position == 3) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Сгибания ног лежа в тренажере")
                            putExtra("Repeat", "15")
                            putExtra("Podhod", "3")
                            putExtra("Weight", "собственный вес")
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
            if (position == 5) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Обратные скручивания на скамье")
                            putExtra("Repeat", "15")
                            putExtra("Podhod", "3")
                            putExtra("Weight", "собственный вес")
                            putExtra("Picture", R.drawable.obratnie_skruchivaniya)
                        })
            }
            if (position == 6) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Скручивания в тренажере")
                            putExtra("Repeat", "15")
                            putExtra("Podhod", "3")
                            putExtra("Weight", "собственный вес")
                            putExtra("Picture", R.drawable.skruchivaniya_na_trenajere)
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