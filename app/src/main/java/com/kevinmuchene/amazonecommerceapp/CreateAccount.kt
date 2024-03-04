package com.kevinmuchene.amazonecommerceapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreateAccount : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var reEnterPasswordEditText:EditText
    private lateinit var confirmButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        nameEditText = findViewById(R.id.nameId)
        emailEditText = findViewById(R.id.numberOrEmailId)
        passwordEditText = findViewById(R.id.passwordId)
        reEnterPasswordEditText = findViewById(R.id.reEnterPasswordId)
        confirmButton = findViewById(R.id.confirmButton)

        confirmButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val reEnterPassword = reEnterPasswordEditText.text.toString()

            if (password == reEnterPassword) {

                if (MainActivity.registeredUsers.any { it.username == name }) {
                    Toast.makeText(this, "User already exists", Toast.LENGTH_LONG).show()
                } else {

                    MainActivity.registeredUsers.add(User(email, password))
                    Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            } else {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_LONG).show()
            }
        }
    }
}
