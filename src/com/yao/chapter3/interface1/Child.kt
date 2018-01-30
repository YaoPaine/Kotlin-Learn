package com.yao.chapter3.interface1

class Child : MyInterface {
    override val prop: Int
        get() = 100
    override var prop2: Double = 1.0

    override fun foo() {
        println(prop2)
    }
}