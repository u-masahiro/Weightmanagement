package com.example.weightmanagement.model

class MainRepository {

    fun getWeight( ):List<Data> =
        foods

    companion object {
        private val foods = listOf<Data>(
            Data(
                date =  20200620,
                weight = 30,
                percentage = 20,
                bmi = 20
            )
        )
    }
}
