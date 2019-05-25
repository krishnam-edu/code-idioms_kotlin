package rsk

fun main(args: Array<String>) : Unit {


    val meetings = listOf(Meeting(1, "Board Meeting"), Meeting(2, "Committee Meeting"))

    val people: List<Person> = meetings
            .flatMap(Meeting::people)
            .distinct()

    for (p in people) println(p.name)
}

