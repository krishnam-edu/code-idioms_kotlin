package com.kb.m5.mapnfilter
/*
lamda - returns true or false

collection have some useful predicates
 */
fun main(args: Array<String>){
    val ints = listOf(1, 2, 3, 4, 5)

    //we can declare predicate as variable and pass it
    val greaterThanThree = { v:Int -> v > 3}

    var isAllLarge = ints.all((greaterThanThree))

    println(isAllLarge)

    val isAnyLarge = ints.any (greaterThanThree)

    println(isAnyLarge)

    var numberOfLargeInts: Int = ints.count(greaterThanThree)

    println(numberOfLargeInts)

    var found: Int? = ints.find(greaterThanThree)

    println(found)
    found= ints.find{ it > 6}

    println(found)
}
