package com.example.comprasapp.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddItemButton(onAdd: (String) -> Unit) {
    var text by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Agregar Producto") },
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = {
                if (text.isNotEmpty()) {
                    onAdd(text)
                    text = ""
                }
            },
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text("Agregar")
        }
    }
}
