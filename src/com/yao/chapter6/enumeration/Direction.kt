package com.yao.chapter6.enumeration

enum class Direction {
    NORTH,SOUTH,WEST,EAST
}

enum class Color(val rgb:Int){
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

enum class ProtocolState{
    WAITING{
        override fun singal(): ProtocolState {
            return TALKING
        }
    },

    TALKING{
        override fun singal():ProtocolState{
            return WAITING
        }
    };

    abstract fun singal():ProtocolState
}

inline fun <reified T:Enum<T>> printAllValues(){
    println(enumValues<T>().joinToString{it.name})
}

fun main(args: Array<String>) {
    val values= ProtocolState.values()
    val waiting= ProtocolState.valueOf("WAITING")
    println(waiting.ordinal)
    println("${values[0].name} ${values[0].ordinal}")
    println("*********************")
    printAllValues<ProtocolState>()
    printAllValues<Color>()
    printAllValues<Direction>()
}
