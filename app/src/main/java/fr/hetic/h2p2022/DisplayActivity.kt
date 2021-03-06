package fr.hetic.h2p2022

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_display.*

class DisplayActivity : AppCompatActivity() {

    var myMessage = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)


        if (intent != null && intent.extras != null) {
            myMessage = intent.extras.getString("message", "")
            if (myMessage.isNotBlank()) {
                messageTextView.text = myMessage
            } else {
                messageTextView.setText(R.string.display_empty_message)
            }
        } else {
            messageTextView.setText(R.string.display_empty_message)
        }


        yesButton.setOnClickListener {
            sendResult(true)
        }
        noButton.setOnClickListener {
            sendResult(false)
        }
    }

    fun sendResult(isOk: Boolean) {
        val intent = Intent()
        intent.putExtra("isOk", isOk)


        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
