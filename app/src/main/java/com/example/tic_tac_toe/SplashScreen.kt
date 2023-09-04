package com.example.tic_tac_toe

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val screen = object:Thread(){
            override fun run() {
                try {
                    Thread.sleep(1500)
                    val intent = Intent(baseContext,MainActivity::class.java)
                    startActivity(intent)
                    finish()// this will kill the splash screen when onBackpressed() call
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        }
        screen.start()
    }

}