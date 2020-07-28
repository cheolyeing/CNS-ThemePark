package com.example.midnight_themepark

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

class ControlMusicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control_music)

        val returnBtn : ImageButton = findViewById(R.id.returnBtn)
        returnBtn.setOnClickListener {
            val intentReturn = Intent(this, HomeActivity::class.java)
            startActivity(intentReturn)
        }
    }
}