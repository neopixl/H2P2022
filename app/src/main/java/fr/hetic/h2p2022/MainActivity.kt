package fr.hetic.h2p2022

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TextWatcher {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        validateButton.text = "Yolo"
        validateButton.setOnClickListener { onUserTryToLogin() }
        scrollViewButton.setOnClickListener {
            startActivity(Intent(this, ScrollViewActivity::class.java))
        }

        emailField.addTextChangedListener(this)
        passwordField.addTextChangedListener(this)



        displayButton.setOnClickListener {
            val intent = Intent(this, DisplayActivity::class.java)
            intent.putExtra("KEY", "VALUE")
            intent.putExtra("KEY2", false)
            intent.putExtra("KEY3", 123)
            intent.putExtra("KEY4", 123.123)
            intent.putExtra("pokemonId", 2)

            val email = emailField.text.toString()
            intent.putExtra("message", "Ceci est un message trop cool : $email")
            startActivityForResult(intent, 5)
        }

    }

    fun onUserTryToLogin() {

        val email = emailField.text.toString()
        val password = passwordField.text.toString()


        val alertBuilder = AlertDialog.Builder(this, R.style.HeticDialog)
        alertBuilder.setMessage("CLICKKK !! ($email / $password)")
        alertBuilder.setCancelable(true)
        alertBuilder.setPositiveButton("OK") { dialog, which ->
            //????
        }

        val dialog = alertBuilder.create()
        dialog.show()


        //Toast.makeText(this, "CLICKKK !! ($email / $password)", Toast.LENGTH_SHORT).show()
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Activity.RESULT
        if (requestCode == 5 && resultCode == Activity.RESULT_OK) {
            val myReturnedBool = data?.extras?.getBoolean("returnedBool", false)
        }
    }
}
