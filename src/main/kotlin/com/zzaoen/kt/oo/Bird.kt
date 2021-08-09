package com.zzaoen.kt.oo

// open class Bird {
//   open fun fly() {
//     val animal: Animal = Animal()
//     println(animal.getName())
//   }
// }
//
// fun main() {
//   val bird = Bird()
//   bird.fly()
// }

// interface Bird {
//   // val weight: Double = 500.0
//   // val color: String = "blue"
//   // val age: Int = 0
//   val age: Int
//     get() = 1
//   val size: Int
//   fun fly() {
//     println("fly")
//   }
// }
// class Pigeon(override val age: Int, override val size: Int) : Bird
//
// fun main() {
//   val bird = Pigeon(1, 1)
//   bird.fly()
// }

class BMW {
  private val engine = Engine()

  fun getEngine(): String {
    return engine.getType()
  }
}

internal class Engine {
  fun getType() = "bmw engine"
}
