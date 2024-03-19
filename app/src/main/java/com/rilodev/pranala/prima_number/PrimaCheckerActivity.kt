package com.rilodev.pranala.prima_number

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rilodev.pranala.R
import com.rilodev.pranala.databinding.ActivityPrimaCheckerBinding
import com.rilodev.pranala.utils.Utils

class PrimaCheckerActivity : AppCompatActivity() {
    private var _binding: ActivityPrimaCheckerBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPrimaCheckerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            initUI()
        }
    }

    private fun ActivityPrimaCheckerBinding.initUI() {
        generatePrimaNumberBtn.setOnClickListener {
            val n = inputNumber.text.toString().ifEmpty { "-1" }.toInt()
            if(n == -1) {
                inputNumber.error = resources.getString(R.string.field_should_filled)
            } else {
                val primaNumber = Utils.getPrimaNumber(n)
                textResult.text = primaNumber
            }
        }
    }
}