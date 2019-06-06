package com.jianwuch.modle


/**
 * @author jove.chen
 * @date 2019/6/6
 */
data class BinaryTree(
    var data: Int = 0,
    var left: BinaryTree? = null,
    var right: BinaryTree? = null
) {

    fun insertLeft(value: Int) {
        insertLeft(this, value)
    }

    fun insertRight(value: Int) {
        insertRight(this, value)
    }


    companion object {
        fun insertLeft(node: BinaryTree?, value: Int) {
            if (node != null) {
                if (node.left == null) {
                    node.left = BinaryTree(value)
                } else {
                    val newNode = BinaryTree(value)
                    newNode.left = node.left
                    node.left = newNode
                }
            }
        }

        fun insertRight(node: BinaryTree?, value: Int) {
            if (node != null) {
                if (node.right == null) {
                    node.right = BinaryTree(value)
                } else {
                    val newNode = BinaryTree(value)
                    newNode.right = node.right
                    node.right = newNode
                }
            }
        }
    }
}