package com.yao.chapter3

/**
 * 在 Kotlin 中的一个类可以有一个主构造函数和一个或多个次构造函数。
 * 主构造函数是类头的一部分：它跟在类名（和可选的类型参数）后。
 */
class Person constructor(name: String, age: Int) {

    var children: Person? = null
    var parent: Person? = null

    constructor(name: String, age: Int, parent: Person) : this(name, age) {
        parent.children?.add(this)
    }

    fun add(children: Person) {
        this.children = children
    }
}