package com.zzaoen.kt.coroutine

import com.zzaoen.kt.logStr
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

/**
 * @author Bruce Zhao
 * @date 2021/4/14 17:39
 */

fun main() {
  // logStr("main started")
  /*val a = doSomethingUsefulOne()
  val b = doSomethingUsefulTwo()
  logStr(a + b)*/

  /*coroutineScope {
    val one: Deferred<Int> = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
    val two = async { doSomethingUsefulTwo() }
//    two.start()
    logStr("The answer is ${one.await() + two.await()}")
    // this will lead to sequential behavior, https://kotlinlang.org/docs/composing-suspending-functions.html#lazily-started-async
  }*/

  // val launch = CoroutineScope(Dispatchers.Default).launch {
  //   val time = measureTimeMillis {
  //     val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
  //     val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
  //     // some computation
  //     one.start() // start the first one
  //     two.start() // start the second one
  //     logStr("The answer is ${one.await() + two.await()}")
  //   }
  //   logStr("Completed in $time ms")
  // }
  // logStr("end")
  // launch.join()

//  val one = GlobalScope.async { doSomethingUsefulOne() }
//  val two = GlobalScope.async { doSomethingUsefulTwo() }
//  println("The answer is ${one.await() + two.await()}")

  val time = measureTimeMillis {
    runBlocking {
      for (i in 1..2) {
        // launch(Dispatchers.Default) {
        // CoroutineScope(Dispatchers.Default).launch {
        //   work(i)
        //   println("Thread: ${Thread.currentThread().name}")
        // }
        launch {
          work(i)
        }
      }
    }
  }

  println("Done in $time ms")
}

suspend fun work(i: Int) = withContext(Dispatchers.Default) {
  // Thread.sleep(1000)
  delay(1000)
  println("Work $i done ${Thread.currentThread().name}")
}

suspend fun doSomethingUsefulOne(): Int {
  delay(1000L) // pretend we are doing something useful here
  logStr("in one ${currentCoroutineContext()}")
  return 13
}

suspend fun doSomethingUsefulTwo(): Int {
  delay(1000L) // pretend we are doing something useful here, too
  logStr("in two ${currentCoroutineContext()}")
  return 29
}
