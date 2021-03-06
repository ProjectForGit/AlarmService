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

class MesomorphMonday : AppCompatActivity() {

    lateinit var listView: ListView
    var on: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mesomorph_monday)

        listView = findViewById(R.id.listView)
        var list = mutableListOf<Model>()

        list.add(
            Model(
                "Жим штанги на наклонной скамье", "4х10 кг",
                R.drawable.zhim_verh
            )
        )
        list.add(
            Model(
                "Жим гантелей на горизонтальной скамье", "3х10-12 кг",
                R.drawable.zhim_gantelei_lezha
            )
        )
        list.add(
            Model(
                "Отжимания на брусьях", "3х10-12 кг",
                R.drawable.otjimaniya_na_brusyah
            )
        )
        list.add(
            Model(
                "Жим штанги лежа узким хватом", "3х10 кг",
                R.drawable.jim_uzkim_hvatom
            )
        )
        list.add(
            Model(
                "Французский жим со штангой", "3х12 кг",
                R.drawable.franzyskyi_zhim
            )
        )
        list.add(
            Model(
                "Жим гантелей сидя", "4х12 кг",
                R.drawable.zhim_sidya
            )
        )
        list.add(
            Model(
                "Тяга штанги к подбородку широким хватом", "3х12 кг",
                R.drawable.tyaga_k_podborodku
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
                            putExtra("Name", "Жим штанги на наклонной скамье")
                            putExtra("Repeat", "10")
                            putExtra("Podhod", "4")
                            putExtra("Weight", "20")
                            putExtra("Picture", R.drawable.zhim_verh)
                        })
            }
            if (position == 1) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Жим гантелей на горизонтальной скамье")
                            putExtra("Repeat", "12")
                            putExtra("Podhod", "3")
                            putExtra("Weight", "50")
                            putExtra("Picture", R.drawable.zhim_gantelei_lezha)
                        })
            }
            if (position == 2) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Отжимания на брусьях")
                            putExtra("Repeat", "12")
                            putExtra("Podhod", "3")
                            putExtra("Weight", "собственный вес")
                            putExtra("Picture", R.drawable.otjimaniya_na_brusyah)
                        })
            }
            if (position == 3) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Жим штанги лежа узким хватом")
                            putExtra("Repeat", "10")
                            putExtra("Podhod", "3")
                            putExtra("Weight", "15")
                            putExtra("Picture", R.drawable.jim_uzkim_hvatom)
                        })
            }
            if (position == 4) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Французский жим со штангой")
                            putExtra("Repeat", "12")
                            putExtra("Podhod", "3")
                            putExtra("Weight", "10")
                            putExtra("Picture", R.drawable.franzyskyi_zhim)
                        })
            }
            if (position == 5) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Жим гантелей сидя")
                            putExtra("Repeat", "12")
                            putExtra("Podhod", "4")
                            putExtra("Weight", "14")
                            putExtra("Picture", R.drawable.zhim_sidya)
                        })
            }
            if (position == 6) {
                startActivity(
                    Intent(this, Description::class.java)
                        .apply {
                            putExtra("Name", "Тяга штанги к подбородку широким хватом")
                            putExtra("Repeat", "12")
                            putExtra("Podhod", "3")
                            putExtra("Weight", "25")
                            putExtra("Picture", R.drawable.tyaga_k_podborodku)
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