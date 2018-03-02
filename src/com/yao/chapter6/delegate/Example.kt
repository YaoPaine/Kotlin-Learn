package com.yao.chapter6.delegate

import kotlin.reflect.KProperty


class Example {
    var p:String by Delegate()

    val pLazy:Int by lazy { 1 }
}

class Delegate{
    operator fun getValue(thisRef:Any?,property: KProperty<*>):String{
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    /**
     * thisRef:属性的拥有者
     * property:对属性的描述，是KProperty<*> 类型或是它的父类
     * value:属性的值
     */
    operator fun setValue(thisRef: Any?,property: KProperty<*>,value:String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }

}

fun main(args: Array<String>) {
    var example=Example()
    println(example.p)

    example.p="hello world"
    println(example.p)
}