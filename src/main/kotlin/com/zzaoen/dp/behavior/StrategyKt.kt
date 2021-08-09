package com.zzaoen.dp.behavior

/*
 * Author: Bruce Zhao
 * Date: 2020/7/11 15:11
 * Desc:
 */

fun freestyle() = println("freestyle")
fun breaststroke() = println("breaststroke")

class Swimmer(val swimming: () -> Unit) {
  fun swim() = swimming()
}

fun main() {
  val swimmer1 = Swimmer(::freestyle)
  val swimmer2 = Swimmer(::breaststroke)
  swimmer1.swim()
  swimmer2.swim()
}
