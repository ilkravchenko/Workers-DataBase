package com.example.WorkersDataBase

import com.example.WorkersDataBase.Worker.Worker

data class RabotnikState(
    val worker: List<Worker> = emptyList(),
    val name: String = "",
    val zarplata: String = "",
    val position: String = "Developer",
    val experience: String = "",
    val efficiency: String = "",
    val isAddingRabotnik: Boolean = false, // Add new Rabotnik
)
