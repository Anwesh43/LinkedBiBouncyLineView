package com.anwesh.uiprojects.linkedbibouncylineview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.bibouncylineview.BiBouncyLineView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BiBouncyLineView.create(this)
    }
}
