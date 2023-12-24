package com.example.WorkersDataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.WorkersDataBase.Worker.Worker

@Database(entities = [Worker::class] , version = 1, exportSchema = true)
abstract class RabotnikDatabase: RoomDatabase() {
    abstract val dao: RabotnikDao
}
