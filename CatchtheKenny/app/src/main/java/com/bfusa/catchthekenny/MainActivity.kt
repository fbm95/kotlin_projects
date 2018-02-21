package com.bfusa.catchthekenny

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var score: Int = 0
    var imageArray = ArrayList<ImageView>()
    var handler: Handler = Handler()
    var runnable: Runnable = Runnable {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        score = 0

        imageArray = arrayListOf(imageView00, imageView01, imageView02, imageView10, imageView11, imageView12, imageView20, imageView21, imageView22)

        hideImages()

        object:CountDownTimer(10000, 1000){
            override fun onFinish() {
                timeText.text = "Time: 0"
                handler.removeCallbacks(runnable)
                for(image in imageArray){
                    image.visibility = View.INVISIBLE
                }
            }

            override fun onTick(millisUntilFinished: Long) {
                timeText.text = "Time: " + millisUntilFinished/1000
            }

        }.start()

    }

    fun hideImages(){
        runnable = object :Runnable{
            override fun run() {
                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }

                val random = Random()
                val min = 0
                val max = 8
                val index = random.nextInt((max - min) + 1) + min

                imageArray[index].visibility=View.VISIBLE

                handler.postDelayed(runnable, 500)
            }
        }

        handler.post(runnable)
    }

    fun increaseScore(view: View){
        score++
        scoreText.text = "Score: " + score
    }
}
