package parking

import kotlin.system.exitProcess

data class Car(var num: String, var color: String)

var parking = ArrayList<String>()
var inp = listOf<String>()
var created = false

fun main() {
    while (true) {
        inp = readln().split(" ")
        when (inp[0]) {
            "park" -> park()
            "leave" -> leave()
            "create" -> create()
            "status" -> status()
            "exit" -> exitProcess(0)
        }
    }
}

fun park() {
    if (!created) {
        println("Sorry, a parking lot has not been created.")
        return
    }
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
    if (!created) {
        println("Sorry, a parking lot has not been created.")
        return
    }
    parking[inp[1].toInt() - 1] = ""
    println("Spot ${inp[1]} is free.")
}

fun create() {
    parking.clear()
    repeat(inp[1].toInt()) {
        parking.add("")
    }
    created = true
    println("Created a parking lot with ${inp[1]} spots.")
}

fun status() {
    if (!created) {
        println("Sorry, a parking lot has not been created.")
        return
    }
    var isNotEmpty = false
    for (i in 0 until parking.size) {
        if (parking[i] != "") {
            println("${i + 1} ${parking[i]}")
            isNotEmpty = true
        }
    }
    if (!isNotEmpty) {
        println("Parking lot is empty.")
    }
}