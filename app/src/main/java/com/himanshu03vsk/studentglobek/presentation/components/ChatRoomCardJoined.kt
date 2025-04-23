package com.himanshu03vsk.studentglobek.presentation.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.firebase.Timestamp
import com.himanshu03vsk.studentglobek.domain.model.Chatroom
import com.himanshu03vsk.studentglobek.presentation.components.TopAppBarComponent
import com.himanshu03vsk.studentglobek.ui.theme.StudentGlobeKTheme
import com.himanshu03vsk.studentglobek.presentation.viewmodel.JoinedChatRoomsViewModel
import java.text.SimpleDateFormat
import java.util.*



@Composable
fun ChatroomCardJoined(chatroom: Chatroom) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { val intent = Intent(context, ChatroomActivity::class.java).apply {
                putExtra("chatroomId", chatroom.id) // Pass chatroom ID
                putExtra("chatroomName", chatroom.name) // Pass chatroom name
            }
                context.startActivity(intent) },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = chatroom.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "Major: ${chatroom.major}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Department: ${chatroom.department}", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}
