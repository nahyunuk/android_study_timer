package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    lateinit var mTimer : Timer

    fun funTimer(){
        setContentView(R.layout.activity_main)
        var tv = findViewById<TextView>(R.id.tv_all_time)
        var sec:Int =0
        var min:Int = 0
        var hr:Int = 0
        mTimer = timer(period = 1000){
           sec++
            if(sec > 60){
                sec = 0
                min++
            }
            else if(min >60){
                min = 0
                sec++
            }
            runOnUiThread(){
                tv.text=String.format("%02d:%02d:%02d",hr,min,sec)
            }
        }
    }
    fun main() {
        setContentView(R.layout.activity_main)
        val bt_mt = findViewById<Button>(R.id.bt_mt)
        val bt_kor = findViewById<Button>(R.id.bt_kor)
        val bt_eng = findViewById<Button>(R.id.bt_eng)
        val bt_pro = findViewById<Button>(R.id.bt_pro)
        var isRunning = false

        var tv_mt_time = findViewById<TextView>(R.id.tv_mt_time)
        var mt_sec: Int = 0
        var mt_min: Int = 0
        var mt_hr: Int = 0

        var tv_kor_time = findViewById<TextView>(R.id.tv_kor_time)
        var kor_sec: Int = 0
        var kor_min: Int = 0
        var kor_hr: Int = 0

        var tv_eng_time = findViewById<TextView>(R.id.tv_eng_time)
        var eng_sec: Int = 0
        var eng_min: Int = 0
        var eng_hr: Int = 0
        var tv_pro_time = findViewById<TextView>(R.id.tv_pro_time)
        var pro_sec: Int = 0
        var pro_min: Int = 0
        var pro_hr: Int = 0

            bt_mt.setOnClickListener() {
                isRunning = !isRunning
                if (isRunning == true) {
                    mTimer = timer(period = 1000) {
                        mt_sec++
                        if (mt_sec > 60) {
                            mt_sec = 0
                            mt_min++
                        } else if (mt_min > 60) {
                            mt_min = 0
                            mt_hr++
                        }
                        runOnUiThread() {
                            tv_mt_time.text = String.format("%02d:%02d:%02d", mt_hr, mt_min, mt_sec)
                        }
                    }
                } else {
                    mTimer.cancel()
                }
            }
            bt_kor.setOnClickListener() {
                isRunning = !isRunning
                if (isRunning == true) {
                    mTimer = timer(period = 1000) {
                        kor_sec++
                        if (kor_sec > 60) {
                            kor_sec = 0
                            kor_min++
                        } else if (kor_min > 60) {
                            kor_min = 0
                            kor_hr++
                        }
                        runOnUiThread() {
                            tv_kor_time.text =
                                String.format("%02d:%02d:%02d", kor_hr, kor_min, kor_sec)
                        }
                    }
                } else {
                    mTimer.cancel()
                }
            }
            bt_eng.setOnClickListener() {
                isRunning = !isRunning
                if (isRunning == true) {
                    mTimer = timer(period = 1000) {
                        eng_sec++
                        if (eng_sec > 60) {
                            eng_sec = 0
                            eng_min++
                        } else if (eng_min > 60) {
                            eng_min = 0
                            eng_hr++
                        }
                        runOnUiThread() {
                            tv_eng_time.text =
                                String.format("%02d:%02d:%02d", eng_hr, eng_min, eng_sec)
                        }
                    }
                } else {
                    mTimer.cancel()
                }
            }
            bt_pro.setOnClickListener() {
                isRunning = !isRunning
                if (isRunning == true) {
                    mTimer = timer(period = 1000) {
                        pro_sec++
                        if (pro_sec > 60) {
                            pro_sec = 0
                            pro_min++
                        } else if (pro_min > 60) {
                            pro_min = 0
                            pro_hr++
                        }
                        runOnUiThread() {
                            tv_pro_time.text =
                                String.format("%02d:%02d:%02d", pro_hr, pro_min, pro_sec)
                        }
                    }
                } else {
                    mTimer.cancel()
                }
            }
        var tv = findViewById<TextView>(R.id.tv_all_time)
        var sec:Int =0;
        var min:Int = 0
        var hr:Int = 0
        mTimer = timer(period = 1000){
            sec = mt_sec + kor_sec + eng_sec + pro_sec
            min = mt_min + kor_min + eng_min + pro_min
            hr = mt_hr + kor_hr + eng_hr + pro_hr
            if(sec > 60){
                sec %= 60
                min =sec / 60
            }
            else if(min >60){
                min %=60
                hr =min / 60
            }
            runOnUiThread(){
                tv.text=String.format("%02d:%02d:%02d",hr,min,sec)
            }
        }
    }






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       main()

        }
}
