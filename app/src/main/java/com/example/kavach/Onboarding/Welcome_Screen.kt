package com.Onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.OtpVerification.EnterNumber
import com.example.kavach.R


class Welcome_Screen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)

        supportActionBar?.hide()

        val  cv1= findViewById<CardView>(R.id.cardView1)
        val  cv2= findViewById<CardView>(R.id.cardView2)

        cv1.setOnClickListener {
            val intent=Intent(this, EnterNumber::class.java)
            startActivity(intent)
        }

    }
}