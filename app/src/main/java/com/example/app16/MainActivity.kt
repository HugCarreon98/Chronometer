package com.example.app16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView

class MainActivity : AppCompatActivity() {

     private var mHandler: Handler? = null
    //val updateHandler = Handler()
    private var timeInSeconds = 0L
    private var starButtonClicked = true

    private var mInterval = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startTime()
    }


    private fun startTime() {
        mHandler = Handler(Looper.getMainLooper())
        chronometer.run()
    }

    private var chronometer: Runnable = object : Runnable{
        override fun run() {
            try{
                timeInSeconds++
                updateStopWatchView()
            }finally {
                mHandler!!.postDelayed(this,mInterval.toLong())
            }
        }

    }

    private fun updateStopWatchView() {

        var timedata: TextView = findViewById(R.id.clockTextView)
        timedata.text = timeInSeconds.toString()
        //clock.text = timeInSeconds.toString()
    }
/*
    private fun manageRun() {
        if (!starButtonClicked){
            starButtonClicked = true

            //updateHandler.postDelayed(runnable, 5000)
            starTime()
        }else{
            starButtonClicked = false
            stopTime()
        }
    }

 */
}