package com.himanshu03vsk.studentglobek.presentation.activities


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.google.firebase.auth.FirebaseAuth
import com.himanshu03vsk.studentglobek.ui.theme.StudentGlobeKTheme
class HomePageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        if (user == null) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        setContent {
            StudentGlobeKTheme {
                // Layout for creating a chatroom
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "This is a Homepage Screen")
                }
            }
        }
    }
}
