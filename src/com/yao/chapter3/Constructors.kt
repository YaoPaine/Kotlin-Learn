package com.yao.chapter3

class Constructors constructor() {
    init {
        println("init block")
    }

    constructor(i: Int) : this() {
        println(this.javaClass.name + ": " + i)
    }
}