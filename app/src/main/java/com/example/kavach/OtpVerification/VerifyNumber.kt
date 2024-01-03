package com.OtpVerification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.Activities.MainActivity
import com.Fragments.HomeFragment
import com.Onboarding.Welcome_Screen
import com.example.kavach.R
import com.example.kavach.databinding.ActivityEnterNumberBinding
import com.example.kavach.databinding.ActivityVerifyNumberBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.*

class VerifyNumber : AppCompatActivity() {

//    private lateinit var auth: FirebaseAuth
//    private lateinit var binding: ActivityVerifyNumberBinding
    private lateinit var edt_otp:EditText
    private lateinit var btnv:Button
//    private var storedVerificationId: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityVerifyNumberBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        setContentView(R.layout.activity_verify_number)
        supportActionBar?.hide()

        edt_otp = findViewById(R.id.edt_otp)
        btnv = findViewById(R.id.btnv)

       btnv.setOnClickListener({
           val intent=Intent(this@VerifyNumber,MainActivity::class.java)
           startActivity(intent)
       })

//        auth = Firebase.auth
//        storedVerificationId = intent.getStringExtra("storedVerificationId")

//        btnv.setOnClickListener {
//            verifyPhoneNumberWithCode(storedVerificationId, edt_otp.text.toString())
//        }
//
    }
//    private fun verifyPhoneNumberWithCode(verificationId: String?, code: String) {
//        // [START verify_with_code]
//        val credential = PhoneAuthProvider.getCredential(verificationId!!, code)
//        // [END verify_with_code]
//        signInWithPhoneAuthCredential(credential)
//    }
//    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
//        auth.signInWithCredential(credential)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Log.d("Success", "signInWithCredential:success")
//
//                    val user = task.result?.user
//                    //pass user value to home if needed
//                    val intent=Intent(this@VerifyNumber, MainActivity::class.java)
//                    startActivity(intent)
//                } else {
//                    // Sign in failed, display a message and update the UI
//                    Log.w("Failed", "signInWithCredential:failure", task.exception)
//                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
//                        // The verification code entered was invalid
//                    }
//                    // Update UI
//                }
//            }
//    }

}