package com.zzaoen.kt

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.Continuation
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.createCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.startCoroutine

/*
 * Author: Bruce Zhao
 * Date: 2020/7/31 13:48
 * Desc:
 */

fun main() {

  val continuation = suspend {
    logStr("in")
    2
  }.createCoroutine(object : Continuation<Int> {
    override fun resumeWith(result: Result<Int>) { // callback
      logStr("end, result=$result")
    }

    override val context = EmptyCoroutineContext
  })
  continuation.resume(Unit)

  launchCoroutine(ProducerScope<Int>()) {
    logStr("in coroutine")
    produce(100)
    delay(100)
    produce(200)
    111
  }

  launchCoroutine(Int) {
    logStr("in Int coroutine")
    222
  }

  runBlocking {
    delay(1000)
  }
}

// @RestrictsSuspension This annotation will restrict can't use out suspend function (e.g. delay) in the suspend body.
class ProducerScope<T> {
  suspend fun produce(value: T) {
    println(value)
  }
}

fun <R, T> launchCoroutine(receiver: R, block: suspend R.() -> T) {
  block.startCoroutine(
    receiver,
    object : Continuation<T> {
      override fun resumeWith(result: Result<T>) { // callback
        logStr("end, result=$result")
      }
      override val context = EmptyCoroutineContext
    }
  )
}
