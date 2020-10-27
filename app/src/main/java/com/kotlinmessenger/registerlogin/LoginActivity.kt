package com.kotlinmessenger.registerlogin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.kotlinmessenger.R
import com.kotlinmessenger.messages.LatestMessagesActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button_login.setOnClickListener{
            performLogin()
        }

        back_to_register_text_view.setOnClickListener{
            finish()
        }
    }

    private fun performLogin() {
        val email = email_edittext_login.text.toString()
        val password = password_edittext_login.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter the email and the password", Toast.LENGTH_SHORT).show()
            return
        }

        Log.d("Login", "Attempt login with email: $email")

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (!it.isSuccessful) return@addOnCompleteListener

                // else
                Log.d("Main", "User signed in successfully!")
                val intent = Intent(this, LatestMessagesActivity::class.java)
                startActivity(intent)
            }
            .addOnFailureListener {
                Log.d("Main", "User could not sign in!")
                Toast.makeText(this, "Failed to sign in: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }
}