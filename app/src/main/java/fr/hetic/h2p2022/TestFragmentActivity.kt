package fr.hetic.h2p2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import fr.hetic.h2p2022.fragment.TestFragment
import kotlinx.android.synthetic.main.activity_test_fragment.*

class TestFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_fragment)

        val module = TestFragment()
        val moduleTwo = TestFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, module)
            .addToBackStack("one")
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.bottomFragmentContainer, moduleTwo)
            .addToBackStack("two")
            .commit()

        fragmentContainer.postDelayed({

            supportFragmentManager.popBackStack("one", FragmentManager.POP_BACK_STACK_INCLUSIVE)

        }, 10000)
    }
}
