package com.qoffee.kotlin_inroi_home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mButton: Button = findViewById(R.id.main_button)
        val mText: TextView = findViewById(R.id.main_text)
        var mCountClick = 0

        mButton.setOnClickListener({mText.setText("Click - " + ++mCountClick)})

    }
}
