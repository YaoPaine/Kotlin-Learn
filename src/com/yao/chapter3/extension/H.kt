package com.yao.chapter3.extension

class H : G() {
    override fun E.foo() {
        println("E.foo in H")
    }

    override fun F.foo() {
        println("F.foo in H")
    }
}