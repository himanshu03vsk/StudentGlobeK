package com.himanshu03vsk.studentglobek.presentation.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseUser
import com.himanshu03vsk.studentglobek.R
import com.himanshu03vsk.studentglobek.ui.theme.StudentGlobeKTheme

class HomePageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        if (user != null && isUserValid(user)) {
            startActivity(Intent(this, JoinedChatroomsActivity::class.java))
            finish()
        }

        setContent {
            StudentGlobeKTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    private fun isUserValid(user: FirebaseUser): Boolean {
        try {
            user.reload()
            return true
        } catch (e: FirebaseAuthInvalidUserException) {
            return false
        }
    }

    @Composable
    fun MainScreen(modifier: Modifier = Modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // App Information Section
            Text(
                text = "Welcome to Student Globe K!",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Student Globe K helps you stay connected with peers and join chatrooms and events in your community. Easily create, join, and engage in meaningful discussions with fellow students.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Add Image Section
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "App Illustration",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(bottom = 16.dp)
            )

            // Login and Register Buttons
            Button(
                onClick = {
                    val intent = Intent(this@HomePageActivity, LoginActivity::class.java)
                    startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Login")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val intent = Intent(this@HomePageActivity, SignUpActivity::class.java)
                    startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Register")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        StudentGlobeKTheme {
            MainScreen()
        }
    }
}
