package com.rsk.kotlin

import com.kb.m7.interop.java.MeetingJava


fun main(args: Array<String>) {
    val m = MeetingJava()

    //See platform type -- hidden "Type!"hist
    // try to asign to int something else -- we will know
    // developer responsibility to take care of null


//    m.addTitle("Title")
//    m.addTitle(null)

// IlligalStateException must not be null - runtime
// --if we use annotation in java , it will tell compile error in kotlin


//    val title: String? = m.meetingTitle()
//
//    println(title)
    val title: String = m.titleCanBeNull() ?: "nobody"
    println(title)
}


