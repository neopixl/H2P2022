package fr.hetic.h2p2022

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_display.*

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        if (intent != null && intent.extras != null) {
            val myMessage = intent.extras.getString("message", "")

            if (myMessage.isNotBlank()) {
                // Display the message
                displayTextView.text = myMessage
            } else {
                // Show error
                displayTextView.setText(R.string.display_empty_message)
            }
        }

        yesButton.setOnClickListener {
            sendResult(true)
        }
        noButton.setOnClickListener {
            sendResult(false)
        }




        // Exemple de sauvegarde de preferences
        val sharedPreference = PreferenceManager.getDefaultSharedPreferences(this)
        sharedPreference.edit {
            putBoolean("isMale", true)
            putString("name", "Florian")
        }
        val isMale = sharedPreference.getBoolean("isMale", false)

    }

    fun sendResult(isOk: Boolean) {
        val intent = Intent()
        intent.putExtra("isOk", isOk)

        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
