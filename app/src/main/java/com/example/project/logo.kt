package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.logging.Handler

class logo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)
        supportActionBar?.hide()
        android.os.Handler().postDelayed({
           val intent =Intent(this,MainActivity::class.java)
           startActivity(intent)
        },2000)
    }
}