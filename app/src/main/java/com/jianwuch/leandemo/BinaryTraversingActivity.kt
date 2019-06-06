package com.jianwuch.leandemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.jianwuch.modle.BinaryTree
import kotlinx.android.synthetic.main.activity_binary_traversing.*

class BinaryTraversingActivity : AppCompatActivity(), View.OnClickListener {
    var tree: BinaryTree? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binary_traversing)

        tree = BinaryTree(1)
        tree?.run {
            insertLeft(2)
            insertRight(5)

            left?.insertLeft(3)
            left?.insertRight(4)

            right?.insertLeft(6)
            right?.insertRight(7)
        }

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        textView3.text = ""
        when (v) {
            button1 -> preOrder(tree)
            button2 -> centerOrder(tree)
            button3 -> afterOrder(tree)
        }
    }

    fun preOrder(tree: BinaryTree?) {
        tree?.run {
            textView3.append("[${tree.data}]")
            preOrder(left)
            preOrder(right)
        }
    }

    fun centerOrder(tree: BinaryTree?) {
        tree?.run {
            centerOrder(left)
            textView3.append("[${tree.data}]")
            centerOrder(right)
        }
    }

    fun afterOrder(tree: BinaryTree?) {
        tree?.run {
            afterOrder(left)
            afterOrder(right)
            textView3.append("[${tree.data}]")
        }
    }

}
