package com.uvg.signon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth

class Sign_On: AppCompatActivity() {

    private lateinit var AUT: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AUT = FirebaseAuth.getInstance()
        val user = AUT.currentUser

        Handler().postDelayed({
            if (user != null){
                val Mapa = Intent(this, Maps::class.java)
                startActivity(Mapa)
                finish()

            } else {
                val SignInGoogle = Intent(this,MainActivity::class.java)
                startActivity(SignInGoogle)
                finish()
            }

        }, 2000)
    }
}
