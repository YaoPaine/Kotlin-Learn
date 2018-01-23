package com.yao.chapter1.function

import com.yao.MyLocak
import sun.misc.GThreadHelper.lock
import java.util.concurrent.locks.Lock

fun main(args: Array<String>) {
    //args.forEach({})
    /*val lambda = { left: Int, right: Int ->
        left + right
    }
    println(lambda)
    println(lambda(1, 2))*/

//    args.forEach({ element -> println(element) })
    /**
     * Kotlin 允许我们把函数的最后一个Lambda表达式参数移除括号外
     */
//    args.forEach() { element -> println(element) }
    /**
     * 如果函数只有这么一个 Lambda 表达式参数，前面那个不就是么，剩下一个小括号也没什么用，干脆也丢掉吧
     */
//    args.forEach { element -> println(element) }
    /**
     * 果传入的这个Lambda表达式只有一个参数，还是比如上面这位 forEach，参数只有一个 element ，
     * 于是我们也可以在调用的时候省略他，并且默认它叫 it
     */
//    args.forEach({ println(it) })
//    args.forEach { println(it) }
    /**
     * 如果这个 Lambda 表达式里面只有一个函数调用，并且这个函数的参数也是这个Lambda表达式的参数
     */
//    args.forEach(::println)
    /*args.forEach forEachBlock@ {
        if ("e," == it) return@forEachBlock
        println(it)
    }*/
    args.forEach forEachBlock@ {
        println("it=$it")
        if (it == "e") return@forEachBlock
        println(it)
    }

    /*args.forEach eachBlock@ {
        println("it=$it")
        if (it == "e") return eachBlock@
        println(it)
    }*/
    println("The end")

    println("**************")

    fun toBeSynchronized() = { true }
    val isDouble = { false }
    println(lock(MyLocak(), toBeSynchronized()))
    println(lock(MyLocak()) {
        printHello("你好吗？")
        return@lock "我很好呀"
    })

    println("********1********")
    val source = listOf(1, 2, 3, 4)
    fun transform() = { i: Int -> "\"$i\"" }
    println(source.map2(transform()))
    val trans = { i: Int -> "i \"$i\"" }
    println(source.map2(trans))

    println(source.map2 { i -> "\"$i\"" })
    /**
     * 如果 lambda 是该调用的唯一参数，则调用中的圆括号可以完全省略
     */
    println(source.map2 { "it \"$it\"" })
    /**
     * 如果函数字面值只有一个参数， 那么它的声明可以省略（连同 ->），其名称是 it。
     */
    println(source.map2 { it * 2.0 })

    /**
     * Lambda 表达式与匿名函数
     */
    myMax("abcde", "abdjhkkjkj", { str1: String, str2: String -> str1.length > str2.length })
}

/**
 * body 拥有函数类型：() -> T
 * Lambda 表达式总是被大括号括着；
 *其参数（如果有的话）在 -> 之前声明（参数类型可以省略）；
 *函数体（如果存在的话）在 -> 后面。
 */
fun <T> lock(lock: Lock, body: () -> T): T {
    lock.lock()
    try {
        return body()
    } finally {
        lock.unlock()
    }
}

fun <T, R> List<T>.map2(transform: (T) -> R): List<R> {
    val result = arrayListOf<R>()
    for (item in this) {
        result.add(transform(item))
    }
    println("map2: $this")
    return result
}

fun myMax(str1: String, str2: String, compare: (String, String) -> Boolean) {
    println(compare(str1, str2))
}

fun compare(str1: String, str2: String): Boolean = str1.length > str2.length

fun <T> max(collection: Collection<T>, less: (T, T) -> Boolean): T? {
    var max: T? = null
    for (item in collection) {
        if (max == null || less(max, item)) max = item
    }
    return max
}