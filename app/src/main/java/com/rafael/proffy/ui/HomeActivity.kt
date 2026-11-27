package com.rafael.proffy.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rafael.proffy.databinding.ActivityHomeBinding
import com.rafael.proffy.ui.teacherList.TeacherListActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Uso de ?. para evitar erros de compilação de elementos nulos
        binding.cardStudying?.setOnClickListener {
            val intent = Intent(this, TeacherListActivity::class.java)
            startActivity(intent)
        }

        binding.cardGiveClasses?.setOnClickListener {
            Toast.makeText(this, "Funcionalidade de Dar Aulas em breve", Toast.LENGTH_SHORT).show()
        }

        binding.btnLogout?.setOnClickListener {
            Toast.makeText(this, "Saindo...", Toast.LENGTH_SHORT).show()
        }
    }
}