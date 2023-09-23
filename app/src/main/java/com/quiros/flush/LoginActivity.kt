package com.quiros.flush


import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var registerButton : TextView

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
            //if (currentUser != null) {
            //val intent = Intent(this, RegisterActivity::class.java)
            //startActivity(intent)
            //finish() // Close the LoginActivity
        //}
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth
        emailEditText = findViewById(R.id.email_input)
        passwordEditText = findViewById(R.id.password_input)
        loginButton = findViewById(R.id.login_btn)
        registerButton = findViewById(R.id.Signup2TV)

        // Set click listener for the login button
        loginButton.setOnClickListener {
            // Get the entered username and password
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Perform authentication (you should replace this with your actual authentication logic)
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        val intent = Intent(this, RegisterActivity::class.java)  // change to homepage
                        startActivity(intent)
                        finish() // Close the LoginActivity
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }
        }

        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish() // Close the LoginActivity
        }
    }




}
