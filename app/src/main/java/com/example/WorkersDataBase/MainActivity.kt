package com.example.WorkersDataBase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.WorkersDataBase.WorkersScreen.RabotnikScreen
import com.example.WorkersDataBase.ui.theme.AppTheme
@Suppress("UNCHECKED_CAST")

class MainActivity : ComponentActivity() {
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            RabotnikDatabase::class.java,
            "rabotnik.db"
        ).build()
    }
    private val viewModel by viewModels<RabotnikViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return RabotnikViewModel(db.dao) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val state by viewModel._state.collectAsState()
                RabotnikScreen(state = state, onEvent = viewModel::onEvent)
            }
        }
    }
}