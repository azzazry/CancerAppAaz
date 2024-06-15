package com.dicoding.asclepius.view.result

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.dicoding.asclepius.R
import com.dicoding.asclepius.databinding.ActivityResultBinding
import com.dicoding.asclepius.model.CancerEntity
import com.dicoding.asclepius.view.factory.ViewModelFactory

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private lateinit var currentImageUri: Uri
    private lateinit var prediction: String
    private var confidenceScore: Float = 0f
    private lateinit var resultViewModel: ResultViewModel

    companion object {
        const val EXTRA_IMAGE_URI = "extra_image_uri"
        const val EXTRA_PREDICTION = "extra_prediction"
        const val EXTRA_CONFIDENCE = "extra_confidence"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currentImageUri = Uri.parse(intent.getStringExtra(EXTRA_IMAGE_URI))
        prediction = intent.getStringExtra(EXTRA_PREDICTION) ?: ""
        confidenceScore = intent.getFloatExtra(EXTRA_CONFIDENCE, 0f)
        val resultText = getString(R.string.result_text, prediction, confidenceScore)

        binding.resultImage.setImageURI(currentImageUri)
        binding.resultText.text = resultText

        resultViewModel = viewModel()

        binding.btnSave.setOnClickListener {
            val history = CancerEntity(
                imageUri = currentImageUri.toString(),
                prediction = prediction,
                confidenceScore = confidenceScore
            )
            resultViewModel.insert(history)
            Toast.makeText(this, "Saved to History!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun viewModel(): ResultViewModel {
        val factory = ViewModelFactory.getAppInstance(application)
        return ViewModelProvider(this, factory)[ResultViewModel::class.java]
    }
}