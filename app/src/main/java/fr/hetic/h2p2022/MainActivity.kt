package fr.hetic.h2p2022

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), TextWatcher {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        validateButton.setOnClickListener {
            onUserTryLogin()
        }
        scrollViewButton.setOnClickListener {
            val intent = Intent(this, ScrollViewActivity::class.java)
            startActivity(intent)
        }
        displayButton.setOnClickListener {
            val emailAsString = emailField.text.toString()

            val intent = Intent(this, DisplayActivity::class.java)
            intent.putExtra("KEY", "VALUE")
            intent.putExtra("KEY2", false)
            intent.putExtra("KEY3", 78)
            intent.putExtra("message", "Ceci est un message trop cool : $emailAsString")
            startActivityForResult(intent, 5)
        }
        cameraButton.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivityForResult(intent, 98)
        }
        listButton.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)

            startActivity(intent)
        }
        rickButton.setOnClickListener {
            val intent = Intent(this, RickMortyActivity::class.java)
            startActivity(intent)
        }

        emailField.addTextChangedListener(this)
        passwordField.addTextChangedListener(this)

        // Exemple de creation en code *NE PAS FAIRE*
        // --- DEBUT
        val newTextView = TextView(this)
        newTextView.text = "My Custom text view"
        newTextView.setBackgroundResource(R.color.red)

        val layoutParam = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        newTextView.layoutParams = layoutParam

        mainContainer.addView(newTextView)
        // --- FIN

    }

    fun onUserTryLogin() {

        val email = emailField.text.toString()
        val password = passwordField.text.toString()


        val alertBuild = AlertDialog.Builder(this, R.style.CustomDialog)
        alertBuild.setMessage("CLICK !! ($email / $password)")
        alertBuild.setCancelable(true)
        alertBuild.setIcon(R.drawable.logo)
        alertBuild.setPositiveButton("OK") { dialog, which ->

        }

        val dialog = alertBuild.create()
        dialog.show()

        //Toast.makeText(this, "CLICK !! ($email / $password)", Toast.LENGTH_SHORT).show()
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

        if (requestCode == 5 && resultCode == Activity.RESULT_OK) {
            val isOk = data?.extras?.getBoolean("isOk") ?: false

            Toast.makeText(this, "$isOk", Toast.LENGTH_LONG).show()

        } else if (requestCode == 98 && resultCode == Activity.RESULT_OK) {

            Toast.makeText(this, "HERE IS A PHOTO", Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(this, "IS NOTHING !!", Toast.LENGTH_LONG).show()
        }
    }
}
