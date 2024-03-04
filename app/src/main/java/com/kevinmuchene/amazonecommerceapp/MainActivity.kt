package com.kevinmuchene.amazonecommerceapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText;
    private lateinit var passwordEditText: EditText
    private lateinit var signInButton: Button
    private lateinit var showPasswordCheckBox: CheckBox
    private lateinit var createAccountButton: Button

    companion object {
        val registeredUsers = mutableListOf(
            User("kevin", "kevin1"),
            User("iowa", "iowa1")
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailEditText = findViewById(R.id.emailId)
        passwordEditText = findViewById(R.id.passwordId)
        signInButton = findViewById(R.id.button)
        showPasswordCheckBox = findViewById(R.id.checkBox);
        createAccountButton = findViewById(R.id.createAccount)
//
        signInButton.setOnClickListener {
            validateUser();
        }

        createAccountButton.setOnClickListener{
            createAccount();
        }

    }

    private fun validateUserNameAndEmail(username: String, password: String): Boolean {
        return registeredUsers.any { it.username == username && it.password == password }
    }

    private fun validateUser() {
        val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (validateUserNameAndEmail(email, password)) {

                val intent = Intent(this, ShoppingCategory::class.java)
                startActivity(intent)
            } else {

                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_LONG).show()
            }
    }

    private fun createAccount() {
        val intent = Intent(this, CreateAccount::class.java)
        startActivity(intent)
    }
}

data class User(val username: String, val password: String)
