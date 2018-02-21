package com.bfusa.myfirstkotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var ok:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun change(view: View) {
        if(ok==false) {
            imageView.setImageResource(R.drawable.pic2)
            ok = true
        }else{
            imageView.setImageResource(R.drawable.pic1)
            ok = false
        }
    }

    fun changeActivity(view: View){
        val intent = Intent(applicationContext, Main2Activity::class.java)
        intent.putExtra("name", editText.text.toString())
        startActivity(intent)
    }
}
