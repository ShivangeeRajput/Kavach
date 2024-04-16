import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.kavach.R

class HealingFragment : Fragment() {

    private lateinit var spinButton: Button
    private lateinit var spinnerImageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_healing, container, false)

        spinButton = view.findViewById(R.id.spinWheel)
        spinnerImageView = view.findViewById(R.id.spinner)

        spinButton.setOnClickListener {
            spinWheel()
        }

        return view
    }
    private fun spinWheel() {
        // Reset the rotation of the spinner ImageView
        spinnerImageView.rotation = 0f

        // Generate a random rotation angle
        val randomAngle = (0..359).random().toFloat()

        // Set up ObjectAnimator for rotation animation with the random angle
        val rotate = ObjectAnimator.ofFloat(spinnerImageView, "rotation", 0f, randomAngle)
        rotate.duration = 2000 // Set duration for the animation
        rotate.interpolator = AccelerateDecelerateInterpolator() // Set interpolator for smooth acceleration and deceleration

        // Start the rotation animation
        rotate.start()
    }


}
