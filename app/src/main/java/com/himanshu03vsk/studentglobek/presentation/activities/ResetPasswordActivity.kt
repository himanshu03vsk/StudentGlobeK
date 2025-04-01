package com.himanshu03vsk.studentglobek.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.himanshu03vsk.studentglobek.ui.theme.StudentGlobeKTheme
import androidx.compose.ui.text.input.TextFieldValue

class ResetPasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ResetPasswordPage()
        }
    }
}

@Composable
fun ResetPasswordPage() {
    var otp by remember { mutableStateOf(TextFieldValue("")) }
    var newPassword by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue("")) }
    var errorMessage by remember { mutableStateOf("") }

    // Reset password layout
    StudentGlobeKTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = MaterialTheme.colorScheme.background
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Reset Password", fontSize = 32.sp, modifier = Modifier.padding(bottom = 24.dp))
                Spacer(modifier = Modifier.height(8.dp))
                Text("We have sent an OTP to your email. Please enter it below along with your new password")

                // OTP input field
                OutlinedTextField(
                    value = otp,
                    onValueChange = { otp = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    label = { Text("OTP") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { /* Handle next field focus if needed */ }
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // New Password input field
                OutlinedTextField(
                    value = newPassword,
                    onValueChange = { newPassword = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    label = { Text("New Password") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { /* Handle next field focus if needed */ }
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Confirm New Password input field
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    label = { Text("Confirm New Password") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { /* Handle done action */ }
                    )
                )

                // Error message (if passwords don't match)
                if (errorMessage.isNotEmpty()) {
                    Text(
                        text = errorMessage,
                        color = Color.Red,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Reset Password button
                Button(
                    onClick = {
                        if (newPassword.text != confirmPassword.text) {
                            errorMessage = "Passwords do not match!"
                        } else if (otp.text.isEmpty() || newPassword.text.isEmpty()) {
                            errorMessage = "Please fill in all fields."
                        } else {
                            errorMessage = ""
                            // Handle the reset password logic here, e.g., call an API or update the database
                            // For example: resetPassword(otp.text, newPassword.text)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text("Reset Password")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResetPasswordPreview() {
    ResetPasswordPage()
}
