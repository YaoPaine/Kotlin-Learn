package com.yao.chapter6.delegate

class BaseImpl constructor(val x:Int):Base {
    override fun print() {
        println("BaseImpl x is  $x")
    }
}