package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateTip.setOnClickListener{calculateTip()}
    }

    private fun calculateTip() {
        val cost = binding.costOfService.text.toString().toDoubleOrNull()
        if(cost == null) {
            binding.tipResult.text = ""
            return
        }
        val percentage = getPercentage(binding.tipOptions.checkedRadioButtonId)
        var tip = cost * percentage
        tip = if(binding.roundUpSwitch.isChecked) kotlin.math.ceil(tip) else tip
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }

    private fun getPercentage(checkedRadioButtonId: Int): Double {
        return when (checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.2
            R.id.option_eigthteen_percent -> 0.18
            else -> 0.15
        }
    }


}