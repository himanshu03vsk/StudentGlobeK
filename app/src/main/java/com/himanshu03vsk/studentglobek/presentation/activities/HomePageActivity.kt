package com.himanshu03vsk.studentglobek.presentation.activities



import android.content.Intent
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import com.google.firebase.auth.*
import com.himanshu03vsk.studentglobek.MainActivity

class HomePageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

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
        try {
            user.reload()
            return true
        }
        catch (e: FirebaseAuthInvalidUserException){
            return false
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
                // Navigate to Create Chatroom Activity
                val intent = Intent(this@HomePageActivity, MainActivity::class.java)
                this@HomePageActivity.startActivity(intent)
            }) {
                Text("Go to Debugging Screen")
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
