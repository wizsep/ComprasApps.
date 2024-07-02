package com.example.comprasapp.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.comprasapp.data.ShoppingDatabase
import com.example.comprasapp.data.ShoppingItem
import kotlinx.coroutines.launch

class ShoppingViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = ShoppingDatabase.getDatabase(application).shoppingItemDao()
    val shoppingItems: LiveData<List<ShoppingItem>> = dao.getAllItems()

    fun addItem(name: String) = viewModelScope.launch {
        dao.insertItem(ShoppingItem(name = name))
    }

    fun updateItem(item: ShoppingItem) = viewModelScope.launch {
        dao.updateItem(item)
    }

    fun deleteItem(item: ShoppingItem) = viewModelScope.launch {
        dao.deleteItem(item)
    }
}
