package com.saulawa.diary.andelachallenge2020

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed


class SplashScreen : AppCompatActivity() {

    private val SPLASH_DISPLAY_DURATION = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        Handler().postDelayed(Runnable { /* Create an Intent that will start the Menu-Activity. */
            val mainIntent = Intent(this@SplashScreen, Home::class.java)
            this@SplashScreen.startActivity(mainIntent)
            this@SplashScreen.finish()
        }, SPLASH_DISPLAY_DURATION.toLong())

    }
}