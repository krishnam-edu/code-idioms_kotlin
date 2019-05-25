package com.kb.m5.mapnfilter

/*
When
 - functions such as filter map create lists
 - fine if list is small
 - not good if lists are massive
 - instead of use Sequences
        - no eval until we ask it -- terminal operator
        - no extra memory
        - similar to list but lazily evaluated
        - like Java 8 Streams (exactly the same) -- streams are not available everywhere like android, whwre kotlin sequqnce can be used

work on the result of asSequence()

without sequence
for {s1}
for {s2}
for {s3}

with sequence
for {w
s1
s2
s3
}

 */
fun iter(seq: Sequence<String>) {

}

fun main(args: Array<String>): Unit {


    val meetings = listOf(Meeting(1, "Board Meeting"), Meeting(2, "Committee Meeting"), Meeting(1, "lunch break"))

    println("without Sequence")
    val titles = meetings
            //      .asSequence()
            .filter { println("filter($it)"); it.title.endsWith("g") }
            .map { println("map($it)"); it.title }

    println("with Sequence")
    val titlesWithSe = meetings
            .asSequence()
            .filter { println("filter($it)"); it.title.endsWith("g") }
            .map { println("map($it)"); it.title }
// lazy eval
    for (t in titlesWithSe) println("from outside expression $t")

//    for (t in titles) println(t)
//
//    val title = meetings
//            .asSequence()
//            .map{ println("map($it)"); it.title.toUpperCase()}
//            .find { it.startsWith("BOARD")}
//
//    println(title)
}

/*
lambda to functional interface
 */
