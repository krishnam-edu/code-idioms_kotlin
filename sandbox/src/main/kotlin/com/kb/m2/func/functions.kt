@file:JvmName("Function")
package com.kb.m2.func

import com.kb.m1.intro.Customer
import com.kb.m1.intro.TradeDirection
import com.kb.m1.intro.Trader
import java.math.BigDecimal
import java.util.*

/*
Declaring
    fun functionName(nameofParam: paramType): ReturnType - don't need to be part of a class unlike java
    Function expression
*/

fun max(a: Int, b: Int): Int = if (a > b) a else b


/*
 Calling from java
    // class name UtilKt for file Util.kt
    // @JvmName
*/

/*
 default params
    - @JvmOverloads - creates overloaded methods with less param where remaining param will be defaulted in them

 named params
    - makes the call readble
    - if I name one, i should name everyone while calling
    - can't mix named and position params
    - no support in java
*/

fun log1(msg: String, logLevel: Int = 1) {
    println("$msg with level $logLevel")
}


@JvmOverloads fun log2(msg: String, logLevel: Int = 1) {
    println("$msg with level $logLevel")
}

/*
'extend' exiting type
    - c# have this
    - can 'add' functions to classes not owned by you
    - cuts down on use of utility classes - StringUtil ,NumberUtil, DateUtil ...
    - makes code easier to read - it will look like normal method call
*/

fun addB(str: String): String {
    return str+"B"
}

//  this -  is receiver
// name has to be different
fun String.addA(): String {
    return this+"A"
}

fun main(args: Array<String>){

    var res: String = addB("zxv")
    println(res)
    res.addA()

    //infix

    val t1 = Trade()
    val t2 = Trade()
    val t3 = t1.plus(t2)

    val t4 = t1 plus t2

    println(t4.amount)

    val t5 = t1 minus t2

    println(t5.amount)

    val t6 = t1 - t2

    println(t6.amount)

}

/*
one another trick - infix
 - have single param
 infix keyword --no need to put bracket..its like operator
 */

class Trade {
    var customer: Customer = Customer()
    val trader: Trader = Trader()
    val direction: TradeDirection = TradeDirection.SELL
    val type: String = "Stock"
    val tradeDate: Date = Date(2020, 11, 25)
    var amount: BigDecimal = BigDecimal.TEN
}

infix fun Trade.plus(other: Trade): Trade {

    val aggTrade: Trade = Trade()
    aggTrade.amount = this.amount + other.amount
    return aggTrade
}

/*
It leads us to nice thing - Operator Overloading
only predefined list operators - binary , unary operators

it can lead to very confusing code

maybe the perfect usecase ,  if you are building DSL

*/

infix operator fun Trade.minus(other: Trade): Trade {

    val aggTrade: Trade = Trade()
    aggTrade.amount = this.amount - other.amount
    return aggTrade
}


/*

Tail Recursive Functions

--recur can exhast the stack if it is not written carefully

-- kotlin internaly convert recursive to loop
 */

// this call will break for n = 10000 - stackoverflowError
fun fib(n:Int, a:BigDecimal, b:BigDecimal): BigDecimal{
    return if (n ==0) b else fib (n-1, a+b, a)
}

// no issue of stackoverflow
tailrec fun fib2(n:Int, a:BigDecimal, b:BigDecimal): BigDecimal{
    return if (n ==0) b else fib (n-1, a+b, a)
}

/*
------What I learned here ----
much easier to use
do not need classess
can use default and named paramss
can create extension
can create infix functions
support for overloaded operators

member function - java methods of objects

 */