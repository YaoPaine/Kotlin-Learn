package com.yao.chapter1.function

open class A {
    private var name: String? = null
    open fun foo(i: Int = 10) {
        println("i=$i")
    }
}