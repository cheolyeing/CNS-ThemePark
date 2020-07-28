package com.example.midnight_themepark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val logoutBtn : ImageButton = findViewById(R.id.logoutBtn)
        logoutBtn.setOnClickListener {
            val intentLogout : Intent = Intent(this, MainActivity::class.java)
            startActivity(intentLogout)
        }

        val ctrlMoveBtn : Button = findViewById(R.id.ctrlMoveBtn)
        ctrlMoveBtn.setOnClickListener{
            val intentMove : Intent = Intent(this, ControlMoveActivity::class.java)
            startActivity(intentMove)
        }

        val ctrlMusicBtn : Button = findViewById(R.id.ctrlMoveBtn)
        ctrlMusicBtn.setOnClickListener{
            val intentMusic : Intent = Intent(this, ControlMusicActivity::class.java)
            startActivity(intentMusic)
        }
    }
}