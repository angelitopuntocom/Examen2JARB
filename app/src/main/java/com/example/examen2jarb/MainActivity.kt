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

            if (username.isNotEmpty() && password.isNotEmpty()) {

                if (password == "abc123") {
                    // Creamos el Intent para ir a ProfileActivity
                    val intent = Intent(this, ProfileActivity::class.java)

                    // PASO NUEVO: Guardamos el nombre de usuario con una "llave" llamada "KEY_USERNAME"
                    intent.putExtra("KEY_USERNAME", username)

                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Contraseña incorrecta.", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_LONG).show()
            }
        }
    }
}