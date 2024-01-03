package com.Activities

import ProfileFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.Fragments.HomeFragment
import com.Fragments.UpdatesFragment
import com.example.kavach.R
import com.example.kavach.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference
    private lateinit var binding: ActivityMainBinding

//    private lateinit var viewPager1: ViewPager2
//    private lateinit var indicator1: CircleIndicator3
//
//    private lateinit var viewPager2: ViewPager2
//    private lateinit var indicator2: CircleIndicator3
//
//    private lateinit var viewPager3: ViewPager2
//    private lateinit var indicator3: CircleIndicator3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAuth = FirebaseAuth.getInstance()
        mDbRef= FirebaseDatabase.getInstance().getReference()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null) {
            supportActionBar?.hide()
            replaceFragment(HomeFragment())
        }


        binding.bottomNav.selectedItemId = R.id.home

        binding.bottomNav.setOnItemSelectedListener {

            when(it.itemId){
                //declare all bottom navigation here like home and learn
                R.id.profile -> {
                    supportActionBar?.show()
                    replaceFragment(ProfileFragment())
                }
                R.id.home -> { supportActionBar?.hide()
                    replaceFragment(HomeFragment())
                }
                R.id.updates -> { supportActionBar?.hide()
                    replaceFragment(UpdatesFragment())
                }
            }
            true
        } }



    private fun replaceFragment(fragment: Fragment){
        val fragmentManager=supportFragmentManager
        val fragmentTransaction= fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()

//
//
//    // Assuming you have ViewPager, indicator, and ViewPagerAdapter defined in your layout XML
//        val titles = listOf("Title 1", "Title 2", "Title 3")
//        val slogans = listOf("Slogan 1", "Slogan 2", "Slogan 3")
//        val images1 = listOf(R.drawable.splash, R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground)
//        val images2 = listOf(R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background, R.drawable.splash)
//        val images3 = listOf(R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.splash)
//
//        // Initialize and set up the first adapter
//        val adapter1 = ViewPagerAdapter(titles, slogans, images1)
//        viewPager1.adapter = adapter1
//        indicator1.setViewPager(viewPager1)
//
//        // Initialize and set up the second adapter
//        val adapter2 = ViewPagerAdapter(titles, slogans, images2)
//        viewPager2.adapter = adapter2
//        indicator2.setViewPager(viewPager2)
//
//        // Initialize and set up the third adapter
//        val adapter3 = ViewPagerAdapter(titles, slogans, images3)
//        viewPager3.adapter = adapter3
//        indicator3.setViewPager(viewPager3)
//
//        // Set the splash screen as the first item in each ViewPager
//        viewPager1.setCurrentItem(0, false)
//        viewPager2.setCurrentItem(0, false)
//        viewPager3.setCurrentItem(0, false)
    }
}
