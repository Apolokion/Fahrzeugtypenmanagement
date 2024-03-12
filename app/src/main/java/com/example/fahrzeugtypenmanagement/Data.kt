package com.example.fahrzeugtypenmanagement

// Interface für Fahrzeuge, die fliegen können
interface Flyable {
    fun fly()
}

// Basisklasse für Fahrzeuge
open class Vehicle {
    var currentSpeed: Double = 0.0
        protected set

    open fun accelerate(speed: Double) {
        currentSpeed += speed
    }

    open fun brake() {
        currentSpeed = 0.0
    }

    open fun countOfWheels(): Int {
        return 0
    }

    open fun distanceTraveled(time: Double): Double {
        return currentSpeed * time
    }
}

// Auto-Klasse
class Car : Vehicle() {
    override fun accelerate(speed: Double) {
        super.accelerate(speed * 1.2) // Autos beschleunigen schneller
    }

    override fun countOfWheels(): Int {
        return 4
    }
}

// Fahrrad-Klasse
class Bicycle : Vehicle() {
    override fun accelerate(speed: Double) {
        super.accelerate(speed * 0.8) // Fahrräder beschleunigen langsamer
    }

    override fun countOfWheels(): Int {
        return 2
    }
}

// LKW-Klasse
class Truck : Vehicle() {
    override fun accelerate(speed: Double) {
        super.accelerate(speed * 0.9) // LKWs beschleunigen langsamer als Autos
    }

    override fun countOfWheels(): Int {
        return 18
    }
}

// Flugzeug-Klasse und Flyable-Interface
class Airplane : Vehicle(), Flyable {
    override fun fly() {
        println("Flugzeug fliegt...")
    }

    override fun accelerate(speed: Double) {
        super.accelerate(speed * 2.0) // Flugzeuge beschleunigen viel schneller
    }

    override fun countOfWheels(): Int {
        return 6
    }
}

fun main() {
    val car = Car()
    car.accelerate(50.0)
    println("Autogeschwindigkeit: ${car.currentSpeed} km/h")
    println("Anzahl der Räder: ${car.countOfWheels()}")

    val bicycle = Bicycle()
    bicycle.accelerate(20.0)
    println("Fahrradgeschwindigkeit: ${bicycle.currentSpeed} km/h")
    println("Anzahl der Räder: ${bicycle.countOfWheels()}")

    val truck = Truck()
    truck.accelerate(30.0)
    println("LKW-Geschwindigkeit: ${truck.currentSpeed} km/h")
    println("Anzahl der Räder: ${truck.countOfWheels()}")

    val airplane = Airplane()
    airplane.accelerate(300.0)
    println("Flugzeuggeschwindigkeit: ${airplane.currentSpeed} km/h")
    println("Anzahl der Räder: ${airplane.countOfWheels()}")

    airplane.fly()
}
