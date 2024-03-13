package com.example.kavach

import HealingFragment
import ProfileFragment
import android.content.ComponentName

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.Fragments.HomeFragment
import com.Fragments.EmergencyFragment
import com.example.kavach.databinding.ActivityMainBinding

import com.google.android.material.navigation.NavigationBarView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAuth = FirebaseAuth.getInstance()
        mDbRef = FirebaseDatabase.getInstance().getReference()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportActionBar?.hide()
            replaceFragment(HomeFragment())
        }
        // Removing text labels from bottom navigation items
        binding.bottomNav.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_UNLABELED
        binding.bottomNav.setOnItemSelectedListener { menuItem ->

            when (menuItem.itemId) {
                R.id.profile -> {
                    supportActionBar?.show()
                    replaceFragment(ProfileFragment())
                }
                R.id.home -> {
                    supportActionBar?.hide()
                    replaceFragment(HomeFragment())

                }
                R.id.emergency -> {
                    openAnotherApp()
                }
                R.id.selflove -> {
                    supportActionBar?.hide()
                    replaceFragment(HealingFragment())
                }
            }
            true
        }


    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

    private fun openAnotherApp() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.component = ComponentName("com.shubham.womensafety", "com.shubham.womensafety.MainActivity")
        startActivity(intent)

    }


}

