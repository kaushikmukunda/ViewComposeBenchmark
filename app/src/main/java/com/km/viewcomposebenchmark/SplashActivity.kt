package com.km.viewcomposebenchmark

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Text("Splash Screen")
        }

        lifecycleScope.launchWhenCreated {
            delay(100)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }
}