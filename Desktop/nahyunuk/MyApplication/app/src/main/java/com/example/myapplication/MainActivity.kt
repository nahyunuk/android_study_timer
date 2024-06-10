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
    fun main(){
        setContentView(R.layout.activity_main)
        val bt_mt =findViewById<Button>(R.id.bt_mt)
        val bt_kor =findViewById<Button>(R.id.bt_kor)
        val bt_eng =findViewById<Button>(R.id.bt_eng)
        val bt_pro =findViewById<Button>(R.id.bt_pro)
        var isRunning = false
        var tv = findViewById<TextView>(R.id.tv_mt_time)
        var mt_sec:Int =0
        var mt_min:Int = 0
        var mt_hr:Int = 0
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
                        tv.text = String.format("%02d:%02d:%02d", mt_hr, mt_min, mt_sec)
                    }
                }
            }
            else{
                mTimer.cancel()
            }
        }

    }






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       main()

        }
}
