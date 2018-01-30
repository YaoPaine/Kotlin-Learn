package com.yao.chapter3.interface1

interface MyInterface {
    /**
     * 你可以在接口中定义属性。在接口中声明的属性要么是抽象的，要么提供访问器的实现。
     * 在接口中声明的属性不能有幕后字段（backing field），因此接口中声明的访问器不能引用它们。
     */

    val prop: Int//抽象的
    var prop2: Double

    val propertyWithImplementation: String get() = "foo"

    fun foo()

    fun bar() {
        // 可选的方法体
        println(prop)
    }

}