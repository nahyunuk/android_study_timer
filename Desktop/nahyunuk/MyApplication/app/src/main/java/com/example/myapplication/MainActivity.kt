package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer
import kotlin.concurrent.timer
import android.graphics.Color

class MainActivity : AppCompatActivity() {
    private lateinit var mTimer: Timer
    private var totalSeconds = 0

    private var t_mt_sec = 0
    private var t_kor_sec = 0
    private var t_eng_sec = 0
    private var t_pro_sec = 0

    private fun startTimer(updateTime: () -> Unit) {
        mTimer = timer(period = 1000) {
            updateTime()
            runOnUiThread {
                updateTotalTime()
            }
        }
    }

    private fun stopTimer() {
        if (::mTimer.isInitialized) {
            mTimer.cancel()
        }
    }

    private fun updateTotalTime() {
        totalSeconds = t_mt_sec + t_kor_sec + t_eng_sec + t_pro_sec
        val hr = totalSeconds / 3600
        val min = (totalSeconds % 3600) / 60
        val sec = totalSeconds % 60
        findViewById<TextView>(R.id.tv_all_time).text = String.format("%02d:%02d:%02d", hr, min, sec)
    }

    @SuppressLint("SuspiciousIndentation")
    private fun main() {
        setContentView(R.layout.activity_main)
        val bt_mt = findViewById<Button>(R.id.bt_mt)
        val bt_kor = findViewById<Button>(R.id.bt_kor)
        val bt_eng = findViewById<Button>(R.id.bt_eng)
        val bt_pro = findViewById<Button>(R.id.bt_pro)

        var isRunning = false

        bt_mt.setOnClickListener {
            isRunning = !isRunning
            if (isRunning) {
                stopTimer()
                bt_mt.setBackgroundColor(Color.RED)
                bt_kor.setBackgroundColor(Color.GREEN)
                bt_eng.setBackgroundColor(Color.GREEN)
                bt_pro.setBackgroundColor(Color.GREEN)
                startTimer {
                    t_mt_sec++
                    val hr = t_mt_sec / 3600
                    val min = (t_mt_sec % 3600) / 60
                    val sec = t_mt_sec % 60
                    findViewById<TextView>(R.id.tv_mt_time).text = String.format("%02d:%02d:%02d", hr, min, sec)
                }
            } else {
                bt_mt.setBackgroundColor(Color.GREEN)
                stopTimer()
            }
        }

        bt_kor.setOnClickListener {
            isRunning = !isRunning
            if (isRunning) {
                stopTimer()
                bt_mt.setBackgroundColor(Color.GREEN)
                bt_kor.setBackgroundColor(Color.RED)
                bt_eng.setBackgroundColor(Color.GREEN)
                bt_pro.setBackgroundColor(Color.GREEN)
                startTimer {
                    t_kor_sec++
                    val hr = t_kor_sec / 3600
                    val min = (t_kor_sec % 3600) / 60
                    val sec = t_kor_sec % 60
                    findViewById<TextView>(R.id.tv_kor_time).text = String.format("%02d:%02d:%02d", hr, min, sec)
                }
            } else {
                bt_kor.setBackgroundColor(Color.GREEN)
                stopTimer()
            }
        }

        bt_eng.setOnClickListener {
            isRunning = !isRunning
            if (isRunning) {
                stopTimer()
                bt_mt.setBackgroundColor(Color.GREEN)
                bt_kor.setBackgroundColor(Color.GREEN)
                bt_eng.setBackgroundColor(Color.RED)
                bt_pro.setBackgroundColor(Color.GREEN)
                startTimer {
                    t_eng_sec++
                    val hr = t_eng_sec / 3600
                    val min = (t_eng_sec % 3600) / 60
                    val sec = t_eng_sec % 60
                    findViewById<TextView>(R.id.tv_eng_time).text = String.format("%02d:%02d:%02d", hr, min, sec)
                }
            } else {
                bt_eng.setBackgroundColor(Color.GREEN)
                stopTimer()
            }
        }

        bt_pro.setOnClickListener {
            isRunning = !isRunning
            if (isRunning) {
                stopTimer()
                bt_mt.setBackgroundColor(Color.GREEN)
                bt_kor.setBackgroundColor(Color.GREEN)
                bt_eng.setBackgroundColor(Color.GREEN)
                bt_pro.setBackgroundColor(Color.RED)
                startTimer {
                    t_pro_sec++
                    val hr = t_pro_sec / 3600
                    val min = (t_pro_sec % 3600) / 60
                    val sec = t_pro_sec % 60
                    findViewById<TextView>(R.id.tv_pro_time).text = String.format("%02d:%02d:%02d", hr, min, sec)
                }
            } else {
                bt_pro.setBackgroundColor(Color.GREEN)
                stopTimer()
            }
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        main()
    }
}
