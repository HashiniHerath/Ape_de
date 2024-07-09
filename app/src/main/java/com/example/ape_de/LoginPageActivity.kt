package com.example.ape_de

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.ape_de.databinding.ActivityLoginPageBinding
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth

class LoginPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginPageBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        val loginEmail : EditText = findViewById(R.id.et_login_email)
        val loginPassword : EditText = findViewById(R.id.et_login_password)
        val loginPasswordLayout : TextInputLayout = findViewById(R.id.til_login_password)
        val btnLogin : AppCompatButton = findViewById(R.id.btn_login)

        btnLogin.setOnClickListener{
            loginPasswordLayout.isPasswordVisibilityToggleEnabled = true
            val loginmail = loginEmail.text.toString()
            val loginpwd = loginPassword.text.toString()

            if(loginmail.isEmpty() || loginpwd.isEmpty()){
                if(loginmail.isEmpty()){
                    loginEmail.error = "Enter your email address"
                }
                if (loginpwd.isEmpty()){
                    loginPassword.error = "Enter your password"
                    loginPasswordLayout.isPasswordVisibilityToggleEnabled = false
                }
                Toast.makeText(this,"Enter valid details", Toast.LENGTH_SHORT).show()

            }else if (loginmail.matches(emailPattern.toRegex())){
                loginEmail.error = "Enter valid email address"
                Toast.makeText(this, "Enter valid email address", Toast.LENGTH_SHORT).show()

            }else if(loginpwd.length < 6){
                loginPassword.error = "Password should be more than 6 characters"
                Toast.makeText(this, "Password should be more than 6 characters", Toast.LENGTH_SHORT).show()

            }else{
                firebaseAuth.signInWithEmailAndPassword(loginmail, loginpwd).addOnCompleteListener {
                    if (it.isSuccessful){
                        val intent = Intent(this, SellerAccountActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "Something went wrong, try again", Toast.LENGTH_SHORT).show()
                    }
                }
            }


        }

        binding.tvHaventAccount.setOnClickListener{
            startActivity(Intent(this,RegisterationPageActivity::class.java))
        }
    }
}