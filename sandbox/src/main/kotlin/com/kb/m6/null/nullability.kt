package com.kb.m6.`null`
/*
Nullabiliy
    -Java often throws NPE
        -Need lots of defensive code

    Kotlin
        by default - not nullable
        -nullable types in kotlin -- so we can look at the code and say if it is safe to pass null or not..in fact we can;'t pass null
        - variable can be declared to accept null by putting ?next to type
        val x:Type?


        Safe Call  --- m?.call() check and call
        Elvis      --- ?: --null-coalescing...  in java, if not null, do otherwise retrun somthing
        Safe cast  --- as?
        No-null assertion --- !!  --NPE on that line..blunt instrument. it is meant to stand out

 */
fun main(args: Array<String>) {
    var m:Meeting? = null
    var newMeeting = Meeting()

    // we can't assign null
    newMeeting = m ?: Meeting()

    closeMeeting(m)
    closeMeeting(newMeeting)


    // if we don't have control on nonnull function
    // let will call only if m is not null
    m?.let{
        closeMeetingNonNull(m)
    }
}


fun closeMeeting(m: Meeting?): Boolean? {
    return if (m?.canClose == true) m?.close()
    else false
}

// will throw NPE if things goes wrong
fun closeMeetingAssert(m: Meeting?): Boolean? {

    return if (m!!.canClose) m.close()
    else false
}


fun closeMeetingNonNull(m: Meeting): Boolean? {
    return if (m.canClose) m.close()
    else false
}


class Meeting {
    val canClose: Boolean = false

    // i can't init now but i don't want to mark as null ..so lateinit
    lateinit var address: Address

    fun close(): Boolean {
        return true
    }

    fun save(o: Any) {
        //return null if not Isaveable
        val saveable = o as? ISaveable

        // so we need safe call
        saveable?.save()
    }

    fun init(addr : Address) {
        address = addr
    }
}

interface ISaveable {
    fun save()

}

class Address  {

}

/*


How it interacts with Java

 - Kotlin understands annotations  -- @nullable, @notNull (javax.annotation, jetbeans, android
 -


 */
