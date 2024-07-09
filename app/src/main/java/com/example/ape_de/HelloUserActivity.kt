package com.example.ape_de

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ape_de.databinding.ActivityHelloUserBinding

class HelloUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHelloUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelloUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterationPageActivity::class.java))
        }

        binding.btnLogin.setOnClickListener{
            startActivity(Intent(this, LoginPageActivity::class.java))
        }
    }
}