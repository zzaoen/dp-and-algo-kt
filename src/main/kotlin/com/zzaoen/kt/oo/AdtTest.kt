package com.zzaoen.kt.oo

/* 
 * Date: 2020/6/30 21:27
 * Desc: 
 */

sealed class Either<A, B> {
  class Left<A, B> (val value: A) : Either<A, B>() {
    override fun toString(): String {
      return "value=$value"
    }
  }
  class Right<A, B> (val value: B) : Either<A, B>() {
    override fun toString(): String {
      return "value=$value"
    }
  }
}

fun main() {
  val str: String? = null

  val either = str?.let {
    Either.Left<String, Error>(it)
  } ?: Either.Right<String, Error>(Error("test"))

  println(either)
}
