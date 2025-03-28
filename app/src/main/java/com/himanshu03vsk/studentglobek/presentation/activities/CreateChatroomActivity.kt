


//TODO: maybe add Chatroom Description as a field too
package com.himanshu03vsk.studentglobek.presentation.activities

import com.himanshu03vsk.studentglobek.presentation.components.TextFieldInputFunction
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

class CreateChatroomActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentGlobeKTheme {
                // Layout for creating a chatroom
                var chatroomName by remember { mutableStateOf("") }
                var majorName by remember { mutableStateOf("") }
                var departmentName by remember { mutableStateOf("") }
                var selectedChatRoomType by remember { mutableStateOf("") }
                var mExpanded by remember { mutableStateOf(false) }

                // Available chatroom types
                val chatRoomTypes = listOf("Semester", "Event")

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TopAppBarComponent("Create a Chatroom")

                    // Layout for chatroom creation
                    Column(
                        modifier = Modifier.fillMaxSize().padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))

                        // Using TextFieldInputFunction to get user input for chatroom name
                        TextFieldInputFunction(
                            label = "Chatroom Name",
                            value = chatroomName,
                            onValueChange = { chatroomName = it }
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
                        ChatroomTypeRadioButtons()
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




@Composable
fun ChatroomTypeRadioButtons() {
    var selectedOption by remember { mutableStateOf("Semester") } // Default selection

    // List of options for the radio buttons
    val options = listOf("Semester", "Event")

    Column(modifier = Modifier.border(1.dp, MaterialTheme.colorScheme.onPrimary, shape = MaterialTheme.shapes.medium)) {
        options.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        // Update the selected option when the row is clicked
                        selectedOption = option
                    }
                    , // Add padding for the row
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedOption == option, // Check if this option is selected
                    onClick = { selectedOption = option } // Update the selected option when the radio button is clicked
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = option)
            }
        }
    }
}

//For radio, works but doesnt click the whole thing
//@Composable
//fun ChatroomTypeRadioButtons(onOptionSelected: (String) -> Unit) {
//    // Remember the selected chatroom type
//    var selectedChatroomType by remember { mutableStateOf<String?>(null) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .border(1.dp, MaterialTheme.colorScheme.onPrimary, shape = MaterialTheme.shapes.medium),
//        horizontalAlignment = Alignment.Start
//    ) {
//        // Radio Button for "Semester"
//        Row(verticalAlignment = Alignment.CenterVertically) {
//            RadioButton(
//                selected = selectedChatroomType == "Semester",
//                onClick = {
//                    selectedChatroomType = "Semester"
//                    onOptionSelected("Semester") // Notify the parent composable of the selection
//                }
//            )
//            Spacer(modifier = Modifier.width(8.dp))
//            Text(text = "Semester")
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        // Radio Button for "Event"
//        Row(verticalAlignment = Alignment.CenterVertically) {
//            RadioButton(
//                selected = selectedChatroomType == "Event",
//                onClick = {
//                    selectedChatroomType = "Event"
//                    onOptionSelected("Event") // Notify the parent composable of the selection
//                }
//            )
//            Spacer(modifier = Modifier.width(8.dp))
//            Text(text = "Event")
//        }
//    }
//}



//@Composable
//fun ChatRoomTypeDropDown(){
//    var expanded by remember { mutableStateOf(false) }
//    var selectedText by remember { mutableStateOf("Select") }
//
//    Box(modifier= Modifier.padding(8.dp)) //maybe not needed
//    {
////        OutlinedTextField("Chatroom Type", selectedText, onValueChange = {selectedText = it; expanded = !expanded })
//        OutlinedTextField(value = selectedText, onValueChange = { selectedText = it; expanded = !expanded }, label = { Text("Chatroom Type") }) {
//            Text(text = selectedText)
//        }
//        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
//        }
//    }
//
//
//    }


//@Composable
//fun ChatroomTypeDropdown(
//    onOptionSelected: (String) -> Unit
//) {
//    var expanded by remember { mutableStateOf(false) }
//    var selectedText by remember { mutableStateOf("Select") }  // This will hold the selected option
//
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//    ) {
//        OutlinedTextField(
//            value = selectedText,  // Use the selectedText here so it updates
//            onValueChange = {},  // No need to update since it's read-only
//            label = { Text("Chatroom Type") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .clickable { expanded = !expanded }, // Clicking the TextField will expand the dropdown
//            readOnly = true, // Make it read-only
//            trailingIcon = {
//                // Show the dropdown arrow icon on the right
//                val icon = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown
//                Icon(icon, contentDescription = "Dropdown Icon")
//            }
//        )
//
//        // Dropdown Menu with options
//        DropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false } // Close menu when clicked outside
//        ) {
//            DropdownMenuItem(
//                text = { Text("Semester") },
//                onClick = {
//                    selectedText = "Semester"  // Update selected text
//                    onOptionSelected("Semester") // Call the callback to update the selected value
//                    expanded = false // Close the menu
//                }
//            )
//
//            DropdownMenuItem(
//                text = { Text("Event") },
//                onClick = {
//                    selectedText = "Event"  // Update selected text
//                    onOptionSelected("Event") // Call the callback to update the selected value
//                    expanded = false // Close the menu
//                }
//            )
//        }
//    }
//}
