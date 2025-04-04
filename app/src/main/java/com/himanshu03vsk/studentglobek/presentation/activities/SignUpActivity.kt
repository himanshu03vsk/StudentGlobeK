package com.himanshu03vsk.studentglobek.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.google.firebase.auth.FirebaseAuth
import com.himanshu03vsk.studentglobek.ui.theme.StudentGlobeKTheme
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import android.util.Log
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

        setContent {
            StudentGlobeKTheme {
                SignUpScreen(auth, this)
            }
        }
    }
}

@Composable
fun SignUpScreen(auth: FirebaseAuth, activity: ComponentActivity) {
    var userId by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var major by remember { mutableStateOf("") }
    var department by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value = userId, onValueChange = { userId = it }, label = { Text("User ID") })
        OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email))
        OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Password") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), visualTransformation = PasswordVisualTransformation())
        OutlinedTextField(value = major, onValueChange = { major = it }, label = { Text("Major") })
        OutlinedTextField(value = department, onValueChange = { department = it }, label = { Text("Department") })
        OutlinedTextField(value = phoneNumber, onValueChange = { phoneNumber = it }, label = { Text("Phone Number") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone))

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (validateInput(userId, name, email, password, context)) {
                registerUser(auth, userId, name, email, password, major, department, phoneNumber, context, activity)
            }
        }) {
            Text("Register")
        }
    }
}

private fun validateInput(userId: String, name: String, email: String, password: String, context: Context): Boolean {
    if (userId.isEmpty() || name.isEmpty() || email.isEmpty() || password.isEmpty()) {
        Toast.makeText(context, "Please fill all required fields", Toast.LENGTH_SHORT).show()
        return false
    }
    if (password.length < 6) {
        Toast.makeText(context, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show()
        return false
    }
    return true
}

private fun registerUser(auth: FirebaseAuth, userId: String, name: String, email: String, password: String, major: String, department: String, phoneNumber: String, context: Context, activity: ComponentActivity) {
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener(activity) { task ->
            if (task.isSuccessful) {
                Log.d("Register", "createUserWithEmail:success")
                val user = auth.currentUser
                saveUserData(user?.uid, userId, name, email, major, department, phoneNumber)
                Toast.makeText(context, "Registration successful", Toast.LENGTH_SHORT).show()
                context.startActivity(Intent(context, LoginActivity::class.java))
                activity.finish()
            } else {
                Log.w("Register", "createUserWithEmail:failure", task.exception)
                Toast.makeText(context, "Registration failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
}

private fun saveUserData(firebaseUid: String?, userId: String, name: String, email: String, major: String, department: String, phoneNumber: String) {
    val database = FirebaseDatabase.getInstance().reference
    val user = hashMapOf(
        "userId" to userId,
        "name" to name,
        "email" to email,
        "major" to major,
        "department" to department,
        "phNumber" to phoneNumber
    )
    firebaseUid?.let {
        database.child("users").child(it).setValue(user)
    }
}

