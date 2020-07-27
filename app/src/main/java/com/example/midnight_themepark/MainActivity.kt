package com.example.midnight_themepark

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // ImageView를 id로 불러와서 색깔을 입히는 작업
        var iv: ImageView = findViewById(R.id.mainImg)
        iv.setColorFilter(Color.argb(255, 255, 0, 0))

        // 이미지뷰 컨트롤
        var r: Boolean = true
        var g: Boolean = false
        var b: Boolean = false

        if (r) {
            for (i in 0..255) {
                iv.setColorFilter(Color.argb(255, i, 0, 0))
            }
            for (i in 0..255) {
                iv.setColorFilter(Color.argb(255, 255 - i, 0, 0))
            }
            r = false
            g = true
        }
        if (g) {
            for (i in 0..255) {
                iv.setColorFilter(Color.argb(255, 0, i, 0))
            }
            for (i in 0..255) {
                iv.setColorFilter(Color.argb(255, 0, 255 - i, 0))
            }
            g = false
            b = true
        }
        if (b) {
            for (i in 0..255) {
                iv.setColorFilter(Color.argb(255, 0, 0, i))
            }
            for (i in 0..255) {
                iv.setColorFilter(Color.argb(255, 0, 0, 255 - i))
            }
            b = false
            r = true
        }

        // Button 가져오기
        val button: Button = findViewById(R.id.loginBtn);
        button.setOnClickListener() {
            // 여기에 버튼 클릭했을때 할 일 쓰면 됨

            // input으로 받은 ID 출력
            var id: EditText = findViewById(R.id.inputID)
            var pw: EditText = findViewById(R.id.inputPW)

            var idVal: String = id.text.toString()
            var pwVal: String = pw.text.toString()

            val builder = AlertDialog.Builder(this@MainActivity)
            if (idVal == "CNS2020" && pwVal == "2020") {
                Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_SHORT).show()
                /*builder.setTitle("")
                builder.setMessage("Login Success")
                builder.setPositiveButton("OK") { dialog, which ->
                    Toast.makeText(applicationContext, "OK", Toast.LENGTH_SHORT).show()

                }*/

                /*builder.setNegativeButton("NO") {dialog, which ->
                    Toast.makeText(applicationContext, "NO", Toast.LENGTH_SHORT).show()

                }

                builder.setNeutralButton("Cancel") { _,_->
                    Toast.makeText(applicationContext, "cancel", Toast.LENGTH_SHORT).show()
                }*/


            } else {
                builder.setTitle("")
                builder.setMessage("Login Fail")
                builder.setPositiveButton("OK") { dialog, which ->
                    //Toast.makeText(applicationContext, "OK", Toast.LENGTH_SHORT).show()

                }
                val dialog: AlertDialog = builder.create()
                dialog.show()
            }

        }
    }
}