package com.yao.chapter7

fun main(args: Array<String>) {
    val nullableList: List<Int?> = listOf(1, 2, null, 4)
    val intList: List<Int> = nullableList.filterNotNull()
    println(nullableList)
    println(intList)

    val a: String? = null;

    println(a?.length)
    println(a!!.length)//会抛出NPE

}