package com.yao.chapter2

import java.util.*

//val a = 1
//var b = 2
/**
 *1、kotlin 声明变量用var
 * 声明常量用val
 *
 * 2、当某个变量的值可以为 null 的时候，必须在声明处的类型后添加 ? 来标识该引用可为空
 *
 * 3、is 运算符检测一个表达式是否某类型的一个实例。
 * 如果一个不可变的局部变量或属性已经判断出为某类型，那么检测后的分支中可以直接当作该类型使用，无需显式转换：
 *
 * 4、  val items = listOf("apple", "banana", "kiwi")
for (item in items) {
println(item)
}
 *
 * 5、创建对象不需要new
 */
fun main(args: Array<String>) {
    //println(a + b)
    // 假想的代码，实际上并不能编译：
//    val a: Int? = 1 // 一个装箱的 Int (java.lang.Integer)
//    val b: Long? = a // 隐式转换产生一个装箱的 Long (java.lang.Long)
//    print(a == b) // 惊！这将输出“false”鉴于 Long 的 equals() 检测其他部分也是 Long

    /*val a: Int = 10000
    println(a == a) // 输出“true”
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    print(boxedA == anotherBoxedA) // 输出“true”*/

    /*val a: Int = 10000
    println(a === a) // 输出“true”
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    print(boxedA === anotherBoxedA) // ！！！输出“false”！！！*/
    val b: Byte = 1 // OK, 字面值是静态检测的
//    val i: Int = b // 错误
    var i: Int = b.toInt()

    //字符
    val c: Char? = null
//    if (c == 1) { // 错误：类型不兼容
//        // ……
//    }

    var value = decimalDigitValue('1')
    println(value)

    var array = Array(5, { i -> i * i })
    println(Arrays.toString(array))
    var asc = Array(5, { it * it })
    println(Arrays.toString(asc))

    val text = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()
    println(text)//默认 | 用作边界前缀，但你可以选择其他字符并作为参数传入，比如 trimMargin(">")。
    val text2 = """
    for (c in "foo")
        print(c)"""
    println(text2)
    var x = 3
    when (x) {
        1 -> println("1")
        2 -> println("1")
        else -> {
            println("x is not 1 or 2")
        }
    }

    when (x) {
        1, 2 -> {
            println("x == 0 or x == 1")
        }
        else -> {
            println("otherwise")
        }
    }
}

fun decimalDigitValue(c: Char): Int? {
    if (c !in '0'..'9') {
        throw IllegalArgumentException("$c is not allowed here")
    }
    println("char:'$c'=" + c.toInt())
    return c.toInt() - '0'.toInt()
}