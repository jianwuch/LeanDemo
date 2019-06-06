package com.jianwuch.leandemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AlphaAnimation
import kotlinx.android.synthetic.main.activity_anim.*

class AnimActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim)

        button.setOnClickListener {
            val anim = AlphaAnimation(0.0f, 1.0f)
            anim.setDuration(500L)
            textView.startAnimation(anim)
        }

        switch1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                textView.visibility = View.VISIBLE
            } else {
                textView.visibility = View.GONE
            }
        }
    }
}
