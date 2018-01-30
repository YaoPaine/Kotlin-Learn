package com.yao.chapter2


fun main(args: Array<String>) {
    val ints: List<Int> = listOf(1, 3, 0, 5, 7)
    foo11(ints)
    println("***********")
    foo22(ints)
    println("***********")
    foo33(ints)
    println("***********")
    println(foo(ints))
    println("**************")
    loop@ for (i in 1..10) {
        for (j in 1..10) {
            if (j == 5) break@loop
            println("$i -> $j")
        }
    }
    println("**************")
    for (i in 1..10) {
        for (j in 1..10) {
            if (j == 5) break
            println("$i -> $j")
        }
    }
}

fun foo11(ints: List<Int>) {//直接退出foo11()函数
    ints.forEach {
        if (it == 0) return
        println(it)
    }
    println("foo11")
}

fun foo22(ints: List<Int>) {
    ints.forEach {
        if (it == 0) return@forEach
        println(it)
    }
    println("foo22")
}

/**
 * 这是一种奇葩写法
 */
fun foo33(ints: List<Int>) {
    ints.forEach {
        if (it == 0) return foreach@
        println(it)
    }
    println("foo33")
}

fun foo(ints: List<Int>): List<String> {
    val result = ints.map f@ {
        if (it == 1) return@f "one"
        if (it == 0) return@f emptyList<String>().toString()
        "number $it"
    }
    println("foo")
    return result
}


