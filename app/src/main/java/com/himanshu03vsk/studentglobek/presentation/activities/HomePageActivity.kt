package com.himanshu03vsk.studentglobek.presentation.activities


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.himanshu03vsk.studentglobek.ui.theme.StudentGlobeKTheme

class HomePageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        if (user == null || !isUserValid(user)) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

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

    private fun isUserValid(user: FirebaseUser): Boolean {
        return try {
            // Try to reload the user, if the user has been deleted or is invalid, it will throw an exception
            user.reload()
            true
        } catch (e: FirebaseAuthInvalidUserException) {
            // If the user is invalid or deleted, return false
            false
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
                val intent = Intent(this@HomePageActivity, LandingActivity::class.java)
                this@HomePageActivity.startActivity(intent)
            }) {
                Text("Landing Page")
            }

            Button(onClick = {
                // Navigate to Create Chatroom Activity
                val intent = Intent(this@HomePageActivity, CreateChatroomActivity::class.java)
                this@HomePageActivity.startActivity(intent)
            }) {
                Text("Create Chatroom")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                // Navigate to Create Event Activity
                val intent = Intent(this@HomePageActivity, CreateEventActivity::class.java)
                this@HomePageActivity.startActivity(intent)
            }) {
                Text("Create Event")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                // Navigate to User Profile Activity (or any other activity)
                val intent = Intent(this@HomePageActivity, EditProfileActivity::class.java)
                this@HomePageActivity.startActivity(intent)
            }) {
                Text("User Profile")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                // Navigate to User Profile Activity (or any other activity)
                val intent = Intent(this@HomePageActivity, HomePageActivity::class.java)
                this@HomePageActivity.startActivity(intent)
            }) {
                Text("Home Page")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                // Navigate to Chatroom Activity
                val intent = Intent(this@HomePageActivity, ChatroomActivity::class.java)
                this@HomePageActivity.startActivity(intent)
            }) {
                Text("Chatroom")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                // Navigate to Event Activity
                val intent = Intent(this@HomePageActivity, EventActivity::class.java)
                this@HomePageActivity.startActivity(intent)
            }) {
                Text("Event")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                // Navigate to Login Activity
                val intent = Intent(this@HomePageActivity, LoginActivity::class.java)
                this@HomePageActivity.startActivity(intent)
            }) {
                Text("Login")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                // Navigate to Search Peers Activity
                val intent = Intent(this@HomePageActivity, SearchPeersActivity::class.java)
                this@HomePageActivity.startActivity(intent)
            }) {
                Text("Search Peers")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                // Navigate to Sign Up Activity
                val intent = Intent(this@HomePageActivity, SignUpActivity::class.java)
                this@HomePageActivity.startActivity(intent)
            }) {
                Text("Sign Up")
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                // Navigate to Verify Account Activity
                val intent = Intent(this@HomePageActivity, VerifyAccountActivity::class.java)
                this@HomePageActivity.startActivity(intent)
            }) {
                Text("Verify Account")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                // Navigate to View Chatrooms Activity
                val intent = Intent(this@HomePageActivity, ViewChatroomsActivity::class.java)
                this@HomePageActivity.startActivity(intent)
            }) {
                Text("View Chatrooms")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                // Navigate to View Events Activity
                val intent = Intent(this@HomePageActivity, ViewEventsActivity::class.java)
                this@HomePageActivity.startActivity(intent)
            }) {
                Text("View Events")
            }
        }
    }
}
