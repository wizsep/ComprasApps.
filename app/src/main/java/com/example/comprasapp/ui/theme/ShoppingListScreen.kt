package com.example.comprasapp.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.comprasapp.viewmodel.ShoppingViewModel

@Composable
fun ShoppingListScreen(viewModel: ShoppingViewModel = viewModel, modifier: Any) {
    val items by viewModel.shoppingItems.observeAsState(emptyList())

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(items) { item ->
                ShoppingItemRow(item, viewModel::updateItem, viewModel::deleteItem)
            }
        }
        AddItemButton { itemName ->
            viewModel.addItem(itemName)
        }
    }
}
