package com.yao.chapter3.interface1

class C : A {
    override fun foo() {

    }

    override fun bar() {
        super.bar()
        println("$javaClass bar()")
    }

    override fun two() {

    }
}