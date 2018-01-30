package com.yao.chapter3

class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }

    /**
     * 请注意，主构造的参数可以在初始化块中使用。它们也可以在类体内声明的属性初始化器中使用：
     */
    val customKey: String = name.toUpperCase().also(::println)
}