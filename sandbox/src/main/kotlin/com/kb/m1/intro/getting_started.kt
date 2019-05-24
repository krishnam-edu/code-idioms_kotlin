package com.kb.m1.intro

import java.io.FileReader
import java.io.IOException
import java.math.BigDecimal
import java.util.*

fun main(args: Array<String>) {

    experimentMutability()

    experimentStringTemplate()

    experimentConditionalExpression()

    experimentNullHandling()

    experimentWhenStatement()

    experimentTryStatement()

    experimentLoopStatements()


}

private fun experimentMutability() {

    var p = Person()

    println(p.name)
    // p.aadharId = 123
    // val can't be re-assigned

    p.name = "Bala K"

    println(p.name)

}


private fun experimentStringTemplate() {
    var p = Person()

    // use {} for compound variable
    println("Name : ${p.name}")

    // can have multiple variables
    println("Name : ${p.name} , and id ${p.aadharId}")
}

private fun experimentConditionalExpression() {
    var p = Person()

    // if condition can be used as expression. Trinary is not needed
    val msg = if (p.name.equals("Bala")) {
        "Person is Bala"
    } else {
        "Person is not Bala"
    }

    println(msg)
}

private fun experimentNullHandling() {

    val customer = Customer()

    //Compiler - Warning: x is always null
    if (customer.ssn != null) {

    }

    //Compiler - Error
    // customer.ssn = null

    val address = customer.address

    // Compiler - Error: Only safe (?) or non null assserted (!!) calls are allowed on a nullable receiver type of x
    // NPE is avoided
    val length = address?.length

    println(length?.div(2)) // prints null
    println(length.toString()) // prints null

}

private fun experimentWhenStatement() {
    val trader = Trader()

    // when offers more powerful syntax than switch
    val action = when (trader.group) {
        "Debt" -> "Allow"
        "Stock" -> "Reject"
        "MF" -> "Consult"
        else -> "Reject"
    }

    println(action)
}

private fun experimentTryStatement() {

    val j: Int = try {
        Integer.parseInt("123x")
    } catch (e: NumberFormatException) {
        -1
    }

    println("parsed int $j")

    val i: Int = Integer.parseInt("123x")

    println("parsed int $i")

}


private fun experimentLoopStatements() {

    // same as Java
    while (false) {

    }


    // same as Java
    do {

    } while (false)

    // Kotlin, we can set Range of value
    println("-------------range -------------")

    var range = 1..10

    for (i in range) {
        println(i)
    }

    println("-------------step range -------------")
    for (i in range step 2) {
        println(i)
    }

// go backward
    // closed-range - inclusive range
    println("-------------Go backward-------------")
    for (i in 10 downTo 1) {
        println(i)
    }

    //Java - Half close range by default
    println("-------------Get Half Close-------------")
    for (i in 10 until 1) {
        println(i)
    }

    println("-------------List -------------")
    var lt = listOf(1, 2, 4, 67, 65)

    for (i in lt) {
        println(i)
    }

    println("------------- Map-------------")

    var params = TreeMap<String, String>()
    params["name"] = "krishnam"
    params["title"] = "PE"
    params["city"] = "hyd"

    for ((key, value) in params) {
        println("key $key , value $value")
    }

    //-------- Kotlin: can get index in list also
    println("------------- index for list -------------")
    for ((index, value) in lt.withIndex()) {
        println("key $index , value $value")
    }

    // range can be anything as long comparable.. a..z


}

private fun experimentExecptionSupport() {
    //one other thing kotlin simplify - exception

    // no need to catch and rethrow ...but we can do also like java
    var reader = FileReader("file")

    try {
        var reader = FileReader("file")
    } catch (e: IOException) {

    }


}


class Person {
    val aadharId: Int = 123456
    var name: String = "Bala"
}


class Trade {
    var customer: Customer = Customer()
    val trader: Trader = Trader()
    val direction: TradeDirection = TradeDirection.SELL
    val type: String = "Stock"
    val tradeDate: Date = Date(2020, 11, 25)
    val amount: BigDecimal = BigDecimal.TEN
}

class Customer {
    var ssn: String = "123-45-6789"
    var name: String = "Warren Buffett"
    var address: String? = null // or set lateinit

    // Compiler: property must be initialized or be abstract

}

class Trader {
    var traderId: String = "1877JLL1940"
    var name: String = "Jesse Livermore"
    var group: String = "Debt"
}

enum class TradeDirection {
    BUY,
    SELL
}

/*
 ======== Behind the Scene ==========

 * Use fernflower to decomplie - https://github.com/fesh0r/fernflower

 * install java & run the jar
    $sudo apt install openjdk-11-jre-headless
    $java -jar sandbox/lib/fernflower.jar out/production/code-idioms_kotlin/com/kb/m1/intro/MainKt.class  sandbox/decompiled/

    krishnam@ubuntu:~/proj/github/code_idioms/code-idioms_kotlin$ java -cp out/production/code-idioms_kotlin/ com.kb.m1.intro.MainKt

    Exception in thread "main" java.lang.NoClassDefFoundError: kotlin/jvm/internal/Intrinsics
            at com.kb.m1.intro.MainKt.main(hello.kt)
    Caused by: java.lang.ClassNotFoundException: kotlin.jvm.internal.Intrinsics
            at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:583)
            at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
            at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:521)
        ... 1 more

    Why: It is looking for Kotlin runtime (new name is kotlin stdlib jar ). Look decompiled dir for java source code of this class

    $java -cp "out/production/code-idioms_kotlin/:kotlin-java-runtime-lib/kotlin-stdlib.jar" com.kb.m1.intro.MainKt
    Hello, World

 ======= Common Mistakes======

 Main args - Array - not ArrayList

 ================ What I learned ===========

 1. Similar functionality to java
 2. Code is generally simpler


 ===============IDEA Shortcuts =============

 Ctr+Alt+S - open setting

 Shift + F10 - Run Main

 Ctr+Alt+L - format source code

 Alt + Enter - auto complete

 */