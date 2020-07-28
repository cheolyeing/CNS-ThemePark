package com.example.midnight_themepark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class ControlMoveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_controlmove)

        val returnBtn : ImageButton = findViewById(R.id.returnBtn)
        returnBtn.setOnClickListener {
            val intentReturn = Intent(this, HomeActivity::class.java)
            startActivity(intentReturn)
        }
    }
}