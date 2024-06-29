package com.example.kotlinsimplechat.ui.screens.chat.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.kotlinsimplechat.ui.models.MessageModel


import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import com.example.kotlinsimplechat.enum.MessageRole
import com.example.kotlinsimplechat.ui.models.ChatState



@Composable
fun SendMessageView(chatState: ChatState) {
    val focusRequester = remember { FocusRequester() }
    val newMessage = rememberSaveable { mutableStateOf("") }

    TextField(
        value = newMessage.value,
        onValueChange = { newValue ->
            newMessage.value = newValue
        },
        placeholder = {
            Text("Enter your question ...")
        },
        trailingIcon = {
            IconButton(
                onClick = {
                    if (newMessage.value.trim().isNotEmpty()) {
                        //                        localFocusManager.clearFocus()
                        chatState.sendMessage(
                            MessageModel(
                                text = newMessage.value.trim(),
                                role = MessageRole.User
                            )
                        )
                        newMessage.value = ""
                    }
                },
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Send,
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = "Send"
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(focusRequester)
    )

    DisposableEffect(Unit) {
        focusRequester.requestFocus()
        onDispose { }
    }
}