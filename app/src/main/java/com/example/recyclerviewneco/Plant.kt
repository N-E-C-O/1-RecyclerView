package com.example.recyclerviewneco

// Каждый элемент списка будет содержать 2 динамические переменные
// val imageId: Int - картинка в ресурсах. (Она всегда подтягивается из ресурсов в виде Int).
// val title: String - название растения.
data class Plant(val imageId: Int, val title: String)
