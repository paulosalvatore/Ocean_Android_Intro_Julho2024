package com.oceanbrasil.ocean_android_intro_julho2024

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Buscar o botão btEnviar
        // Adicionar um Listener no botão, para detectar eventos de clique

        val btEnviar = findViewById<Button>(R.id.btEnviar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val etNome = findViewById<EditText>(R.id.etNome)

        btEnviar.setOnClickListener {
            if (etNome.text.isBlank()) {
                etNome.error = "Digite um nome válido!"
            } else {
                tvResultado.text = etNome.text
            }
        }

        // Encontro o btAbrirNovaTela e criar um ClickListener para ele
        val btAbrirNovaTela = findViewById<Button>(R.id.btAbrirNovaTela)
        btAbrirNovaTela.setOnClickListener {
            val novaTelaIntent = Intent(this, ResultadoActivity::class.java)

            startActivity(novaTelaIntent)
        }
    }
}
