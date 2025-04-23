package com.himanshu03vsk.studentglobek.presentation.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.himanshu03vsk.studentglobek.presentation.components.LargeInputBox
import com.himanshu03vsk.studentglobek.presentation.components.TextFieldInputFunction
import com.himanshu03vsk.studentglobek.presentation.components.TopAppBarComponent
import com.himanshu03vsk.studentglobek.ui.theme.StudentGlobeKTheme

class CreateEventActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StudentGlobeKTheme {
                var eventName by remember { mutableStateOf("") }
                var majorName by remember { mutableStateOf("") }
                var startDate by remember { mutableStateOf("") }
                var endDate by remember { mutableStateOf("") }
                var descValue by remember { mutableStateOf("") }
                var departmentName by remember { mutableStateOf("") }
                val context = LocalContext.current

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TopAppBarComponent("Create an Event")

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))

                        TextFieldInputFunction(
                            label = "Event Name",
                            value = eventName,
                            onValueChange = { eventName = it }
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        TextFieldInputFunction(
                            label = "Start Date (MM-DD-YYYY)",
                            value = startDate,
                            onValueChange = { startDate = it }
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        TextFieldInputFunction(
                            label = "End Date (MM-DD-YYYY)",
                            value = endDate,
                            onValueChange = { endDate = it }
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        TextFieldInputFunction(
                            label = "Major",
                            value = majorName,
                            onValueChange = { majorName = it }
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        TextFieldInputFunction(
                            label = "Department",
                            value = departmentName,
                            onValueChange = { departmentName = it }
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        LargeInputBox(
                            label = "Description of the Event",
                            value = descValue,
                            onValueChange = { descValue = it }
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Button(
                            onClick = {
                                // Firebase logic
                                val db = FirebaseFirestore.getInstance()
                                val auth = FirebaseAuth.getInstance()
                                val userId = auth.currentUser?.uid

                                if (userId != null && eventName.isNotEmpty()) {
                                    val eventData = hashMapOf(
                                        "eventName" to eventName,
                                        "startDate" to startDate,
                                        "endDate" to endDate,
                                        "major" to majorName,
                                        "department" to departmentName,
                                        "description" to descValue,
                                        "createdAt" to Timestamp.now(),
                                        "ownerId" to userId
                                    )

                                    val eventRef = db.collection("events").document() // Create doc with auto ID
                                    val eventId = eventRef.id

                                    eventData["eventId"] = eventId // Store eventId inside doc

                                    eventRef.set(eventData)
                                        .addOnSuccessListener {
                                            Toast.makeText(context, "Event Created", Toast.LENGTH_SHORT).show()
                                            finish() // Go back after creation
                                        }
                                        .addOnFailureListener { e ->
                                            Toast.makeText(context, "Failed: ${e.message}", Toast.LENGTH_LONG).show()
                                        }
                                } else {
                                    Toast.makeText(context, "Missing Event Name or Not Logged In", Toast.LENGTH_SHORT).show()
                                }
                            },
                            modifier = Modifier
                                .padding(32.dp)
                                .fillMaxWidth()
                        ) {
                            Text("Create")
                        }
                    }
                }
            }
        }
    }
}
