package com.example.kotlinsimplechat.ui.screens.chat.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.kotlinsimplechat.enum.MessageRole
import com.example.kotlinsimplechat.ui.models.ChatState
import kotlinx.coroutines.launch

@Composable
fun ChatMessageView(chatState: ChatState, modifier: Modifier) {
    val lazyColumnListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LazyColumn(
        state = lazyColumnListState,
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        coroutineScope.launch {
            lazyColumnListState.animateScrollToItem(chatState.messages.size)
        }
        items(chatState.messages) { message ->
            Surface(
                shape = RoundedCornerShape(
                    topStartPercent = 16,
                    topEndPercent = 16,
                    bottomStartPercent = if (message.role == MessageRole.User)  16 else 0,
                    bottomEndPercent = if (message.role == MessageRole.User)  0 else 16
                ),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 24.dp,
                        bottom = 4.dp
                    )
                    .wrapContentWidth(align = if (message.role == MessageRole.User) Alignment.End else Alignment.Start)
            ) {
                Text(text = message.text,
                    textAlign = TextAlign.End,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }
}