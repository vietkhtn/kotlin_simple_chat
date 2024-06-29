package com.example.kotlinsimplechat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.kotlinsimplechat.ui.screens.chat.ChatView
import com.example.kotlinsimplechat.ui.theme.KotlinSimpleChatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinSimpleChatTheme {
                ChatView()
            }
        }
    }
}
