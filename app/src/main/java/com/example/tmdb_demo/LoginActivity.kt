package com.example.tmdb_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions



class LoginActivity : AppCompatActivity() {

    companion object {
        const val TAG = "Login"
    }

    private var mGoogleSignInClient: GoogleSignInClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        var loginBtn: Button = findViewById(R.id.signin_btn)

        loginBtn.setOnClickListener(){
            startActivity(Intent(this@LoginActivity, TmdbActivity::class.java).putExtra("From", "LoginPage"))
        }


    }
}