package com.himanshu03vsk.studentglobek.presentation.activities


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.himanshu03vsk.studentglobek.presentation.components.TopAppBarComponent
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.himanshu03vsk.studentglobek.ui.theme.StudentGlobeKTheme


class LandingActivity: ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
                StudentGlobeKTheme {
                    // Layout for creating a chatroom
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {

                        TopAppBarComponent("Student Globe")
                        Spacer(modifier = Modifier.height(16.dp))
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    , ) {
                        Button(onClick = {
                            //Login Activity
                            // Navigate to Login Activity
                            val intent = Intent(this@LandingActivity, LoginActivity::class.java)
                            this@LandingActivity.startActivity(intent)
                        }) { Text(text = "Login")}
                        Spacer(modifier = Modifier.height(16.dp))

                        Text(text = "Or")

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(onClick = {
                            //Sign Up Activity
                            // Navigate to Sign Up Activity
                            val intent = Intent(this@LandingActivity, SignUpActivity::class.java)
                            this@LandingActivity.startActivity(intent)
                        }) {Text("Sign Up")}
                        }
                    }
        }
    }
    }

}

