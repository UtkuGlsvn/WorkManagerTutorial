package com.utkuglsvn.workmanagertutorial

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.work.ForegroundInfo
import androidx.work.Worker
import androidx.work.WorkerParameters


class MyFirstWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        //do something
        Log.d("MyFirstWorker", "MyFirstWorker is running !")
        return Result.success()
    }

    override fun onStopped() {
        Log.d("MyFirstWorker", "MyFirstWorker is stop !")
        super.onStopped()
    }
    
}