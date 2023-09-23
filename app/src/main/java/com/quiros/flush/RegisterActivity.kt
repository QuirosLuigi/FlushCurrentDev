package com.quiros.flush

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {


    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var cpasswordEditText: EditText
    private lateinit var signupButton: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var loginbutton : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = Firebase.auth
        emailEditText = findViewById(R.id.EmailET)
        passwordEditText = findViewById(R.id.PasswordET)
        cpasswordEditText = findViewById(R.id.CPasswordET)
        signupButton = findViewById(R.id.signup_btn)
        loginbutton = findViewById(R.id.Login2TV)

        signupButton.setOnClickListener {
            Log.i("meow","tanginamu")
            Log.i("meow", passwordEditText.text.toString())
            Log.i("meow", cpasswordEditText.text.toString())
            if(passwordEditText.text.toString() == cpasswordEditText.text.toString()){
                auth.createUserWithEmailAndPassword(emailEditText.text.toString(),passwordEditText.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success")
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            finish() // Close the LoginActivity
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.exception)
                            Toast.makeText(
                                baseContext,
                                "Authentication failed.",
                                Toast.LENGTH_SHORT,
                            ).show()
                        }
                    }
            }
            else
                Toast.makeText(
                    baseContext,
                    "Password and Confirm Password Doesn't Match",
                    Toast.LENGTH_SHORT,
                ).show()
        }
        loginbutton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Close the LoginActivity
        }



    }
}