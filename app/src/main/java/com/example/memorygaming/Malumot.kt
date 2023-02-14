package com.example.memorygaming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_malumot.*

class Malumot : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_malumot)

        tugatish.setOnClickListener {
            finish()
        }

    }
}