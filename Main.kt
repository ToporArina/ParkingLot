package parking

import kotlin.system.exitProcess

data class Car(var num: String, var color: String)

var parking = Array(20) { "" }
var inp = listOf<String>()

fun main() {
    while (true) {
        inp = readln().split(" ")
        when (inp[0]) {
            "park" -> park()
            "leave" -> leave()
            "exit" -> exitProcess(0)
        }
    }
}

fun park() {
    for (i in 0 until parking.size) {
        if (parking[i] != "") {
            continue
        } else {
            parking[i] = "${inp[1]} ${inp[2]}"
            println("${inp[2]} car parked in spot ${i + 1}.")
            return
        }
    }
    println("Sorry, the parking lot is full.")
    return
}

fun leave() {
    parking[inp[1].toInt() - 1] = ""
    println("Spot ${inp[1]} is free.")
}
