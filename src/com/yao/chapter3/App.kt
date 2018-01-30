package com.yao.chapter3

fun main(args: Array<String>) {
    var orderDemo = InitOrderDemo("xiao hui")
    Constructors(1)
    //DontCreateMe()
    CreateMe()
    Customer()

    var propertyDemo = PropertyDemo(1)
    propertyDemo.counter = -1
    println(propertyDemo.counter)
    propertyDemo.counter = 10
    println(propertyDemo.counter)
}