package com.bfusa.landmark

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var landmarkNames = ArrayList<String>()
        landmarkNames.add("Pisa")
        landmarkNames.add("Colosseum")
        landmarkNames.add("Eiffel")
        landmarkNames.add("London Bridge")

        val pisa = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.pisa)
        val colosseum = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.colosseum)
        val eiffel = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.eiffel)
        val londonBridge = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.london_bridge)

        val landmarkImages = ArrayList<Bitmap>()
        landmarkImages.add(pisa)
        landmarkImages.add(colosseum)
        landmarkImages.add(eiffel)
        landmarkImages.add(londonBridge)

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarkNames)

        listView.adapter=arrayAdapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(applicationContext, DetailActivity::class.java)
            intent.putExtra("name", landmarkNames[position])

            val bitmap = landmarkImages[position]
            val chosen = Globals.Chosen
            chosen.chosenImage = bitmap

            startActivity(intent)
        }

    }
}
