package fr.hetic.h2p2022

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
    }
}
