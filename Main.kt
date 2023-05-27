package parking

fun main() {
    val park = readln().split(" ")
    if (park[0] == "park") {
        println("${park[2]} car parked in spot 2.")
    } else if (park[0] == "leave" && park[1] == "1") {
        println("Spot 1 is free.")
    } else if (park[0] == "leave" && park[1] == "2") {
        println("There is no car in spot 2.")
    }
}
