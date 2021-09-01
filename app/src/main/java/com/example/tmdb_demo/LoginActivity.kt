package com.example.tmdb_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.example.tmdb_demo.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    companion object {
        const val TAG = "Login"
    }

    private lateinit var binding: ActivityLoginBinding
    private var mGoogleSignInClient: GoogleSignInClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        var loginBtn: Button = binding.signinBtn

        loginBtn.setOnClickListener(){
            startActivity(Intent(this@LoginActivity, TmdbActivity::class.java).putExtra("From", "LoginPage"))
        }


    }
}