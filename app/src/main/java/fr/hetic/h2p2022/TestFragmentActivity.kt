package fr.hetic.h2p2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.hetic.h2p2022.fragment.TestFragment

class TestFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_fragment)

        val module = TestFragment()
        val moduleTwo = TestFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, module)
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.bottomFragmentContainer, moduleTwo)
            .commit()
    }
}
