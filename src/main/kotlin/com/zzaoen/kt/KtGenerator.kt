package com.zzaoen.kt

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/*
 * Author: Bruce Zhao
 * Date: 2020/8/2 13:29
 * Desc:
 */

interface Generator<T> {
  operator fun iterator(): Iterator<T>
}

// fun <T> generator(block: suspend GeneratorScope<> )

fun main() {
  val sequence = sequence {
    yield(1)
    yield(2)
    yieldAll(listOf(1, 2))
  }

  for (i in sequence) {
    println(i)
  }

  sequence.take(6).forEach(::println)

  GlobalScope.launch(Dispatchers.Main, CoroutineStart.DEFAULT) {
  }
}
