package com.zzaoen.kt.coroutine

import com.zzaoen.kt.logStr
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 * @author Bruce Zhao
 * @date 2021/4/8 11:10
 */

// fun main() {
//  runBlocking {
//    logStr("31")
//    delay(2000)
//    logStr("32")
//  }
//  GlobalScope.launch {
//    logStr("21")
//    delay(1000)
//    logStr("22")
//  }
//  logStr("1")
//  Thread.sleep(3000)
// }

fun main() = runBlocking {
//  val job = GlobalScope.launch {
//    logStr(this.coroutineContext.toString())
//    delay(1000L)
//    logStr("2")
//  }
//  logStr("1")
//  job.join()
//  delay(2000L)

//  launch {
//    delay(1000L)
//    logStr("2")
//  }
//  logStr(this.coroutineContext.toString())
//  doSomething()
//  logStr("1")

//  coroutineScope {
//    launch {
//      delay(500L)
//      println("Task from nested launch")
//    }
//
//    delay(100L)
//    println("Task from coroutine scope")
//  }

//  GlobalScope.launch {
//    repeat(1000) { i ->
//      logStr("I'm sleeping $i ...")
//      delay(500L)
//    }
//  }
//  delay(1300L)

  val result = withTimeoutOrNull(1300L) {
    repeat(1000) { i ->
      println("I'm sleeping $i ...")
      delay(500L)
    }
    "Done" // will get cancelled before it produces this result
  }
}

suspend fun doSomething() {
  logStr(currentCoroutineContext().toString())
  delay(1000L)
  logStr("2")
}
