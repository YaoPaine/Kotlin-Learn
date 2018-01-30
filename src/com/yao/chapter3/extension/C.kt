package com.yao.chapter3.extension

class C : D() {

    fun baz() {
        println("baz")
    }

    fun D.foo() {
        bar()
        baz()
    }

    fun caller(d: D) {
        d.foo()
    }
}