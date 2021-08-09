package com.zzaoen.dp.creator.builder

/*
 * Author: Bruce Zhao
 * Date: 2020/7/9 21:59
 * Desc:
 */

class Computer private constructor(val name: String, val memory: Int?, val disk: Int?) {
  class Builder(val name: String) {
    private var memory: Int? = null
    private var disk: Int? = null

    fun memory(memory: Int): Builder {
      this.memory = memory
      return this
    }

    fun disk(disk: Int): Builder {
      this.disk = memory
      return this
    }

    fun build(): Computer {
      return Computer(name, memory, disk)
    }
  }

  override fun toString(): String {
    return "Computer(name='$name', memory=$memory, disk=$disk)"
  }
}

// class ComputerClass(val name: String, val memory: Int? = null, val disk: Int? = null) {
//   init {
//     require(memory != null) {
//       "throw"
//     }
//   }
// }

fun main() {
  val mac = Computer.Builder(name = "Mac").build()
  println(mac)

  val newMac = Computer.Builder(name = "new Mac").memory(100).disk(1).build()
  println(newMac)
  // val builder2 = Computer.Builder(name = "b2").setMemory(100)
  // println(builder1.build())

  // val computer = ComputerClass(name = "a")
}
