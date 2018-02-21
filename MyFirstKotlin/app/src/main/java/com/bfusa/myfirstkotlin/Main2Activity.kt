package com.bfusa.myfirstkotlin

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    var number: Int = 0
    var handler: Handler = Handler()
    var runnable: Runnable = Runnable {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val intent = intent
        val received: String = intent.getStringExtra("name")

        textView2.text = received

        //10 sec , every 1 sec
        object: CountDownTimer(10000, 1000){
            override fun onFinish() {
                Toast.makeText(applicationContext, "Time's OFF", Toast.LENGTH_LONG).show()
                textView3.text = "Left: 0"
            }

            override fun onTick(millisUntilFinished: Long) {
                textView3.text = "Left: ${millisUntilFinished/1000}"
            }

        }.start()



    }

    fun goBack(view: View){
        val intent = Intent(applicationContext, MainActivity::class.java)

        startActivity(intent)
    }

    fun start(view: View){
        number = 0
        runnable = object: Runnable{
            override fun run() {
                chronometer.text = "Time: " + number
                number++
                chronometer.text = "Time: " + number
                handler.postDelayed(this, 1000)
            }
        }

        handler.post(runnable)
    }

    fun reset(view: View){
        handler.removeCallbacks(runnable)
        number=0

        chronometer.text = "Time: " + number
    }

}
