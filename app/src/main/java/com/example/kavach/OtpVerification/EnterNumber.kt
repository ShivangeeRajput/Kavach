package com.OtpVerification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.kavach.R
import com.example.kavach.databinding.ActivityEnterNumberBinding
import com.example.kavach.utils.phoneNumberKey
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout


class EnterNumber : AppCompatActivity() {



    private lateinit var etPhoneNum: TextInputLayout
    private lateinit var btnGetOtp: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEnterNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        etPhoneNum = findViewById(R.id.et_phone_num)
        btnGetOtp = findViewById(R.id.btn_get_otp)


        btnGetOtp.setOnClickListener {
            validateNumber()
//            val intent=Intent(this@EnterNumber,VerifyNumber::class.java)
//            startActivity(intent)
        }
    }

    private fun validateNumber() {

        if (etPhoneNum.editText?.text.toString().isEmpty()) {
            etPhoneNum.error = "Enter your Phone Number"
            etPhoneNum.requestFocus()
            return
        }

        if (etPhoneNum.editText?.text.toString().count() == 10) {

            etPhoneNum.clearFocus()
            val intent = Intent(this, VerifyNumber::class.java).apply {
                putExtra(phoneNumberKey, etPhoneNum.editText?.text.toString())
            }
            startActivity(intent)
            finish()

        } else {
            Toast.makeText(this, "Enter 10 digit number", Toast.LENGTH_SHORT).show()
        }
    }


    }


