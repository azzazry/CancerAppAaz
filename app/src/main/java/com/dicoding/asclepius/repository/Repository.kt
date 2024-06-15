package com.dicoding.asclepius.repository

import android.app.Application
import com.dicoding.asclepius.database.DatabaseCancer
import com.dicoding.asclepius.database.HistoryDao
import com.dicoding.asclepius.model.CancerEntity

class Repository(mApplication: Application) {
    private val mCancerDao: HistoryDao

    init {
        val db = DatabaseCancer.getDatabase(mApplication)
        mCancerDao = db.historyDao()
    }

    suspend fun insert(cHistory: CancerEntity) {
        mCancerDao.insert(cHistory)
    }

    suspend fun getHistory(): List<CancerEntity> {
        return mCancerDao.getHistory()
    }
}