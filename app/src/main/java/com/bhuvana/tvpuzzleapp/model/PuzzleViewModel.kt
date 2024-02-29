package com.bhuvana.tvpuzzleapp.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhuvana.tvpuzzleapp.data.PuzzleEntity
import com.bhuvana.tvpuzzleapp.data.PuzzleRepository
import kotlinx.coroutines.launch

class PuzzleViewModel(private val puzzleRepository: PuzzleRepository):ViewModel() {


    private val _puzzles = MutableLiveData<PuzzleEntity>()
    val puzzles: LiveData<PuzzleEntity> get() = _puzzles

   var question :String=""
    var answer= mutableStateOf("")

     fun getAllPuzzles() {
       viewModelScope.launch {
           try {
               val newPuzzle = puzzleRepository.getRandomPuzzle()
               _puzzles.postValue(newPuzzle)
               question= newPuzzle.toString()
           } catch (e: Exception) {
               // Handle the exception (e.g., log or show a message)
           }
       }
    }

    suspend fun insertpuzzle()
    {
               puzzleRepository.insertpuzzle()

    }



}