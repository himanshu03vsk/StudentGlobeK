package com.himanshu03vsk.studentglobek.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.himanshu03vsk.studentglobek.ui.theme.StudentGlobeKTheme

class ChatroomActivity : ComponentActivity() {
    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val chatroomId = intent.getStringExtra("chatroomId") ?: ""
        val chatroomName = intent.getStringExtra("chatroomName") ?: "Chatroom"

        setContent {
            StudentGlobeKTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(chatroomName) },
                            actions = {
                                TextButton(onClick = {
                                    leaveChatroom(chatroomId)
                                }) {
                                    Text("Leave")
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("You're in $chatroomName")
                    }
                }
            }
        }
    }

    private fun leaveChatroom(chatroomId: String) {
        val uid = auth.currentUser?.uid ?: return

        db.collection("chatrooms").document(chatroomId)
            .update("members", FieldValue.arrayRemove(uid))
            .addOnSuccessListener {
                Toast.makeText(this, "Left chatroom", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to leave chatroom", Toast.LENGTH_SHORT).show()
            }
    }
}
