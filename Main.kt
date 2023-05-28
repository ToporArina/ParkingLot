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
            "reg_by_color" -> regByColor()
            "spot_by_color" -> spotByColor()
            "spot_by_reg" -> spotByReg()
            "exit" -> exitProcess(0)
        }
    }
}

fun park() {
    if (!isCreated()) {
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
    if (!isCreated()) {
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
    if (!isCreated()) {
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

fun regByColor() {
    if (!isCreated()) {
        return
    }
    var str = ""
    for (i in 0 until parking.size) {
        try {
            if (parking[i].split(" ")[1].lowercase() == inp[1].lowercase()) {
                str += parking[i].split(" ")[0] + ", "
            }
        } catch (e: Exception) {
            continue
        }
    }
    if (str.length == 0) {
        println("No cars with color ${inp[1]} were found.")
    } else {
        str = str.substring(0, str.length - 2)
        println(str)
    }
}

fun spotByColor() {
    if (!isCreated()) {
        return
    }
    var str = ""
//    println(parking[1].split(" ")[1].lowercase())
//    println(inp[1].lowercase())
    for (i in 0 until parking.size) {
        try {
            if (parking[i].split(" ")[1].lowercase() == inp[1].lowercase()) {
                str += "${ i + 1 }, "
            }
        } catch (e: Exception) {
            continue
        }
    }
    if (str.length == 0) {
        println("No cars with color ${inp[1]} were found.")
    } else {
        str = str.substring(0, str.length - 2)
        println(str)
    }
}

fun spotByReg() {
    if (!isCreated()) {
        return
    }
    var str = ""
    for (i in 0 until parking.size) {
        try {
            if (parking[i].split(" ")[0].lowercase() == inp[1].lowercase()) {
                str += "${ i + 1 }, "
            }
        } catch (e: Exception) {
            continue
        }
    }
    if (str.length == 0) {
        println("No cars with registration number ${inp[1]} were found.")
    } else {
        str = str.substring(0, str.length - 2)
        println(str)
    }
}

fun isCreated(): Boolean {
    if (!created) {
        println("Sorry, a parking lot has not been created.")
        return false
    }
    return true
}

