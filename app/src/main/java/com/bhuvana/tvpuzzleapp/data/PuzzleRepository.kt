package com.bhuvana.tvpuzzleapp.data

import androidx.lifecycle.LiveData

class PuzzleRepository(val puzzleDao:PuzzleDao) {


    suspend fun getRandomPuzzle():PuzzleEntity  {
         return puzzleDao.getRandomPuzzle()
    }
    suspend fun insertpuzzle()
    {

        puzzleDao.insertpuzzle(puzzleEntity)

    }


}