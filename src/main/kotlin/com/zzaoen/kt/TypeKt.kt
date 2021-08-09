package com.zzaoen.kt

import java.util.ArrayList

/*
 * Author: Bruce Zhao
 * Date: 2020/8/14 16:41
 * Desc:
 */

fun main() {
  val list = listOf(1, 2, 3)
  val map = list.myMap { it * 2 }
  println(list)
  println(map)
}

fun <T, R> List<T>.myMap(transform: (T) -> R): List<R> {
  val resList = ArrayList<R>(this.size)
  this.forEach { resList.add(transform(it)) }
  return resList
}

fun getValue(): Int? {
  return 1
}

inline fun <reified T> getType(): Class<T> {
  return T::class.java
}

class Plate<T>(val t: T, private val clazz: Class<T>) {
  fun showType() {
    println(clazz)
  }
}
