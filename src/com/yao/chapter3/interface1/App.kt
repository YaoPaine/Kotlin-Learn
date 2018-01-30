package com.yao.chapter3.interface1

fun main(args: Array<String>) {
    var child = Child()
    child.bar()
    child.foo()
    println("**********")
    val d = D()
    d.foo()
    d.bar()
    d.two()
}