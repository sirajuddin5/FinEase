package com.example.finease

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import java.util.Objects

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler().postDelayed({

            val i = Intent(
                this,
                GetStarted::class.java
            )

            startActivity(i)

            finish()
        }, 3000)

//        val intent = Intent(this, SplashActivity::class.java)
//        startActivity(intent)

    }

}