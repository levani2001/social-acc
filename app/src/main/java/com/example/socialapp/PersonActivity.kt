package com.example.socialapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class PersonActivity : AppCompatActivity() {

    private lateinit var personinfotextView: TextView
    private lateinit var passwordChangeButton: Button
    private lateinit var logoutButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        mAuth = FirebaseAuth.getInstance()
        personinfotextView= findViewById(R.id.personinfotextView)
        passwordChangeButton = findViewById(R.id.passwordChangeButton)
        logoutButton = findViewById(R.id.logoutButton)

        personinfotextView.text = mAuth.currentUser?.uid

        logoutButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            mAuth.signOut()
        }
        passwordChangeButton.setOnClickListener {
            startActivity(Intent(this, PasswordChangeActivity::class.java))
        }



    }
}