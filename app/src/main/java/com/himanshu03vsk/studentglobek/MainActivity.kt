package com.himanshu03vsk.studentglobek



import com.himanshu03vsk.studentglobek.presentation.activities.*
import android.content.Intent
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
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {


            Button(onClick = {
                // Navigate to Create Chatroom Activity
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

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                // Navigate to Create Event Activity
                val intent = Intent(this@MainActivity, CreateEventActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("Create Event")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                // Navigate to User Profile Activity (or any other activity)
                val intent = Intent(this@MainActivity, EditProfileActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("User Profile")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                // Navigate to User Profile Activity (or any other activity)
                val intent = Intent(this@MainActivity, HomePageActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("Home Page")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                // Navigate to Chatroom Activity
                val intent = Intent(this@MainActivity, ChatroomActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("Chatroom")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                // Navigate to Event Activity
                val intent = Intent(this@MainActivity, EventActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("Event")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                // Navigate to Login Activity
                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("Login")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                // Navigate to Search Peers Activity
                val intent = Intent(this@MainActivity, SearchPeersActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("Search Peers")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                // Navigate to Sign Up Activity
                val intent = Intent(this@MainActivity, SignUpActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("Sign Up")
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                // Navigate to Verify Account Activity
                val intent = Intent(this@MainActivity, VerifyAccountActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("Verify Account")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                // Navigate to View Chatrooms Activity
                val intent = Intent(this@MainActivity, ViewChatroomsActivity::class.java)
                this@MainActivity.startActivity(intent)
            }) {
                Text("View Chatrooms")
            }

            Spacer(modifier = Modifier.height(16.dp))

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
