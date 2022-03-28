package com.example.recyclerviewneco

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewneco.databinding.PlantItemBinding

// Наследуемся RecyclerView.Adapter
// <PlantAdapter.PlantHolder>() - создаем класс внутри класса - этот класс будет содержать ссылки на все Виджеты 1 элемента списка.
class PlantAdapter: RecyclerView.Adapter<PlantAdapter.PlantHolder>() {

    // Создаем пустой список типа Plant (класса шаблона)
    val plantList = ArrayList<Plant>()

    // этот класс будет содержать ссылки на все Виджеты 1 элемента списка.
    // Наследуемся от RecyclerView.ViewHolder
    // (item: View) - в эти аргументы передается разметка 1 элемента списка из метода ниже: onCreateViewHolder
    // (item) - сюда передаем эту разметку.
    class PlantHolder(item: View): RecyclerView.ViewHolder(item) {

        // Подключаем байндинг из (item: View), а там разметка из onCreateViewHolder
        val binding = PlantItemBinding.bind(item)

        // Здесь заполняем виджеты 1 элемента списка по шаблону классу.
        // (plant: Plant) - создаем переменную типа Plant (Класса шаблона)
        // with(binding) - чтобы на каждый елемент не писать binding
        fun bind(plant: Plant) = with(binding){
            im.setImageResource(plant.imageId)
            tvTitle.text = plant.title
        }
    }

    // Это стандартный метод. Здесь прикрепляем разметку 1 элемента списка.
    // возвращаем разметку во внутренний класс PlantHolder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return PlantHolder(view)
    }

    // Заполняет из массива plantList по позиции - элементы в класс PlantHolder в функцию bind
    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(plantList[position])
    }

    // RV создает ровно столько элементов, сколько мы тут укажем. (В данный момент весь размер списка)
    override fun getItemCount(): Int {
        return plantList.size
    }

    // Нажатие на кнопку. (plant: Plant) сюда передадим что-то
    // notifyDataSetChanged() - Говорим адаптеру, что при нажатии на кнопку данные внутри изменились. Перерисовывай.
    fun addPlant(plant: Plant){
        plantList.add(plant)
        notifyDataSetChanged()
    }
}