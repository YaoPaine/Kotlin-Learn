package com.yao.chapter3.`this`

class A {
    inner class B {

        val int: Int = 10

        private fun Int.foo() {
            val a = this@A
            println("a: $a")
            val b = this@B
            println("b: $b")

            val c = this
            println("c: $c")

            val d = this@foo
            println("d: $d")

            val default = lambda@ fun String.() {
                val e = this
                println("e: $e")
            }

            val funlist2 = { s: String ->
                val f = this
                println("f: $f")
            }
        }

        fun foo() {
            int.foo()
        }
    }
}