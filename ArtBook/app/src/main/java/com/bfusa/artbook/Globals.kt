package com.bfusa.artbook

import android.graphics.Bitmap

/**
 * Created by bfusa on 18.10.2017.
 */

class Globals{
    companion object Chosen{
        var chosenImage: Bitmap? = null

        fun returnImage():Bitmap{
            return chosenImage!!
        }
    }
}