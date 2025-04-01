package com.himanshu03vsk.studentglobek.presentation.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.rounded.AccountBox

import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.material3.Text
import com.himanshu03vsk.studentglobek.presentation.activities.ChatRoom


//@Composable
//fun ChatRoomCardSearch(
//    roomTitle: String,
//    roomMembers: String,
//    roomDepartment: String,
//    roomMajor: String,
//    roomType: String
//) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
//    ) {
//
//        Row {
//
//            Column {
//                Text(text = "$roomTitle Chatroom")
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(text = "$roomMembers Members")
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(text = "$roomDepartment Department")
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(text = "$roomMajor Major")
//
//            }
//
//            Spacer(modifier = Modifier.width(16.dp))
//            Icon(
//                Icons.Rounded.AccountBox,
//                contentDescription = "Chatroom Icon"
//            )
//
//        }
//
//    }
//}
//

//@Composable
//fun ChatRoomCardSearch(chatRoom: ChatRoom) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
//        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
//    ) {
//        Row {
//            Column(
//                modifier = Modifier.padding(16.dp).weight(3f)
//            ) {
//                Text(
//                    text = "Room: ${chatRoom.roomTitle}",
//                    color = MaterialTheme.colorScheme.onPrimaryContainer
//                )
//                Text(
//                    text = "Members: ${chatRoom.roomMembers}",
//                    color = MaterialTheme.colorScheme.onPrimaryContainer
//                )
//                Text(
//                    text = "Department: ${chatRoom.roomDepartment}",
//                    color = MaterialTheme.colorScheme.onPrimaryContainer
//                )
//                Text(
//                    text = "Major: ${chatRoom.roomMajor}",
//                    color = MaterialTheme.colorScheme.onPrimaryContainer
//                )
//
//            }
//            Spacer(modifier = Modifier.width(16.dp))
//            Column {
//                Icon(
//                    Icons.Rounded.AccountBox,
//                    contentDescription = "Chatroom Icon",
//                    modifier = Modifier.weight(2f).padding(8.dp)
//                        .size(64.dp),
//                    tint = MaterialTheme.colorScheme.onPrimaryContainer
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//                Button(
//                    onClick = { /* Handle button click */ },
//                    modifier = Modifier.weight(1f).padding(8.dp),
//                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
//                ) {
//                    Text(
//                        text = "Join",
//                        color = MaterialTheme.colorScheme.onPrimaryContainer
//                    )
//                }
//            }
//        }
//    }
//}

@Composable
fun ChatRoomCardSearch(chatRoom: ChatRoom) {
    Card(
        modifier = Modifier
            .fillMaxWidth().height(220.dp)
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Row {
            // Column for room details
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)  // Adjust weight if necessary
            ) {
                Text(
                    text = "Room: ${chatRoom.roomTitle}",
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = "Members: ${chatRoom.roomMembers}",
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = "Department: ${chatRoom.roomDepartment}",
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = "Major: ${chatRoom.roomMajor}",
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            // Spacer to give space between the text and the icon/button
            Spacer(modifier = Modifier.width(16.dp))

            // Column for icon and button
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,  // Center align content in the column
                verticalArrangement = Arrangement.Center  // Vertically center the content in the column
            ) {
                // Icon
                Icon(
                    Icons.Rounded.AccountBox,
                    contentDescription = "Chatroom Icon",
                    modifier = Modifier
                        .size(128.dp)  // Make the icon larger
                        .padding(8.dp).align(Alignment.CenterHorizontally),
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )

                Spacer(modifier = Modifier.height(8.dp)) // Spacer between icon and button

                // Button
                Button(
                    onClick = { /* Handle button click */ },
                    modifier = Modifier
                        .padding(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                ) {
                    Text(
                        text = "Join",
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        }
    }
}
