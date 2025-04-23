package com.himanshu03vsk.studentglobek.presentation.components

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.*

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.himanshu03vsk.studentglobek.domain.model.Chatroom
import com.himanshu03vsk.studentglobek.presentation.activities.ChatroomActivity

@Composable
fun ChatroomCardCompact(chatroom: Chatroom) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .width(200.dp)
            .clickable {
                val intent = Intent(context, ChatroomActivity::class.java).apply {
                    putExtra("chatroomId", chatroom.id)
                    putExtra("chatroomName", chatroom.name)
                }
                context.startActivity(intent)
            },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = chatroom.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "Major: ${chatroom.major}", style = MaterialTheme.typography.bodySmall)
        }
    }
}
