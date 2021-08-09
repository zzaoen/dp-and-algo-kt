package com.zzaoen.kt

/**
 * @author Bruce Zhao
 * @date 2021/2/8 09:57
 */

enum class Org {
  NORAM, ITHACA
}

fun main() {
  // val myMap = mutableMapOf<String, Any?>()
  // myMap["name"] = "name"
  // myMap["age"] = 13
  // myMap["gender"] = null
  //
  // val gender = myMap["gender"] as String
  // println(gender)

  val org = Org.NORAM

  val i = when (org) {
    Org.NORAM -> 1
    Org.ITHACA -> 2
  }
  println(i)
}
