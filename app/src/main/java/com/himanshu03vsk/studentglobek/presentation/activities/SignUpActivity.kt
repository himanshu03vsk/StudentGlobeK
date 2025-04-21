package com.himanshu03vsk.studentglobek.presentation.activities


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.himanshu03vsk.studentglobek.ui.theme.StudentGlobeKTheme

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import com.himanshu03vsk.studentglobek.ui.theme.StudentGlobeKTheme
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.himanshu03vsk.studentglobek.R

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentGlobeKTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background
                ) { innerPadding ->
                    SignUpPage(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}



val bangersFontFamily = FontFamily(
    Font(R.font.bangers)
)

@Composable
fun SignUpPage(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue("")) }
    var gender by remember { mutableStateOf("Male") }
    var dob by remember { mutableStateOf("MM/DD/YYYY") }
    var department by remember { mutableStateOf(TextFieldValue("")) }
    var major by remember { mutableStateOf(TextFieldValue("")) }
    var phno by remember { mutableStateOf(TextFieldValue("")) }
    // The sign-up page layout
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Title Text
        Text(
            text = "Sign up and Hop On!",
            fontFamily = bangersFontFamily,
            fontSize = 32.sp,
            modifier = Modifier.padding(bottom = 24.dp),
            color = Color.White
        )

        // Email input field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Password input field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))


        OutlinedTextField(
            value = department,
            onValueChange = { department = it },
            label = { Text("Department") },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value= major,
            onValueChange = { major = it },
            label = { Text("Major") },
            modifier = Modifier.fillMaxWidth().padding(8.dp))

        Spacer(modifier = Modifier.height(8.dp))


        // Confirm Password input field

        // Gender selection (Male/Female/Other)
//        Text("Gender", style = TextStyle(color = Color.Gray), modifier = Modifier.align(Alignment.Start))
//        Row(modifier = Modifier.padding(8.dp).align(Alignment.Start)) {
//            GenderOption(gender = gender, onGenderSelected = { gender = it })
//        }
        OutlinedTextField(
            value = phno,
            onValueChange = { phno = it },
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Date of Birth
        OutlinedTextField(
            value = dob,
            onValueChange = { dob = it },
            label = { Text("Date of Birth (MM/DD/YYYY)") },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Register Button
        Button(
            onClick = {
                // Handle registration logic here
            },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text("Register")
        }
    }
}

@Composable
fun GenderOption(gender: String, onGenderSelected: (String) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = gender == "Male",
            onClick = { onGenderSelected("Male") }
        )
        Text("Male")

        RadioButton(
            selected = gender == "Female",
            onClick = { onGenderSelected("Female") }
        )
        Text("Female")


    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    StudentGlobeKTheme {
        SignUpPage()
    }
}
