@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.kotlinsimplechat.ui.screens.chat
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import com.example.kotlinsimplechat.ui.models.ChatState
import com.example.kotlinsimplechat.ui.screens.chat.components.ChatMessageView
import com.example.kotlinsimplechat.ui.screens.chat.components.SendMessageView

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun ChatView() {
    val localFocusManager = LocalFocusManager.current
    val chatState = ChatState()

    Scaffold(
        topBar = {
            TopAppBar(
                scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(canScroll = {false}),
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
                        title = {
                    Text("Gemi Chat", style = MaterialTheme.typography.bodyLarge.copy(color = Color.White, fontWeight = FontWeight.Bold))
                }
            )
        },

        modifier = Modifier.pointerInput(Unit) {
            detectTapGestures(onTap = {
                localFocusManager.clearFocus()
            })
        }) {
        innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            ChatMessageView(chatState = chatState, modifier = Modifier.weight(1f))
            SendMessageView(chatState = chatState)
        }
    }
}
