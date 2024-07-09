package com.example.ape_de

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ape_de.databinding.ActivitySellerAccountBinding

class SellerAccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySellerAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySellerAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreateStore.setOnClickListener{
           // startActivity(Intent(this, CreateStoreActivity::class.java))
        }
        binding.btnVisitStore.setOnClickListener{
           // startActivity(Intent(this, YourStoreActivity::class.java))
        }
    }
}