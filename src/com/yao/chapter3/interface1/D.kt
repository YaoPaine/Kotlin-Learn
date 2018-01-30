package com.yao.chapter3.interface1

class D : A, B {

    override fun foo() {
        super.foo()
        println("$javaClass foo()")
    }

    override fun bar() {
        super<A>.bar()
        super<B>.bar()
        println("$javaClass bar()")
    }

    override fun two() {
        println("$javaClass two()")
    }
}