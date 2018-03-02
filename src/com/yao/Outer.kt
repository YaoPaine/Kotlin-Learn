package com.yao

import com.yao.chapter3.nested.Outer

class Outer1 {
    private val bar:Int=1

    /**
     * 类可以标记为 inner 以便能够访问外部类的成员。内部类会带有一个对外部类的对象的引用：
     */
    /*inner*/ class Nested1{
        fun foo() = 2
    }
}

class Outer2{
    var bar:Int=1
    /**
     * 类可以标记为 inner 以便能够访问外部类的成员。内部类会带有一个对外部类的对象的引用：
     */
    inner class Nested2{
        fun foo()=bar
    }
}

fun main(args: Array<String>) {
    val demo= Outer1.Nested1().foo()
    println(demo)


}