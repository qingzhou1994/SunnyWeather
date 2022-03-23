package com.wang.sunnyweather.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wang.sunnyweather.R
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}