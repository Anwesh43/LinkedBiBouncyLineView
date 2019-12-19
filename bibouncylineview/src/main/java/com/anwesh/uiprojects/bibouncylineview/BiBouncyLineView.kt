package com.anwesh.uiprojects.bibouncylineview

/**
 * Created by anweshmishra on 19/12/19.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color

val nodes : Int = 5
val lines : Int = 2
val scGap : Float = 0.02f
val strokeFactor : Int = 90
val sizeFactor : Float = 3f
val foreColor : Int = Color.parseColor("#283593")
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 30

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawBiBouncyLine(size : Float, scale : Float, gap : Float, paint : Paint) {
    val sf : Float = scale.sinify()
    for (j in 0..(lines - 1)) {
        val scf : Float = sf.divideScale(j, lines)
        save()
        translate(gap - (j + 1) * size, 0f)
        rotate(-90f * scf)
        drawLine(0f, 0f, 0f, -size, paint)
        restore()
    }
}

fun Canvas.drawBBLNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = w / (nodes + 1)
    val size : Float = gap / sizeFactor
    paint.color = foreColor
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    save()
    translate(gap * (i + 1), h / 2)
    drawBiBouncyLine(size, scale, gap, paint)
    restore()
}

