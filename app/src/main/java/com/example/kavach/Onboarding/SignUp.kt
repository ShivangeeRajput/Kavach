package com.Onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kavach.R

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportActionBar?.hide()
    }
}