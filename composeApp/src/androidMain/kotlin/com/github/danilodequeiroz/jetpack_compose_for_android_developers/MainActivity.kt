package com.github.danilodequeiroz.jetpack_compose_for_android_developers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.github.danilodequeiroz.jetpack_compose_for_android_developers.app.MainAppFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            MainAppFlow()
        }
    }
}