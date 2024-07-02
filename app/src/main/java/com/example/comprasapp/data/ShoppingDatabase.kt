package com.example.comprasapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingDatabase : RoomDatabase() {
    abstract fun shoppingItemDao(): ShoppingItemDao

    companion object {
        @Volatile private var instance: ShoppingDatabase? = null

        fun getDatabase(context: Context): ShoppingDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, ShoppingDatabase::class.java, "shopping_db").build()
    }
}
