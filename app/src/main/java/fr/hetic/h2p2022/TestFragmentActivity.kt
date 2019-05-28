package fr.hetic.h2p2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import fr.hetic.h2p2022.fragment.TestGreenFragment
import kotlinx.android.synthetic.main.activity_test_fragment.*

class TestFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_fragment)



        val module = TestGreenFragment()
        val moduleTwo = TestGreenFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, module)
            .add(R.id.bottomFragmentContainer, moduleTwo)
            .addToBackStack("Test")
            .commit()


        fragmentContainer.postDelayed({

            supportFragmentManager.popBackStack(
                "Test",
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )

        }, 10000)

    }
}
