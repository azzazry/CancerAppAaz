package com.dicoding.asclepius.view.history

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.asclepius.R
import com.dicoding.asclepius.databinding.ActivityHistoryBinding
import com.dicoding.asclepius.view.adapter.HistoryAdapter
import com.dicoding.asclepius.view.factory.ViewModelFactory

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding
    private lateinit var historyViewModel: HistoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        historyViewModel = viewModel()
        historyViewModel.history.observe(this) {
            val adapter = HistoryAdapter(it)
            binding.rvHistory.adapter = adapter
            binding.rvHistory.layoutManager = LinearLayoutManager(this)
        }
    }

    private fun viewModel(): HistoryViewModel {
        val factory = ViewModelFactory.getAppInstance(application)
        return ViewModelProvider(this, factory)[HistoryViewModel::class.java]
    }
}