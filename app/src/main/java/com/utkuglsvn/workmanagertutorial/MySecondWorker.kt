package com.utkuglsvn.workmanagertutorial

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.work.ForegroundInfo
import androidx.work.Worker
import androidx.work.WorkerParameters

class MySecondWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        Log.d("MySecondWorker", "MySecondWorker is running !")
        //do something
        return Result.success()
    }

    override fun onStopped() {
        Log.d("MySecondWorker", "MySecondWorker is stop !")
        super.onStopped()
    }

}