package com.yao.chapter1.function

class B : A() {

    override fun foo(i: Int) {
        super.foo(i)
        printSum(i, i)
    }
}