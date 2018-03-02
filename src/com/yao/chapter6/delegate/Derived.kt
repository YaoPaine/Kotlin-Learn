package com.yao.chapter6.delegate

class Derived(base:Base):Base by base {
    /*override fun print() {
        println("hello world")
    }*/
}

fun main(args: Array<String>) {
    val b=BaseImpl(100)
    Derived(b).print()
}