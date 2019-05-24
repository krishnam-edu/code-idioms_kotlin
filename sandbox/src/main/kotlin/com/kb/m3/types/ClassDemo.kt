package com.kb.m3.types


/*
'final' by default - u only want to drive it ---

default - no override, no inheritance ..think why you want to overridden

abstract
modifiers
sealed classes
constructors
data classes
 */

open class Animal {

}

// can't be inherited with out open keyword
// () - calls default constructor
open class Cat : Animal() {
    fun walk() {

    }

    open fun displayName(): String {
        return "x"
    }

}

class WildCat : Cat() {
    /*
    // it is not open
    override fun walk(){

    }
    */

    override fun displayName(): String {
        return super.displayName() + "wild"
    }

}

/*
Visibility
* public
* No 'package-private' ..package is just collecting together ..
not for visibility
* does have 'internal'
 */

/*
SEALED CLASSES

Used to restrict class Hierarchies - it gives very very fine control
'Enums on Steroids'
*/

sealed class AutoMobile {
    class BMW() : AutoMobile()
    class I20() : AutoMobile()

    // AutoMobile can't have anything but I20 and BM
}

// general use of sealed class
fun useSealedClasses(am: AutoMobile) =
        when (am) {
            is AutoMobile.BMW -> println("b")
            is AutoMobile.I20 -> println("i")
        }
// ---------------constructor

/*
Primary constructor on class definition
no New keyword
 */
open class Person1(val name: String)

open class Person3()

// OR

open class Person(name: String) {
    val name: String

    init {
        this.name = name
    }
}

// OR

/*

prefer to set default value for for cons params als o

default construtor is generated



 */

class Worker : Person {
    constructor(name: String) : super(name) {
        //any logic after calling parent
    }
}

//calling superclass construct
class Worker2(name: String) : Person(name)


// call default constr
class Worker3 : Person3()

/* private cons
   - used to inhibit construction
 */

/*
Data Classes

Convenient way to override equals,hashcode and toSting

---copy menthod
 */


data class Trade(val trader: String, val amount: Int)

fun letSeeCopy() {
    var t1 = Trade("bala", 1)
    var t2 = Trade("bala", 1)

    if (t1 == t2) {}// true if Trade is data class
    // false if Trade is not data class
}
