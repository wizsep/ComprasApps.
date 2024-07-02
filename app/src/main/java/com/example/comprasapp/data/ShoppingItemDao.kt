package com.example.comprasapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.comprasapp.data.ShoppingItem

@Dao
interface ShoppingItemDao {
    @Query("SELECT * FROM shopping_items ORDER BY is_bought ASC")
    fun getAllItems(): LiveData<List<ShoppingItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: ShoppingItem)

    @Delete
    suspend fun deleteItem(item: ShoppingItem)

    @Update
    suspend fun updateItem(item: ShoppingItem)
}
