package com.bhuvana.tvpuzzleapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(PuzzleEntity::class), version = 1, exportSchema = false)
abstract class PuzzleDatabase: RoomDatabase() {
    abstract fun puzzledao():PuzzleDao



    companion object{
        @Volatile
        private var Instance: PuzzleDatabase? = null

        fun getDatabase(context: Context): PuzzleDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                val instance=  Room.databaseBuilder(context, PuzzleDatabase::class.java, "shopping_db")
                    .build()
                Instance = instance
                return instance
            }
        }


    }


}