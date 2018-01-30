package com.yao.chapter3.extension

fun main(args: Array<String>) {
    B().foo()

    var mutable = mutableListOf(1, 2, 3)
    mutable.swap(1, 2)
    println(mutable)

    B().foo(1)

    var list = listOf(1, 2, 3)
    println(list.lastIndex)

    MyClass.Companion.foo()

    val c = C()
    c.caller(D())
    println("********")
    c.caller(c)

    println("*********")
    G().caller(E())//父类->子类
    H().caller(E())//子类->子类
    G().caller(F())//父类->父类
    H().caller(F())//子类->父类
}

fun A.foo() {
    println("A.foo()")
}

fun B.foo() {
    println("B.foo()")
}

fun B.foo(i: Int) {
    println("B.foo($i)")
}

fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

/**
 * 由于扩展没有实际的将成员插入类中，因此对扩展属性来说幕后字段是无效的。这就是为什么扩展属性不能有初始化器。
 * 他们的行为只能由显式提供的 getters/setters 定义。
 */
val <T> List<T>.lastIndex: Int
    get() = this.size - 1

//val <T> List<T>.firstIndex = 1 非法

fun MyClass.Companion.foo() {
    println("$javaClass")
}