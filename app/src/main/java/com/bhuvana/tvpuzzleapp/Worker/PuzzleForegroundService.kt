package com.bhuvana.tvpuzzleapp.Worker

import android.annotation.SuppressLint
import android.app.Notification
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.bhuvana.tvpuzzleapp.R
import java.util.concurrent.TimeUnit

class PuzzleForegroundService: Service() {
    @SuppressLint("ForegroundServiceType")
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val notification = createNotification()
        startForeground(FOREGROUND_SERVICE_ID, notification)
        Log.d("PuzzleForegroundService", "Foreground service started successfully.")
        Toast.makeText(applicationContext, "Foreground service started", Toast.LENGTH_SHORT).show()

        return START_NOT_STICKY
    }

    private fun createNotification(): Notification? {
      return NotificationCompat.Builder(this, CHANNEL_ID)
          .setContentTitle("Foreground Service")
          .setContentText("Your puzzle notification content")
          .setSmallIcon(androidx.core.R.drawable.notification_bg_low)
          .build()
    }


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
    companion object {
        private const val FOREGROUND_SERVICE_ID = 1
        private const val CHANNEL_ID = "YourChannelId"
    }
}