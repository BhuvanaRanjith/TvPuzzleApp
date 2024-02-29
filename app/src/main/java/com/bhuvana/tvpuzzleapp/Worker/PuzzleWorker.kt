package com.bhuvana.tvpuzzleapp.Worker

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.tv.material3.Text
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.bhuvana.tvpuzzleapp.R
import com.bhuvana.tvpuzzleapp.data.PuzzleDatabase
import com.bhuvana.tvpuzzleapp.data.PuzzleRepository
import com.bhuvana.tvpuzzleapp.model.PuzzleViewModel
import kotlinx.coroutines.runBlocking

class PuzzleWorker(context:Context, params:WorkerParameters): Worker(context,params) {
    @SuppressLint("WrongThread")

    override fun doWork(): Result {
        try {
            val puzzleDao = PuzzleDatabase.getDatabase(applicationContext).puzzledao()
            val puzzles = runBlocking { puzzleDao.getRandomPuzzle() }

            Handler(Looper.getMainLooper()).post {
                showToast("Puzzle: ${puzzles.question}")
            }


            return Result.success()
        } catch (e: Exception) {
            return Result.failure()
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
    }



