package com.yao.chapter4

/**
 * 1、主构造函数需要至少有一个参数；
 */
data class User constructor(var name: String) {
    var age: Int = -1
    var motherLand: String = ""
    
}