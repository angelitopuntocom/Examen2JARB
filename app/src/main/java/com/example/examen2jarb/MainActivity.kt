package com.example.examen2jarb

import android.content.Intent // Importación necesaria para cambiar de pantalla
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // Mantenemos la validación de campos vacíos como buena práctica
            if (username.isNotEmpty() && password.isNotEmpty()) {

                // 1. Validar la contraseña exacta
                if (password == "abc123") {
                    // Si es igual: Iniciar la actividad ProfileActivity
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                } else {
                    // Si NO es igual: Mostrar el mensaje de error con un Toast
                    Toast.makeText(this, "Contraseña incorrecta.", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_LONG).show()
            }
        }
    }
}