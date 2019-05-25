package com.kb.m5.mapnfilter

/**
 *
 * Using functional style with collections.
 *  - Kotlin collections use lambdas
 *  - Many helpful methods
 *  - Easier to read code
 *  - One problem though
 *      - list could be very large
 *          - map & filter creates internal list --high memory usage
 *          - the solution is sequences
 *
 *
 * Essential Functions
 *
 * Filter
 *  - Transforms collections
 *  - Fillers out unwanted items
 *  - similar to 'where  in sql'
 *
 *  Map
 *  - Transform items - takes one item and transform it
 *  - similar to 'select' in sql
 *
 *  --projections
 *
 */
fun main(args: Array<String>): Unit {
    val ints = 1..10

    println("filter")
    val smallInts = ints.filter { it < 4 }
    for (i in smallInts) println(i)

    println("map")
    val cubeInts = ints.map { it * it * it }
    for (i in cubeInts) println(i)

    println("can be chained")
    val smallSquaredInts = ints
            .filter { it < 5 }
            .map { it * it }
    for (i:Int in smallSquaredInts) println(i)

    val meetings = listOf(Meeting(1, "Board Meeting"), Meeting(2, "Committee Meeting"))

    val titles: List<String> = meetings
            .filter { it -> it.title.startsWith("C") }
            .map { m -> m.title }
    for (t in titles) println(t)


}

