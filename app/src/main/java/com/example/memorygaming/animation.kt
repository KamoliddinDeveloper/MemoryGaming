package com.example.memorygaming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_animation.*

class animation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)


        easy.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        medium.setOnClickListener {
            val intent = Intent(this, MemoryGaming2::class.java)
            startActivity(intent)
        }

        hard.setOnClickListener {
            val intent = Intent(this, MemoryGaming3::class.java)
            startActivity(intent)
        }

        malumot.setOnClickListener {
            val intent = Intent(this, Malumot :: class.java)
            startActivity(intent)
        }
    }
}