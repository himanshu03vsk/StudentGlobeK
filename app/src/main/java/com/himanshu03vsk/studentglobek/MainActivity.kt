package com.himanshu03vsk.studentglobek



import com.himanshu03vsk.studentglobek.presentation.activities.*
import android.content.Intent
import android.graphics.Paint.Join
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import com.himanshu03vsk.studentglobek.ui.theme.StudentGlobeKTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudentGlobeKTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }


    // Main screen with 3 buttons
    @Composable
    fun MainScreen(modifier: Modifier = Modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp), // Adjust spacing between items
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()) // Make the column scrollable
        ) {
            Button(onClick = {
                // Navigate to Landing Activity
                val intent = Intent(this@MainActivity, LandingActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("Landing Page")
            }

            Button(onClick = {
                // Navigate to Create Chatroom Activity
                val intent = Intent(this@MainActivity, CreateChatroomActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("Create Chatroom")
            }

            Button(onClick = {
                // Navigate to Create Event Activity
                val intent = Intent(this@MainActivity, CreateEventActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("Create Event")
            }

            Button(onClick = {
                // Navigate to Joined Chatroom Activity
                val intent = Intent(this@MainActivity, JoinedChatroomsActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("Joined Chatrooms")
            }

            Button(onClick = {
                // Navigate to User Profile Activity
                val intent = Intent(this@MainActivity, EditProfileActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("User Profile")
            }

            Button(onClick = {
                // Navigate to Home Page Activity
                val intent = Intent(this@MainActivity, HomePageActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("Home Page")
            }

            Button(onClick = {
                // Navigate to Chatroom Activity
                val intent = Intent(this@MainActivity, ChatroomActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("Chatroom")
            }

            Button(onClick = {
                // Navigate to Event Activity
                val intent = Intent(this@MainActivity, EventActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("Event")
            }

            Button(onClick = {
                // Navigate to Login Activity
                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("Login")
            }

            Button(onClick = {
                // Navigate to Search Peers Activity
                val intent = Intent(this@MainActivity, SearchPeersActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("Search Peers")
            }

            Button(onClick = {
                // Navigate to Sign Up Activity
                val intent = Intent(this@MainActivity, SignUpActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("Sign Up")
            }

            Button(onClick = {
                // Navigate to Verify Account Activity
                val intent = Intent(this@MainActivity, VerifyAccountActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("Verify Account")
            }

            Button(onClick = {
                // Navigate to View Chatrooms Activity
                val intent = Intent(this@MainActivity, ViewChatroomsActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("View Chatrooms")
            }

            Button(onClick = {
                // Navigate to View Events Activity
                val intent = Intent(this@MainActivity, ViewEventsActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("View Events")
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
