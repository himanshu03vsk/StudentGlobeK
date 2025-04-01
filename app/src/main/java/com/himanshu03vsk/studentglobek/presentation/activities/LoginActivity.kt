package com.himanshu03vsk.studentglobek.presentation.activities


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.himanshu03vsk.studentglobek.ui.theme.StudentGlobeKTheme
import com.himanshu03vsk.studentglobek.presentation.components.TopAppBarComponent




import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import com.himanshu03vsk.studentglobek.R

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginPage()
        }
    }
}


val bangersFontFamily = FontFamily(
    Font(R.font.bangers) // Make sure the font file name matches the one in the res/font folder
)
@Composable
fun LoginPage() {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var placeholderText by remember { mutableStateOf("Your placeholder content goes here.") }

    // The login page layout
    StudentGlobeKTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = MaterialTheme.colorScheme.background
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                    verticalArrangement = Arrangement.Center

            ) {
                TopAppBarComponent("Student Globe")
                Column(
                    modifier = Modifier.fillMaxSize().padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("Let's Get Connected!!", fontSize = 32.sp, fontFamily= bangersFontFamily ,modifier = Modifier.padding(bottom = 24.dp))

                    // Email input field
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        label = { Text("Email(UTA)") }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Password input field
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        visualTransformation = PasswordVisualTransformation(),
                        label = { Text("Password") }
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 8.dp), // Optional, for spacing from the right edge
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = "Forgot Password?",
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.clickable {
                                // Handle reset password click
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
//
//        // Placeholder text (for future content)
//        Text(
//            text = placeholderText,
//            modifier = Modifier.padding(16.dp),
//            fontSize = 18.sp,
//            color = Color.Gray
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))

                    // Login button
                    Button(
                        onClick = { /* Handle login action */ },
                        modifier = Modifier.fillMaxWidth().padding(32.dp)
                    ) {
                        Text("Login")
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StudentGlobeKTheme {
        LoginPage()
    }
}




