package com.bhuvana.tvpuzzleapp.Worker

import android.app.Application
import android.util.Log
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val puzzleWorkRequest = PeriodicWorkRequest.Builder(
            PuzzleWorker::class.java,
            16, TimeUnit.MINUTES
        )
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
            "PuzzleWork",
            ExistingPeriodicWorkPolicy.KEEP,
            puzzleWorkRequest
        )
        Log.d("MyApplication", "PuzzleWorkRequest enqueued successfully.")
    }
}