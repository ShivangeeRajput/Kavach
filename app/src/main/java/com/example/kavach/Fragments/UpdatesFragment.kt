package com.Fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kavach.databinding.FragmentUpdatesBinding

class UpdatesFragment : Fragment() {

    private var _binding: FragmentUpdatesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdatesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    // Handling the cardview click
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cvhelp.setOnClickListener {
            openUrl("https://www.ncwwomenhelpline.in/")
        }
        binding.cvlaw.setOnClickListener {
            openUrl("http://ncw.nic.in/important-links/List-of-Laws-Related-to-Women")
        }
        binding.cvwsafety.setOnClickListener {
            openUrl("https://pib.gov.in/Pressreleaseshare.aspx?PRID=1575574")
        }
        binding.cvselfDefence.setOnClickListener {
            openUrl("https://www.healthline.com/health/womens-health/self-defense-tips-escape")
        }
        binding.cvnews.setOnClickListener {
            openUrl("https://www.healthline.com/health/womens-health/self-defense-tips-escape")
        }
        binding.cvanon.setOnClickListener {
            openUrl("https://hood.live/ ")
        }
    }

    private fun openUrl(link: String) {
        val uri = Uri.parse(link)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
