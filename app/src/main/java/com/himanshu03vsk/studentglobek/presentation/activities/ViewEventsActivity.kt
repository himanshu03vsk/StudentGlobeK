package com.himanshu03vsk.studentglobek.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.himanshu03vsk.studentglobek.presentation.components.EventCard
import com.himanshu03vsk.studentglobek.presentation.viewmodel.SearchEventsViewModel
import com.himanshu03vsk.studentglobek.ui.theme.StudentGlobeKTheme

class ViewEventsActivity : ComponentActivity() {
    private val viewModel: SearchEventsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentGlobeKTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    EventListScreen(viewModel)
                }
            }
        }
    }
}

@Composable
fun EventListScreen(viewModel: SearchEventsViewModel) {
    val events by viewModel.events.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    when {
        isLoading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        error != null -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Error: $error", color = MaterialTheme.colorScheme.error)
            }
        }

        else -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(events) { event ->
                    EventCard(event = event)
                }
            }
        }
    }
}
