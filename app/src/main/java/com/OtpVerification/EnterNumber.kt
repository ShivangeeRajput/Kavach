package com.OtpVerification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.kavach.R


class EnterNumber : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_number)

        supportActionBar?.hide()

        val btnnext = findViewById<Button>(R.id.btnnext)
        btnnext.setOnClickListener {
            val intent= Intent(this, VerifyNumber::class.java)
            startActivity(intent)
        }
    }
}