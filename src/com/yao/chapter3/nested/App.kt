package com.yao.chapter3.nested

import com.yao.chapter3.`this`.A

fun main(args: Array<String>) {
    println(Outer.Nested().foo())
    println("**************")
    println(Outer.Nested().bar())
    println("***************")
    println(Outer2().Nested().foo())
    println("****************")

    var b = A().B()
    b.foo()

}
