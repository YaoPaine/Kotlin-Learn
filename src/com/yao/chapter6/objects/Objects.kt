package com.yao.chapter6.objects

fun main(args: Array<String>) {
    foo()

    val b=object:A(1),B{
        //override val a: Int=15
        override fun foo() {
            println("$javaClass is $a")
        }
    }

    b.foo()

    Manager.foo()
    Manager.foo()

    val a1=MyClass.createClass()
    println(a1.a)

    val d1=MyClass2.Factory.createClass()

    val d2=MyClass2.createClass()
    println("${d1.b} ${d2.b}")

   var a3= MyClass3.create()
    println(a3.a)
}

fun foo(){
    val a=object {
        val x:Int=1
        val y:Double=2.0
    }
    println("a ${a.x} ${a.y}")
}

class C{
    private fun foo1()=object{
        val x:String="x"
    }

    fun foo2()=object {
        val y:String="y"
    }

    fun foo(){
        var x=foo1().x
        //var y=foo2().y 会报错
    }
}

open class A(x:Int){
   open val a:Int=x
}

interface B{
    fun foo()
}

open class D(str:String){
    open val b=str
}

/**
 * kotlin的单例
 */
object Manager{
    fun foo() {
        println(this)
    }
}

class MyClass{
    companion object {
        fun createClass()=A(1)
    }

    /*companion object Factory{
        fun createClass():D=D("hello world")
    }*/
}

class MyClass2{
    companion object Factory{
        fun createClass():D=D("hello world")
    }
}

interface Factory<out T>{
    fun create():T
}

class MyClass3{
    companion object :Factory<A> {
        override fun create(): A {
           return A(100)
        }
    }
}