package com.quiros.flush


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    //private lateinit var usernameEditText: EditText
    //private lateinit var passwordEditText: EditText
    //private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize UI elements
        //usernameEditText = findViewById(R.id.usernameEditText)
        //passwordEditText = findViewById(R.id.passwordEditText)
        //loginButton = findViewById(R.id.loginButton)

        // Set click listener for the login button
        /*loginButton.setOnClickListener {
            // Get the entered username and password
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Perform authentication (you should replace this with your actual authentication logic)
            val isAuthenticated = authenticateUser(username, password)

            if (isAuthenticated) {
                // Authentication successful, navigate to the next activity
                //val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish() // Close the LoginActivity
            } else {
                // Authentication failed, display a message to the user
                Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Replace this with your actual authentication logic
    private fun authenticateUser(username: String, password: String): Boolean {
        // Example: Check if username and password match a valid user
        return username == "user" && password == "password" */
    }
}
