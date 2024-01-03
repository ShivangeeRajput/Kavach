package com.OtpVerification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.Activities.MainActivity
import com.Fragments.HomeFragment
import com.example.kavach.R
import com.example.kavach.databinding.ActivityEnterNumberBinding
import com.google.firebase.Firebase
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit


class EnterNumber : AppCompatActivity() {


//    private lateinit var auth: FirebaseAuth

//
//    private var storedVerificationId: String? = ""
//    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
//    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEnterNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
//
//        auth= Firebase.auth
        val edtPhone=findViewById<EditText>(R.id.edtPhone)
        val btnnext = findViewById<Button>(R.id.btnnext)
        btnnext.setOnClickListener({
            val intent = Intent(this@EnterNumber, VerifyNumber::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
//            finish()
        })
//        // [START initialize_auth]
//        // Initialize Firebase Auth
//        auth = Firebase.auth
        // [END initialize_auth]
//
//        // Initialize phone auth callbacks
//        // [START phone_auth_callbacks]
//        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//
//            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
//                Log.d(TAG, "onVerificationCompleted:$credential")
//                signInWithPhoneAuthCredential(credential)
//            }
//
//            override fun onVerificationFailed(e: FirebaseException) {
//                // This callback is invoked in an invalid request for verification is made,
//                // for instance if the the phone number format is not valid.
//                Log.w(TAG, "onVerificationFailed", e)
//
//                if (e is FirebaseAuthInvalidCredentialsException) {
//                    // Invalid request
//                } else if (e is FirebaseTooManyRequestsException) {
//                    // The SMS quota for the project has been exceeded
//                } else if (e is FirebaseAuthMissingActivityForRecaptchaException) {
//                    // reCAPTCHA verification attempted with null Activity
//                }
//
//                // Show a message and update the UI
//            }
//
//            override fun onCodeSent(
//                verificationId: String,
//                token: PhoneAuthProvider.ForceResendingToken,
//            ) {
//                // The SMS verification code has been sent to the provided phone number, we
//                // now need to ask the user to enter the code and then construct a credential
//                // by combining the code with a verification ID.
//                Log.d(TAG, "onCodeSent:$verificationId")
//
//                // Save verification ID and resending token so we can use them later
//                storedVerificationId = verificationId
//                resendToken = token
//                val intent=Intent(this@EnterNumber,VerifyNumber::class.java)
//                intent.putExtra("storedVerificationId",storedVerificationId)
//                startActivity(intent)
//            }
//        }
//        // [END phone_auth_callbacks]
//        binding.btnnext.setOnClickListener({
//            //pass mobile number
//            startPhoneNumberVerification(binding.edtPhone.text.toString())
//        })
//    }



//    private fun startPhoneNumberVerification(phoneNumber: String) {
//        // [START start_phone_auth]
//        val options = PhoneAuthOptions.newBuilder(auth)
//            .setPhoneNumber("+91"+phoneNumber) // Phone number to verify
//            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
//            .setActivity(this) // Activity (for callback binding)
//            .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
//            .build()
//        PhoneAuthProvider.verifyPhoneNumber(options)
        // [END start_phone_auth]
    }
    // [START sign_in_with_phone]
    // [START sign_in_with_phone]
//    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
//        auth.signInWithCredential(credential)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Log.d(TAG, "signInWithCredential:success")

                    // If phone auth success then redirecting it to the HomeFragment

//                    val intent = Intent(this@EnterNumber, MainActivity::class.java)
//                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
//                    startActivity(intent)
//                    finish()
//                } else {
//                    // Sign in failed, display a message and update the UI
//                    Log.w(TAG, "signInWithCredential:failure", task.exception)
//                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
//                        // The verification code entered was invalid
//                    }
//                    // Update UI
//                }
//            }
    }
// [END sign_in_with_phone]

    // [END sign_in_with_phone]

//    private fun updateUI(user: FirebaseUser? = auth.currentUser) {
//    }
//
//    companion object {
//        private const val TAG = "PhoneAuthActivity"
//    }
//}