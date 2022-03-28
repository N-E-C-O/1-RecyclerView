package com.example.recyclerviewneco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewneco.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    // Создаем переменную adapter и записываем в нее нащ PlantAdapter класс
    private val adapter = PlantAdapter()

    // Массив с картинками
    private val imageIdList = listOf(
        R.drawable.plant1,
        R.drawable.plant2,
        R.drawable.plant3,
        R.drawable.plant4,
        R.drawable.plant5,
        R.drawable.plant6
    )

    // Переменная нужна для реализации нажатия кнопки.
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    // Зачем эта фкнкция?
    // binding.apply - чтобы не писать binding на элементах (Можно заменить на with(binding) в функции)
    // rcView.layoutManager = GridLayoutManager(this@MainActivity, 3) - RV сеткой по 3 элемента горизонтально
    // rcView.adapter = adapter - прикрепляем Адаптек к нашему RV
    // val plant = Plant - Берем из массива картинку, пишем название и передаем в функцию addPlant в Адаптере.
    private fun init() {
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener {
                if (index > 5) index = 0
                val plant = Plant(imageIdList[index], "Plant ${index + 1}")
                adapter.addPlant(plant)
                index++
            }
        }
    }
}