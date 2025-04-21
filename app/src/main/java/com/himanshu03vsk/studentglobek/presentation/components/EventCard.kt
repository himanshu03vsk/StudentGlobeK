package com.himanshu03vsk.studentglobek.presentation.components

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.himanshu03vsk.studentglobek.domain.model.Event
import com.himanshu03vsk.studentglobek.presentation.activities.EventActivity

@Composable
fun EventCard(event: Event) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                val intent = Intent(context, EventActivity::class.java).apply {
                    putExtra("eventId", event.eventId)
                    putExtra("eventName", event.eventName)
                    putExtra("description", event.description)
                    putExtra("startDate", event.startDate)
                    putExtra("endDate", event.endDate)
                    putExtra("department", event.department)
                    putExtra("major", event.major)
                    putExtra("ownerId", event.ownerId)
                }
                context.startActivity(intent)
            },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = event.eventName, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text("Major: ${event.major}")
            Text("Department: ${event.department}")
            Text("Start: ${event.startDate}")
            Text("End: ${event.endDate}")
        }
    }
}
