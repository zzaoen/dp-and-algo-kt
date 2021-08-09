package com.zzaoen.kt.oo

class Employee private constructor(val name: String, val title: String) {
  companion object {
    val TYPE_MANAGER = "manager"
  }
}

sealed class Shape {
  class Circle(val radius: Double) : Shape()
  class Rectangle(val width: Double, val height: Double) : Shape()
}

fun getArea(shape: Shape): Double = when (shape) {
  is Shape.Circle -> 1.0
  is Shape.Rectangle -> 2.0
}

fun factorial(n: Int): Long = if (n == 1) 1 else n * factorial(n - 1)

fun main() {
  // val e = Employee
  // println(e.TYPE_MANAGER)

  // val circle: Shape = Shape.Circle(1.0)
  // val rectangle: Shape = Shape.Rectangle(2.0, 2.0)

  // println(getArea(circle))
  // println(getArea(rectangle))

  // println(factorial(20))

  val naturalNumber = generateSequence(0) {
    it + 1
  }

  naturalNumber.takeWhile { it <= 5 }.forEach { println(it) }
  naturalNumber.takeWhile { it <= 5 }.forEach { println(it) }
}
