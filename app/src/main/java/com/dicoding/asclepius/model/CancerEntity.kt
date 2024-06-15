package com.dicoding.asclepius.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "riwayat_kanker")
data class CancerEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "imageUri")
    val imageUri: String,
    @ColumnInfo(name = "prediction")
    val prediction: String,
    @ColumnInfo(name = "confidenceScore")
    val confidenceScore: Float
)