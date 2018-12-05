package com.spreys.contactmanager.helpers

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.util.Base64
import java.io.ByteArrayOutputStream

class BitmapToBase64Converter {

    fun bitmapToString(bitmap: Bitmap): String {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
        val b = baos.toByteArray()
        return Base64.encodeToString(b, Base64.DEFAULT)
    }


    fun stringToBitmap(encodedString: String): Bitmap? {
        val encodeByte = Base64.decode(encodedString, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
    }

    fun resizeBitmap(bitmap: Bitmap): Bitmap {
        val preferredWith = 250f
        val preferredHeight = 250f

        val width = bitmap.width
        val height = bitmap.height

        val scaleWidth = preferredWith / width
        val scaleHeight = preferredHeight / height

        val matrix = Matrix()
        matrix.postScale(scaleWidth, scaleHeight)

        val resizedBitmap = Bitmap.createBitmap(
                bitmap, 0, 0, width, height, matrix, false)

        bitmap.recycle()
        return resizedBitmap
    }
}