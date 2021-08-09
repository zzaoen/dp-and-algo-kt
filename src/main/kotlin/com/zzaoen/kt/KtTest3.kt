@file:JvmName("NewName")

package com.zzaoen.kt

import java.io.BufferedReader
import java.io.IOException
import java.lang.IllegalStateException

/**
 * @author: Bruce Zhao
 * @date: 2020/12/14 12:32
 * @desc:
 */

fun readLine(reader: BufferedReader): Int? {
  return try {
    val s = reader.readLine()
    s.toInt()
  } catch (e: IOException) {
    null
  } finally {
    reader.close()
  }
}

fun String.lastChar() = this[this.length - 1]

// class User(val name: String = "Bruce", val isGuest: Boolean = true, val age: Int = 1)
open class User(val name: String)
class AUser(name: String, val age: Int) : User(name)

class PrivateUser(override val name: String) : IUser
class RegisteredUser() : IUser {
  override val name: String
    get() = TODO("Not yet implemented")
}

class TwitterUser(private val id: String) : IUser {
  override val name = getTwitterName(id)

  private fun getTwitterName(id: String): String {
    TODO("Not yet implemented")
  }
}

var counter = 0
val count = { counter++ }

fun fail(message: String): Nothing {
  throw IllegalStateException(message)
}

fun main() {
  // fail("fail")

  var flag: Boolean? = null
  if (flag != true) {
    println("good")
  }

  val oneToTen: IntRange = 1..10
  oneToTen.forEach(::println)

  val aUser = AUser("Bruce", age = 100)

  count()

  val name: String = if (counter > 0) "name" else fail("failed")
  println(name)

  val strings: List<String> = listOf("a", "b")
  val toTypedArray: Array<String> = strings.toTypedArray()

  println("%s/%s".format(*toTypedArray))
}
