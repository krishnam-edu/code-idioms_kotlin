package com.kb.m5.mapnfilter

/**
 * to handle list of list object while using map
 */

fun main(args: Array<String>) : Unit {


    val meetings = listOf(Meeting(1, "Board Meeting"), Meeting(2, "Committee Meeting"))

    val people: List<Person> = meetings
            .flatMap(Meeting::people)
            .distinct()

    for (p in people) println(p.name)
}

