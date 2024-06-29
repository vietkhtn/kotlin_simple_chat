package com.example.kotlinsimplechat.ui.models

import androidx.compose.runtime.toMutableStateList
import com.example.kotlinsimplechat.enum.MessageRole

class ChatState {
    val messages = emptyList<MessageModel>().toMutableStateList();

    fun sendMessage(message: MessageModel) {
        messages.add(message)
    }

    private fun clearHistory() {
        messages.clear()
    }
}