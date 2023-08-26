package com.mohammad.delloittetask.features.splash.presentation

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mohammad.delloittetask.features.splash.presentation.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Timer
import java.util.TimerTask

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySplashBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        initTimer()
    }

    private fun initTimer() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                viewModel.navigateToNextScreen(this@SplashActivity)
            }
        }, 2000L)
    }
}