package com.himanshu03vsk.studentglobek.presentation.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.himanshu03vsk.studentglobek.ui.theme.StudentGlobeKTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.ui.Alignment

class ChatroomActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentGlobeKTheme {
                // Main Scaffold to hold our layout
                Scaffold(
                    topBar = {
                        ChatroomTopAppBar(
                            title = "Chatroom",
                            onBackPressed = {
                                // Handle back navigation, like finishing the activity or navigating back
                                finish() // Example to close the activity
                            },
                            onLeaveChatroom = {
                                // Handle leave chatroom action
                                // You can show a confirmation or leave the chatroom logic
                                Toast.makeText(this, "You left the chatroom.", Toast.LENGTH_SHORT).show()
                            }
                        )
                    },
                    content = { innerPadding ->
                        // Main chatroom content goes here
                        ChatroomContent(innerPadding)
                    }
                )
            }
        }
    }
}

@Composable
fun ChatroomContent(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Example content for the chatroom
        Text(text = "Welcome to the Chatroom!")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "This is where the chat messages will appear.")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatroomTopAppBar(
    title: String,
    onBackPressed: () -> Unit,
    onLeaveChatroom: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) } // for three-dot menu

    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
        },
        actions = {
            // Three-dot menu (overflow menu)
            IconButton(onClick = { expanded = !expanded }) {
                Icon(Icons.Filled.MoreVert, contentDescription = "More options")
            }

            // Corrected DropdownMenu implementation
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    onClick = {
                        expanded = false // Handle leaving chatroom
                        onLeaveChatroom()
                    },
                    text = { Text("Leave Chatroom") }
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        modifier = Modifier.fillMaxWidth()
    )
}



@Preview(showBackground = true)
@Composable
fun PreviewChatroomTopAppBar() {
    ChatroomTopAppBar(
        title = "Chatroom",
        onBackPressed = { /* Handle back press */ },
        onLeaveChatroom = { /* Handle leave chatroom */ }
    )
}
