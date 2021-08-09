package com.zzaoen.kt.lambda

/*
 * Author: Bruce Zhao
 * Date: 2020/7/4 14:49
 * Desc:
 */

fun main() {
  foo {
    println("fooooooo")
  }
}

inline fun foo(block: () -> Unit) {
  println("start")
  block()
  println("end")
  "a" to "a"
}
