package com.yao.chapter3.extension

open class G {
    open fun E.foo() {
        println("E.foo in G")
    }

    open fun F.foo() {
        println("F.foo in G")
    }

    fun caller(f: F) {
        f.foo()
    }
}