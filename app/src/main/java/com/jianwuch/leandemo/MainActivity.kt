package com.jianwuch.leandemo

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

val listData = listOf("Anim", "BinaryTraversing", "LanchModeEffectResult")

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        recyclerview.adapter = ListAdapter()
    }


    inner class ListAdapter : RecyclerView.Adapter<ListAdapter.ListVH>() {
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ListVH {
            return ListVH(TextView(p0.context))
        }

        override fun getItemCount() = listData.size

        override fun onBindViewHolder(p0: ListVH, p1: Int) {
            p0.bindData(p1)
        }


        inner class ListVH(view: View) : RecyclerView.ViewHolder(view) {
            var name: TextView = view as TextView

            init {
                name.setTextColor(Color.parseColor("#333333"))
                name.textSize = 24f
            }

            fun bindData(position: Int) {
                name.text = listData[position]

                name.setOnClickListener {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            Class.forName("com.jianwuch.leandemo." + listData[position] + "Activity")
                        )
                    )
                }
            }

        }

    }

}

