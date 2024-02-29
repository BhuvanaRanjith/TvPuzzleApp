package com.bhuvana.tvpuzzleapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface PuzzleDao {
    @Query("SELECT * FROM puzzleentity ORDER BY RANDOM() LIMIT 1 ")
    suspend fun getRandomPuzzle():PuzzleEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertpuzzle(puzzleEntity: PuzzleEntity):Long
}



