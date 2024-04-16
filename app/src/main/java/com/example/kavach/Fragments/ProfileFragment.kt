import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kavach.R
import com.example.kavach.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up click listener for navigating to AddFragment
        binding.floatingactionbtn.setOnClickListener {
            navigateToAddFragment()
        }
    }

    private fun navigateToAddFragment() {
        // Navigate to AddFragment
        findNavController().navigate(R.id.action_listFragment_to_addFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clean up view binding
        _binding = null
    }
}
