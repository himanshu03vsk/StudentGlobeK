


//TODO: maybe add Chatroom Description as a field too
package com.himanshu03vsk.studentglobek.presentation.activities
import com.himanshu03vsk.studentglobek.presentation.components.TextFieldInputFunction
import com.himanshu03vsk.studentglobek.presentation.components.LargeInputBox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.himanshu03vsk.studentglobek.presentation.components.TopAppBarComponent
import com.himanshu03vsk.studentglobek.ui.theme.StudentGlobeKTheme
import kotlin.math.exp

class CreateEventActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentGlobeKTheme {
                // Layout for creating a chatroom
                var eventName by remember { mutableStateOf("") }
                var majorName by remember { mutableStateOf("") }
                var startDate by remember { mutableStateOf("") }
                var endDate by remember { mutableStateOf("") }

                var descValue by remember { mutableStateOf("") }

                var departmentName by remember { mutableStateOf("") }
                var selectedChatRoomType by remember { mutableStateOf("") }
                var mExpanded by remember { mutableStateOf(false) }

                // Available chatroom types

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TopAppBarComponent("Create an Event")

                    // Layout for chatroom creation
                    Column(
                        modifier = Modifier.fillMaxSize().padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))

                        // Using TextFieldInputFunction to get user input for chatroom name
                        TextFieldInputFunction(
                            label = "Event Name",
                            value = eventName,
                            onValueChange = { eventName = it }
                        )

                        Spacer(modifier = Modifier.height(8.dp))




                        // OutlinedTextField with a TrailingIcon for chatroom type
//                        OutlinedTextField(
//                            value = selectedChatRoomType,
//                            onValueChange = { selectedChatRoomType = it },
//                            modifier = Modifier.fillMaxWidth(),
//                            label = { Text("Chatroom Type") },
//                            trailingIcon = {
//                                val icon = if (mExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown
//                                Icon(
//                                    icon,
//                                    contentDescription = "Dropdown Icon",
//                                    modifier = Modifier.clickable { mExpanded = !mExpanded }
//                                )
//                            }
//                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // If the dropdown is expanded, show the chatroom types
//                        ChatroomTypeDropdown(onOptionSelected = { selectedChatRoomType = it })
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

                        // Using TextFieldInputFunction for major and department
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

                        LargeInputBox(label = "Description of the Event", value = descValue, onValueChange = {descValue = it})
                        Spacer(modifier = Modifier.weight(1f))
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .padding(32.dp) // Adds padding around the button
                                .fillMaxWidth(),
                            // Makes the button take up the full width
                        ) {
                            Text(text = "Create") // The text shown on the button
                        }
                    }
                }
            }
        }
    }
}



//
//@Composable
//fun ChatroomTypeRadioButtons() {
//    var selectedOption by remember { mutableStateOf("Semester") } // Default selection
//
//    // List of options for the radio buttons
//    val options = listOf("Semester", "Event")
//
//    Column(modifier = Modifier.border(1.dp, MaterialTheme.colorScheme.onPrimary, shape = MaterialTheme.shapes.medium)) {
//        options.forEach { option ->
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clickable {
//                        // Update the selected option when the row is clicked
//                        selectedOption = option
//                    }
//                , // Add padding for the row
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                RadioButton(
//                    selected = selectedOption == option, // Check if this option is selected
//                    onClick = { selectedOption = option } // Update the selected option when the radio button is clicked
//                )
//                Spacer(modifier = Modifier.width(8.dp))
//                Text(text = option)
//            }
//        }
//    }
//}

