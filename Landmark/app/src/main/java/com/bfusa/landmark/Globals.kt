package com.bfusa.landmark

import android.graphics.Bitmap

/**
 * Created by bfusa on 16.10.2017.
 */
class Globals {

    companion object Chosen{
        var chosenImage: Bitmap? = null

        fun returnImage(): Bitmap{
            return chosenImage!!
        }
    }

}