package com.rafael.proffy.ui.register

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rafael.proffy.R
import com.rafael.proffy.databinding.ActivityRegisterStepOneBinding

class RegisterStepOneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterStepOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterStepOneBinding.inflate(layoutInflater)
        val view = binding.root

        enableEdgeToEdge()
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonGoBack = binding.buttonGoBack
        val textInputFistName = binding.textInputEditFirstName
        val textInputLastName = binding.textInputEditLastName
        val buttonNext = binding.buttonNext

        val enabledButton = ContextCompat.getColor(this, R.color.purple)
        val disabledButton = ContextCompat.getColor(this, R.color.shape_disable)

        setButtonState(true, enabledButton, disabledButton)

        buttonGoBack.setOnClickListener {
            goBack()
        }

        buttonNext.setOnClickListener {
            handleNextStep()
        }
    }

    private fun goBack() {
        finish()
    }

    private fun setButtonState(enabled: Boolean, enabledColor: Int, disabledColor: Int) {
        binding.buttonNext.isEnabled = enabled
        val color = if (enabled) enabledColor else disabledColor

        binding.buttonNext.backgroundTintList = ColorStateList.valueOf(color)
        val textColor = ContextCompat.getColor(this, R.color.shape_01_white)
        binding.buttonNext.setTextColor(textColor)
    }

    private fun handleNextStep() {
        val firstName = binding.textInputEditFirstName.text.toString()
        val lastName = binding.textInputEditLastName.text.toString()
    }
}