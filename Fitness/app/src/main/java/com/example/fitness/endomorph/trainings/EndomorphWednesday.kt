package com.example.fitness.endomorph.trainings

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

class EndomorphWednesday : AppCompatActivity() {

    lateinit var listView: ListView
    var on: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_endomorph_wednesday)


        listView = findViewById(R.id.listView)
        var list = mutableListOf<Model>()

        list.add(
            Model("Подтягивания широким хватом", "4х15 кг",
                R.drawable.podtyagivaniya_shirokim_hvatom
            )
        )
        list.add(
            Model("Тяга штанги в наклоне", "4х10 кг",
                R.drawable.tyaga_k_poyasu
            )
        )
        list.add(
            Model("Тяга вертикального блока узким обратным хватом", "3х10 кг",
                R.drawable.tyaga_blocka
            )
        )
        list.add(
            Model("Тяга гантели в наклоне", "3x10 кг",
                R.drawable.tyaga_ganteli
            )
        )
        list.add(
            Model("Гиперэкстензия", "4х15 кг",
                R.drawable.giperekstenziya
            )
        )
        list.add(
            Model("Подъемы штанги на бицепс стоя", "3х12 кг",
                R.drawable.shtanga_na_biceps
            )
        )
        list.add(
            Model("Сгибания рук со гантелями на скамье Скотта", "3х10 кг",
                R.drawable.bitseps_skott
            )
        )
        list.add(
            Model("Отведения в тренажере на заднюю дельту", "4х15 кг",
                R.drawable.otvedenie_na_zadnyu_delty
            )
        )

        listView.adapter = MyListAdapter(this,
            R.layout.row, list)

        listView.setOnItemClickListener { parent, view, position, id ->

            if (position == 0) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Подтягивания широким хватом")
                            putExtra("Repeat", "15")
                            putExtra("Podhod", "4")
                            putExtra("Weight", "собственный вес")
                            putExtra("Picture", R.drawable.podtyagivaniya_shirokim_hvatom)
                        })
            }
            if (position == 1) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Тяга штанги в наклоне")
                            putExtra("Repeat", "10")
                            putExtra("Podhod", "4")
                            putExtra("Weight", "15")
                            putExtra("Picture", R.drawable.tyaga_k_poyasu)
                        })
            }
            if (position == 2) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Тяга вертикального блока узким обратным хватом")
                            putExtra("Repeat", "10")
                            putExtra("Podhod", "3")
                            putExtra("Weight", "30")
                            putExtra("Picture", R.drawable.tyaga_blocka)
                        })
            }
            if (position == 3) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Тяга гантели в наклоне")
                            putExtra("Repeat", "10")
                            putExtra("Podhod", "3")
                            putExtra("Weight", "30")
                            putExtra("Picture", R.drawable.tyaga_ganteli)
                        })
            }
            if (position == 4) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Гиперэкстензия")
                            putExtra("Repeat", "15")
                            putExtra("Podhod", "4")
                            putExtra("Weight", "15")
                            putExtra("Picture", R.drawable.giperekstenziya)
                        })
            }
            if (position == 5) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Подъемы штанги на бицепс стоя")
                            putExtra("Repeat", "12")
                            putExtra("Podhod", "3")
                            putExtra("Weight", "25")
                            putExtra("Picture", R.drawable.shtanga_na_biceps)
                        })
            }
            if (position == 6) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Сгибания рук со гантелями на скамье Скотта")
                            putExtra("Repeat", "10")
                            putExtra("Podhod", "3")
                            putExtra("Weight", "12")
                            putExtra("Picture", R.drawable.bitseps_skott)
                        })
            }
            if (position == 7) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Отведения в тренажере на заднюю дельту")
                            putExtra("Repeat", "15")
                            putExtra("Podhod", "4")
                            putExtra("Weight", "25")
                            putExtra("Picture", R.drawable.otvedenie_na_zadnyu_delty)
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