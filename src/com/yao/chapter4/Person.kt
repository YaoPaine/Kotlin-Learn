package com.yao.chapter4

/**
 * 如果生成的类需要含有一个无参的构造函数，则所有的属性必须指定默认值。
 */
data class Person(val name: String) {
    var age: Int? = null
}

data class Pepole(
        val name: String,
        val age: Int)

fun main(args: Array<String>) {
    val person1 = Person("John")
    person1.age = 10
    val person2 = Person("John")
    person2.age = 20
    println(person1 == person2)
    println("person1 with age ${person1.age} ,with name ${person1.name}")
    println("person2 with age ${person2.age} ,with name ${person2.name}")
    println("************")
    val jack = Pepole("jack", 2)
    val newJack = jack.copy(age = 1)
    println(jack)
    println(newJack)
    println("*************")
    val (name, age) = newJack
    println("$name,$age years of age")
}