package com.uvg.signon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth

class Sign_On : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        Handler().postDelayed({
            if (user != null){
                val Map = Intent(this, Maps::class.java)
                startActivity(Map)
                finish()

            } else {
                val SignIn = Intent(this,MainActivity::class.java)
                startActivity(SignIn)
                finish()
            }

        }, 2000)
    }
}

