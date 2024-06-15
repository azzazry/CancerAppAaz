package com.dicoding.asclepius.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dicoding.asclepius.model.CancerEntity

@Dao
interface HistoryDao {
    @Query("select * from riwayat_kanker")
    suspend fun getHistory(): List<CancerEntity>

    @Insert
    suspend fun insert(cRiwayat: CancerEntity)
}