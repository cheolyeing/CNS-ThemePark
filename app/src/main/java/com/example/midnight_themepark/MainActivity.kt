package com.example.midnight_themepark

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // ImageView를 id로 불러와서 색깔을 입히는 작업
        var iv: ImageView = findViewById(R.id.mainImg)
        iv.setColorFilter(Color.argb(255, 255, 0, 0))

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
                val intent : Intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
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