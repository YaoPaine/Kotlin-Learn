package com.yao.chapter3.nested

class Outer {
    val bar: Int = 1

    class Nested {
        fun foo() = 1

        fun bar() {
            println(javaClass.name)
        }
    }


}