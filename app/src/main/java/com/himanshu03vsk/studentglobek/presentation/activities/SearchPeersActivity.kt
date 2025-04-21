package com.himanshu03vsk.studentglobek.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

import com.himanshu03vsk.studentglobek.domain.model.User
import com.himanshu03vsk.studentglobek.ui.theme.StudentGlobeKTheme

class SearchPeersActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentGlobeKTheme {
                SearchPeersScreen()
            }
        }
    }
}

@Composable
fun SearchPeersScreen(viewModel: SearchPeersViewModel = viewModel()) {
    var searchQuery by remember { mutableStateOf("") }
    val searchResults by viewModel.searchResults.collectAsState()

    LaunchedEffect(Unit) {
            viewModel.getAllUsers()
        }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = {
                searchQuery = it
                if (it.isNotBlank()) {
                    viewModel.searchPeers(it)
                }
            },
            label = { Text("Search Peers by Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (searchQuery.isNotEmpty() && searchResults.isEmpty()) {
            Text("No users found.", style = MaterialTheme.typography.bodyMedium)
        } else {
            LazyColumn {
                items(searchResults) { user ->
                    PeerListItem(user)
                }
            }
        }
    }
}

@Composable
fun PeerListItem(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = user.userName, style = MaterialTheme.typography.titleMedium)
            Text(text = user.name, style = MaterialTheme.typography.bodyMedium)
            Text(text = user.email, style = MaterialTheme.typography.bodySmall)
            Text(text = "Major: ${user.major}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Department: ${user.department}", style = MaterialTheme.typography.bodySmall)
        }
    }
}
