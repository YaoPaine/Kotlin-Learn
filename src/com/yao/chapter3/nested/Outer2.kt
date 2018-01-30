package com.yao.chapter3.nested

class Outer2 {
    private val bar: Int = 2

    //类可以标记为 inner 以便能够访问外部类的成员。内部类会带有一个对外部类的对象的引用：
    inner class Nested {
        fun foo() = bar

    }
}