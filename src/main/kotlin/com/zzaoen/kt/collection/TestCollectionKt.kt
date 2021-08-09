package com.zzaoen.kt.collection

/* 
 * Author: Bruce Zhao
 * Date: 2020/8/28 20:12
 * Desc: 
 */

fun main() {
  val map: Map<Int, Int> = mapOf(1 to 1)
  println(map)

  val list: List<Int> = listOf(1, 2, 4)

  val asSequence = list.asSequence().filter { it >= 2 }

  asSequence.iterator().forEach {
    println(it)
  }
}
