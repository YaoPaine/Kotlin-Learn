package com.yao.chapter7

fun main(args: Array<String>) {

    foo()
}

fun foo(){
    var i=0
    fun bar(){
        while (i < 10) {
            if (i==5)return
            println("this $i")
            i++
        }
        println("bar()")
    }
    bar()
    println("foo() $i   ")
}