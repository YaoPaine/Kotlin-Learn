package com.yao.chapter1.function

/***
 *一段程序代码通常由常量、变量和表达式组成，
 * 然后使用一对花括号“{}”来表示闭合，并包裹着这些代码，由这对花括号包裹着的代码块就是一个闭包.
 * Kotlin语言中有三种闭包形式：全局函数、自嵌套函数、匿名函数体
 */
fun main(args: Array<String>) {
    test
    test2

    printN()
    println("*********************")
    val count = justCount()
    count()  // 输出结果：0
    count()  // 输出结果：1
    count()  // 输出结果：2

    println("**********")
    //test4 运行了没啥效果，奇了怪

    var add10 = add(10)
    println(add10)
    var result = add10(5)
    println(result)
}

val test = if (5 > 3) {
    println("yes")
} else {
    println("no")
}

var test2 = if (5 < 3) {
    println("yes")
} else {
    println("no")
}

var n = 999
fun printN() {
    println(n)
}

/**
 * 闭包就是能够读取其他函数内部变量的函数。
 */
fun f1() {
    var x = 99
}

//var test3 = println(x) 无法读取f1()函数内的变量x
/**
 *闭包可以用在许多地方。
 * 它的最大用处有两个，一个是前面提到的可以读取函数内部的变量，另一个就是让这些变量的值始终保持在内存中
 */
fun justCount(): () -> Unit {
    var count = 0
    return {
        println(count++)
    }
}

var test4 = { x: Int, y: Int ->
    println("${x + y}")
}(1, 3)

fun add(a: Int): (Int) -> Int {
    return { b: Int -> a + b }
}