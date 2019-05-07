package fr.hetic.h2p2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TextWatcher {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        validateButton.setOnClickListener {
            onUserTryLogin()
        }


        emailField.addTextChangedListener(this)
        passwordField.addTextChangedListener(this)
    }

    fun onUserTryLogin() {

        val email = emailField.text.toString()
        val password = passwordField.text.toString()


        Toast.makeText(this, "CLICK !! ($email / $password)", Toast.LENGTH_SHORT).show()
    }

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        val email = emailField.text.toString()
        val password = passwordField.text.toString()

        val isValid = email.isNotBlank()
                && password.isNotBlank()

        if (isValid) {
            validateButton.setBackgroundResource(R.color.green)
        } else {
            validateButton.setBackgroundResource(R.color.red)
        }
    }
}
