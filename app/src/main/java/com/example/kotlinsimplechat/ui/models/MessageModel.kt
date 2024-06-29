package com.example.kotlinsimplechat.ui.models

import com.example.kotlinsimplechat.enum.MessageRole

data class MessageModel (
    val text: String = "",
    val role: MessageRole = MessageRole.User
)