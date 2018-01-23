package com.yao.chapter1.function

import java.util.*
import kotlin.collections.ArrayList

/**
 * Functions in Kotlin are declared using the fun keyword:
 */
fun main(args: Array<String>) {
    println("sum(1, 2) =${sum(1, 2)}")
    println("sum2(1, 2) =${sum2(1, 2)}")
    prinfSum(2, 3)
    printSum(3, 4)
    B().foo(2)
    /**
     * Named Arguments
     */
    reformat("hello")
    reformat("hello", false)
    reformat("hello", wordSeparator = '*')
    reformat("hello", divideByCamelHumps = false, wordSeparator = '&')
    /**
     *
     */
    foo()
    foo("a", "b", "c", "d")
    foo(strings = *arrayOf("a", "b", "c", "d"))

    printHello(null)
    printHello("kotlin")

    println(double(1.0, 5F))
    println(int(1, 5))

    val list = asList(1, 2, 3, "hello")//居然ok，泛型没毛用
    println(list)

    val a = arrayOf(1, 2, 3)
    val list1 = asList("+1", -1, 0, *a, 4)//伸展（spread）操作符（在数组前面加 *）
    println(list1)

    println(asList(null))
    println(asList(""))

    println(2 sh1 2)
    println(6.sh1(6))

    val list2 = mutableListOf(1, 2, 3, 4)
    list2.swap(0, 2)
    println(list2)
    var list3 = mutableListOf(1, "hello", 2, "world")
    list3.swap2(2, 1)
    println(list3)

    functionSay()
    a()
    b("火车票")
    b.invoke("12306")
    c(1, 2)

    println(compare(1, numberB = 2))
}

/**
 * Function having two Int parameters with Int return type:
 */
fun sum(a: Int, b: Int): Int {
    return a + b
}

/**
 * Function with an expression body and inferred return type:
 */
fun sum2(a: Int, b: Int) = a + b

/**
 * Function returning no meaningful value:
 */
fun prinfSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

/**
 * Unit return type can be omitted:
 */
fun printSum(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

fun foo(vararg strings: String) {
    println("strings: $strings ${Arrays.toString(strings)}")
}

fun reformat(str: String,
             normalizeCase: Boolean = true,
             upperCaseFirstLetter: Boolean = true,
             divideByCamelHumps: Boolean = false,
             wordSeparator: Char = '_') {
    println("$str $normalizeCase $upperCaseFirstLetter $divideByCamelHumps $wordSeparator")
}

/**
 * Unit-returning functions
 */
fun printHello(str: String?): Unit {
    if (str == null) {
        println("Hi there!")
    } else {
        println("Hello $str")
    }
    // `return Unit` or `return` is optional
    return Unit
}

fun printHi(str: String?) {
    if (str == null) {
        println("hello world")
    } else {
        println(str)
    }
    // `return Unit` or `return` is optional
}

/**
 *Single-Expression functions
 */
fun double(x: Double, y: Float): Double = x * y

fun int(x: Int, y: Int) = x * y

fun <T> asList(vararg ts: T): List<T> {
//    val result = ArrayList<T>()
    val r = ArrayList<T>()
    r += ts
    return r
}

/**
 * Infix notation
 */
infix fun Int.sh1(x: Int): Int {
    return this * x
}

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

fun <T> MutableList<T>.swap2(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

/**
 * Local Functions
 */
fun functionSay() {
    val str = "hello world"
    fun say(count: Int = 10) {
        println("$count: $str ")
        if (count > 0) {
            say(count - 1)
        }
    }
    say()
}

/**
 * kotlin的闭包 todo
 */
var a = { println("这是个啥") }

var b = { word: String -> println("$word 又是个啥") }

var c = { x: Int, y: Int -> println("$x plus $y is ${x + y}") }

fun max(numbers: Array<Int>, s: (Array<Int>) -> Int): Int {
    return s.invoke(numbers)
}

/**
 * 嵌套函数demo
 *
 * 比较数字numberA和数字numberB的二次幂谁大
 */
fun compare(numberA: Int, numberB: Int): Int {
    // 嵌套函数，求一个数字的二次幂
    fun power(num: Int): Int {
        return num * num
    }

    val powerB = power(numberB)

    return if (numberA > powerB) {
        numberA
    } else {
        powerB
    }
}
