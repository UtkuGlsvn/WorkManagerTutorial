package com.utkuglsvn.workmanagertutorial

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.work.ForegroundInfo
import androidx.work.Worker
import androidx.work.WorkerParameters

class SimpleWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        Log.d("SimpleWorker", "SimpleWorker is start!")
        val serviceIntent = Intent(applicationContext, MyBackgroundService::class.java)
        applicationContext.startService(serviceIntent)
        return Result.success()
    }

    override fun onStopped() {
        Log.d("SimpleWorker", "SimpleWorker is stop")
        super.onStopped()
    }


    override fun getForegroundInfo(): ForegroundInfo {
        Log.d("SimpleWorker", "ForegroundInfo")
        return super.getForegroundInfo()
    }
}
