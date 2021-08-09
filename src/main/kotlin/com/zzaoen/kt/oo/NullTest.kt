package com.zzaoen.kt.oo

/* 
 * Date: 2020/6/30 20:59
 * Desc: 
 */

data class Person(
  val name: String
)

data class NullTest(
  val person: Person?
)

fun main() {
  // val test: NullTest = NullTest(null)
  // println(test.person!!.name)

  val person = null
  println(testNullable(person))
}

fun testNullable(person: Person?): String {
  return person?.name ?: "null"
}
