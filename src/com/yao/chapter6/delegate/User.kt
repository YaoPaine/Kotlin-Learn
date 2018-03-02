package com.yao.chapter6.delegate

import kotlin.properties.Delegates

class User constructor(map: Map<String,Any>) {

    val shortName:String by map
    val age:Int by map

    var name:String by Delegates.observable("<no name>"){
        prop,old,new-> println("$old->$new")
    }

}

class MutableUser(map:MutableMap<String,Any>){
    var name:String by map
    var age:Int by map

    var shortName:String by Delegates.vetoable("<no name>"){
        property, oldValue, newValue ->
        println("$oldValue->$newValue")
        return@vetoable false//true 表示newValue 有效，否则一直是oldValue
    }

    val lazyValue:String by lazy{
        foo()
        "hello"
    }

    fun foo(){
        println("*************")
        println(this)
        println("foo")
    }
}


fun main(args: Array<String>) {
    val user=User(mapOf("shortName" to "混世魔王","age" to 18,"name" to "程咬金"))

    user.name="first"
    user.name="last"

    println(user.name)
    println(user.age)
    println(user.shortName)
    println("*****************")
    val mutableUser=MutableUser(mutableMapOf("shortName" to "混世魔王","age" to 18,"name" to "程咬金"))
    println(mutableUser.name)
    println(mutableUser.age)

    println(mutableUser.shortName)
    mutableUser.shortName="hello"
    println(mutableUser.shortName)
    mutableUser.shortName="world"
    println(mutableUser.shortName)

    println(mutableUser.lazyValue)

//    println(mutableUser.lazyValue)
}