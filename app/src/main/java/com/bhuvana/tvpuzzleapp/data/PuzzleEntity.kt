package com.bhuvana.tvpuzzleapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PuzzleEntity(
    @PrimaryKey(autoGenerate = true) val id: Long=0,
        var  question:String,
        var answer:String )

val puzzleEntity = PuzzleEntity(
    question = "what is 4+3",
    answer = "5"
)



