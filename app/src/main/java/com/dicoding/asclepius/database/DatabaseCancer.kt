package com.dicoding.asclepius.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dicoding.asclepius.model.CancerEntity

@Database(entities = [CancerEntity::class], version = 1)
abstract class DatabaseCancer : RoomDatabase() {
    abstract fun historyDao(): HistoryDao

    companion object {
        @Volatile
        private var INSTANCE: DatabaseCancer? = null

        fun getDatabase(context: Context): DatabaseCancer {
            if (INSTANCE == null) {
                synchronized(DatabaseCancer::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseCancer::class.java, "cancer"
                    ).build()
                }
            }
            return INSTANCE as DatabaseCancer
        }
    }
}