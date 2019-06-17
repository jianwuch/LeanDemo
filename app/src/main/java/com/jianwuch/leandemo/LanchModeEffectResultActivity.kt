package com.jianwuch.leandemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.jianwuch.leandemo.ext.TestActivity
import kotlinx.android.synthetic.main.activity_lanch_mode_effect_result.*

class LanchModeEffectResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lanch_mode_effect_result)

        textView2.setOnClickListener {
            startActivityForResult(
                Intent(
                    this@LanchModeEffectResultActivity,
                    TestActivity::class.java
                ), 1001
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(this, "取消", Toast.LENGTH_SHORT).show()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
