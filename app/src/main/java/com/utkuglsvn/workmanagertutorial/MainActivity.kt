package com.utkuglsvn.workmanagertutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstWorkManager = OneTimeWorkRequest.Builder(MyFirstWorker::class.java)
            .addTag("firstWorkManager")
            .build()

        val secondWorkRequest = OneTimeWorkRequest.Builder(MySecondWorker::class.java)
            .addTag("secondWorkManager")
            .build()

        val simpleRequest = PeriodicWorkRequestBuilder<SimpleWorker>(15, TimeUnit.MINUTES).build()
        WorkManager.getInstance(this).enqueue(simpleRequest)

        WorkManager.getInstance(this).beginWith(mutableListOf(firstWorkManager,secondWorkRequest)).enqueue()


        val handler = Handler()
        handler.postDelayed({
            // cancel workmanager
            WorkManager.getInstance(this).cancelAllWorkByTag("firstWorkManager")
        }, 30000)
    }
}