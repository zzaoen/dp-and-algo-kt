package com.zzaoen.kt

import kotlinx.coroutines.delay
import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.suspendCoroutine

/*
 * Author: Bruce Zhao
 * Date: 2020/7/31 14:39
 * Desc:
 */

suspend fun main() {
  // logStr("1")
  suspendInAnotherThread("a", "b")
  // logStr("out")

  // notSuspend()

  val ref = ::notSuspend
  val result = ref.call(object : Continuation<Int> {
    override val context: CoroutineContext
      get() = EmptyCoroutineContext

    override fun resumeWith(result: Result<Int>) {
      println("reflect call suspend method, result=$result")
    }
  })
  var list = emptyList<Int>()
  list += 1
  list += listOf(1, 2)
  delay(100)
}

suspend fun suspendInAnotherThread(a: String, b: String) = suspendCoroutine<Int> { continuation ->
  thread {
    logStr("21")
    continuation.resumeWith(Result.success(21))
  }
}

suspend fun notSuspend() = suspendCoroutine<Int> { continuation ->
  logStr("22")
  continuation.resumeWith(Result.success(22))
}
