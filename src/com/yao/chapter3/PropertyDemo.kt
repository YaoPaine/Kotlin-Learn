package com.yao.chapter3

import com.yao.Inject

const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"

class PropertyDemo {

    //var allByDefault: Int?// 错误：需要显式初始化器，隐含默认 getter 和 setter
    var initialized = 1 // 类型 Int、默认 getter 和 setter

    val simple: Int?// 类型 Int、默认 getter、必须在构造函数中初始化
    val inferredType = 1// 类型 Int 、默认 getter

    val isEmpty: Boolean
        get() = this.simple == 0

    //    var empty: Boolean
    //        get() = this.simple == 0 //报错

    var value: String? = null

    var stringRepresentation: String
        get() = this.toString()
        set(value) {
            this.value = value // 解析字符串并赋值给其他属性
        }
    var setterVisibility: String = "abc"
        private set // 此 setter 是私有的并且有默认实现

    var setterWithAnnotation: Any? = null
        @Inject set//如果你需要改变一个访问器的可见性或者对其注解，但是不需要改变默认的实现， 你可以定义访问器而不定义其实现:
    /**
     * 自 Kotlin 1.1 起，如果可以从 getter 推断出属性类型，则可以省略它：
     */
    val emptyIs get() = this.simple == 0
    /**
     * 在 Kotlin 类中不能直接声明字段。然而，当一个属性需要一个幕后字段时，Kotlin 会自动提供。
     * 这个幕后字段可以使用field标识符在访问器中引用：
     */
    var counter = 0
        set(value) {
            if (value > 0) {
                field = value
            }
        }

    private var _table: Map<String, Int>? = null
    val table: Map<String, Int>
        get() {
            if (_table == null) {
                _table = HashMap()
            }
            return _table ?: throw AssertionError("Set to null by another thread")
        }


    constructor(simple: Int) {
        this.simple = simple
    }

    @Deprecated(SUBSYSTEM_DEPRECATED)
    fun foo() {

    }

    lateinit var late: Animal//lateinit不能修饰基本数据类型

    /*var ei: Int = 1
        set(value) {
            field = value * value
        }*/
    var ei: Int = 1
}