package com.example.comprasapp.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.comprasapp.data.ShoppingItem

@Composable
fun ShoppingItemRow(
    item: ShoppingItem,
    onItemCheckedChange: (ShoppingItem) -> Unit,
    onDelete: (ShoppingItem) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = item.isBought,
            onCheckedChange = { isChecked ->
                onItemCheckedChange(item.copy(isBought = isChecked))
            }
        )
        Text(
            text = item.name,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        )
        IconButton(onClick = { onDelete(item) }) {
            Icon(Icons.Default.Delete, contentDescription = "Eliminar")
        }
    }
}
