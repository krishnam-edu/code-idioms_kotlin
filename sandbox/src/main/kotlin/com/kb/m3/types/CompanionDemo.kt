package com.kb.m3.types

/*
Kotlin doesnt have static, however can have singletons

use object - singleton
use companion object - static
    --can't have const

Singleton makes testing difficult - use it if only needed

can act like class - extends , implements

it can be nested objects
 */
object Animals {
    var allAnimals = arrayListOf<Animal>()
}

fun singletontest(){
    Animals.allAnimals.add(Animal())
}

/*
Factory / static member
 */

class XYZ {
    companion object {
        fun thisIsStaticMethod(){

        }

        //factory

        fun createmethods(){

        }
    }
}

// outside world doen't see as static ..though it can be called like static without object..
//but, if you want to behave like static from java
// Use @JvmStatic