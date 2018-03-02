package com.yao.chapter5

/**
 * 泛型
 */
class Box<out T>(t: T) {
    val value = t

    fun nextT():T{
        return value
    }
}

fun copy(from: Array<out Any>, to: Array<Any>) {
    assert(from.size==to.size)
    for (i in from.indices) {
        to[i]=from[i]
    }
}

fun main(args: Array<String>) {
    val ints= arrayOf(1,2,3)
    val any=Array<Any>(3){""}
    copy(ints,any)
}