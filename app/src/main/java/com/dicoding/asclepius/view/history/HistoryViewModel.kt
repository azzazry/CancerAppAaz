package com.dicoding.asclepius.view.history

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.asclepius.model.CancerEntity
import com.dicoding.asclepius.repository.Repository
import kotlinx.coroutines.launch

class HistoryViewModel(mApplication: Application) : ViewModel() {

    private val mRepository: Repository = Repository(mApplication)

    private var _history= MutableLiveData<List<CancerEntity>>()
    val history: LiveData<List<CancerEntity>> get() = _history

    private fun getHistory() {
        viewModelScope.launch {
            val hasil = mRepository.getHistory()
            _history.value = hasil
        }
    }

    init {
        getHistory()
    }
}