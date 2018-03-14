package com.yao.chapter7

fun main(args: Array<String>) {
    val numbers: MutableList<Int> = mutableListOf(1, 2, 3)

    val readOnly: List<Int> = numbers
    val list = numbers.toList()
    numbers.add(4)

    println(numbers)
    println(readOnly)

    println(list)

}