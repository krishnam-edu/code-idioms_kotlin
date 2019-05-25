package com.kb.m4.hlfunc

fun main(args: Array<String>) {
    var program = Program()
    var total = 0
// Old way
//    program.fibonacci(8, object : Process{
//        override fun execute(value: Int) {
//            println(value)
//        }
//    })

    program.fibonacci(5, { n -> println(", $n") })
    program.fibonacci(8) { n -> println(n) }
    program.fibonacci(8) { println(it) }
    program.fibonacci(8, ::println)


    println(total)


    //lambda expression or anonymous function (as well as a local function and an object expression) can access its closure, i.e. the variables declared in the outer scope. Unlike Java, the variables captured in the closure can be modified:

    var sum = 0
    var ints = -10..10
    ints.filter { it > 0 }.forEach {
        sum += it
    }
    print(sum)

}

interface Process {
    fun execute(value: Int)
}

class Program {

    // 1, 1, 2, 3, 5, 8, 13

    fun fibonacci(limit: Int, action: (Int) -> Unit) {
        var prev = 0
        var prevprev = 0
        var current = 1

        for (i: Int in 1..limit) {
            action(current)

            var temp = current
            prevprev = prev
            prev = temp
            current = prev + prevprev
        }
    }

    //Using interface
    fun fibonacci(limit: Int, action: Process) {
        var prev = 0
        var prevprev = 0
        var current = 1

        for (i: Int in 1..limit) {
            action.execute(current)

            var temp = current
            prevprev = prev
            prev = temp
            current = prev + prevprev
        }
    }
}

/*

 */