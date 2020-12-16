package com.example.socialapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import java.time.Instant

class PasswordChangeActivity : AppCompatActivity() {

    private lateinit var changePasswordEditText: EditText
    private lateinit var changePasswordbutton: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        mAuth = FirebaseAuth.getInstance()
        changePasswordEditText = findViewById(R.id.changePasswordEditText)
        changePasswordbutton = findViewById(R.id.changePasswordbutton)

        changePasswordbutton.setOnClickListener {
            val newPassword=changePasswordEditText.text.toString()
            if (newPassword.isEmpty()){
                Toast.makeText(this, "Empty!", Toast.LENGTH_SHORT).show()
            }else{
                mAuth.currentUser?.updatePassword(newPassword)?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, PersonActivity::class.java))
                        finish()

                    }else{
                        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
                    }
                }
            }



        }
        changePasswordEditText.setOnClickListener {


        }





        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change)
    }
}