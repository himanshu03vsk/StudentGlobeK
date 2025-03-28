package com.himanshu03vsk.studentglobek.presentation.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.material3.Text

@Composable
fun LargeInputBox(label: String, value: String, onValueChange: (String) -> Unit) {
    val scrollState = rememberScrollState()

    OutlinedTextField(
        value, onValueChange, Modifier
            .fillMaxWidth()
            .height(200.dp) // Fixed height
            .verticalScroll(scrollState), label = { Text(text = label) },
        // Enables scrolling
        textStyle = MaterialTheme.typography.bodyLarge.copy(MaterialTheme.colorScheme.onPrimary), // Adjusts the font size and style
        maxLines = Int.MAX_VALUE, // Allow unlimited lines
    )
}
