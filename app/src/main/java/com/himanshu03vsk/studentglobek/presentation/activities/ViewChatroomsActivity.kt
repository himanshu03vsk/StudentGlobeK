package com.himanshu03vsk.studentglobek.presentation.activities


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.himanshu03vsk.studentglobek.ui.theme.StudentGlobeKTheme
import com.himanshu03vsk.studentglobek.presentation.components.TopAppBarComponent
import com.himanshu03vsk.studentglobek.presentation.components.ChatRoomCardSearch


// 1. Create a data class for ChatRoom
data class ChatRoom(
    val roomTitle: String,
    val roomMembers: Int,
    val roomDepartment: String,
    val roomMajor: String
)

class ViewChatroomsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val chatRooms = listOf(
            ChatRoom("AI1 VKGK", 25, "Computer Science", "Software Engineering"),
            ChatRoom("MAE1 Bill Maker", 5, "Engineering", "Mechanical Engineering"),
            ChatRoom("MATH1 Elizaeth P.", 15, "Mathematics", "Applied Math")
        )

        setContent {
            StudentGlobeKTheme {
                // Layout for creating a chatroom
                Scaffold(modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background) { padding ->

                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        TopAppBarComponent("View Chatrooms")
                        Column(
                            modifier = Modifier.fillMaxSize().padding(8.dp),


                            ) {
                            Spacer(modifier = Modifier.height(16.dp))

                            LazyColumn {
                                items(chatRooms) { chatRoom ->
                                    ChatRoomCardSearch(chatRoom = chatRoom)
                                }
                            }


                        }
                    }
                }
            }
        }
    }
}
