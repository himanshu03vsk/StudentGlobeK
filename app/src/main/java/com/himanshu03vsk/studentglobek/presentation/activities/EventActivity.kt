package com.himanshu03vsk.studentglobek.presentation.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.himanshu03vsk.studentglobek.ui.theme.StudentGlobeKTheme
import kotlinx.coroutines.tasks.await

class EventActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val eventId = intent.getStringExtra("eventId") ?: ""
        val eventName = intent.getStringExtra("eventName") ?: "Event"
        val description = intent.getStringExtra("description") ?: ""
        val startDate = intent.getStringExtra("startDate") ?: ""
        val endDate = intent.getStringExtra("endDate") ?: ""
        val major = intent.getStringExtra("major") ?: ""
        val department = intent.getStringExtra("department") ?: ""
        val ownerId = intent.getStringExtra("ownerId") ?: ""

        setContent {
            StudentGlobeKTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    EventDetailScreen(
                        eventId = eventId,
                        eventName = eventName,
                        description = description,
                        startDate = startDate,
                        endDate = endDate,
                        major = major,
                        department = department,
                        ownerId = ownerId
                    )
                }
            }
        }
    }
}

@Composable
fun EventDetailScreen(
    eventId: String,
    eventName: String,
    description: String,
    startDate: String,
    endDate: String,
    major: String,
    department: String,
    ownerId: String
) {
    val context = LocalContext.current
    val currentUserId = FirebaseAuth.getInstance().currentUser?.uid
    var isRegistering by remember { mutableStateOf(false) }
    var isRegistered by remember { mutableStateOf(false) }

    // Check if user already registered
    LaunchedEffect(eventId) {
        currentUserId?.let { uid ->
            val doc = FirebaseFirestore.getInstance().collection("events").document(eventId).get().await()
            val registeredUsers = doc.get("registeredUsers") as? List<*> ?: emptyList<Any>()
            isRegistered = uid in registeredUsers
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = eventName, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Major: $major")
            Text("Department: $department")
            Text("Start: $startDate")
            Text("End: $endDate")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Description:\n$description")
        }

        if (!isRegistered) {
            Button(
                onClick = {
                    isRegistering = true
                    currentUserId?.let { uid ->
                        FirebaseFirestore.getInstance().collection("events")
                            .document(eventId)
                            .update("registeredUsers", FieldValue.arrayUnion(uid))
                            .addOnSuccessListener {
                                Toast.makeText(context, "Registered successfully!", Toast.LENGTH_SHORT).show()
                                isRegistered = true
                            }
                            .addOnFailureListener {
                                Toast.makeText(context, "Failed to register: ${it.message}", Toast.LENGTH_SHORT).show()
                            }
                            .addOnCompleteListener {
                                isRegistering = false
                            }
                    }
                },
                enabled = !isRegistering,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = if (isRegistering) "Registering..." else "Register")
            }
        } else {
            Text(
                text = "You are registered for this event.",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
