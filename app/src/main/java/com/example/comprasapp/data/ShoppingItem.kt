package com.example.comprasapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "shopping_items")
data class ShoppingItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "item_name") val name: String,
    @ColumnInfo(name = "is_bought") val isBought: Boolean = false
)
