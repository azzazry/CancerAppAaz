package com.dicoding.asclepius.view.result

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.asclepius.model.CancerEntity
import com.dicoding.asclepius.repository.Repository
import kotlinx.coroutines.launch

class ResultViewModel(mApplication: Application) : ViewModel() {
    private val mRiwayatRepository: Repository =
        Repository(mApplication)

    fun insert(cRiwayat: CancerEntity) {
        viewModelScope.launch {
            mRiwayatRepository.insert(cRiwayat)
        }
    }
}