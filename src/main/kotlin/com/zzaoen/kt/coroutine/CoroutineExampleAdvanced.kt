package com.zzaoen.kt.coroutine

import com.zzaoen.kt.logStr
import com.zzaoen.kt.logStrSuspend
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking

/* 
 * Author: Bruce Zhao
 * Date: 2020/3/24 17:58
 * Desc: 
 */
// @ExperimentalCoroutinesApi
suspend fun main() = coroutineScope {
  /*for (i in 0 until 10) {
      launch {
          delay(1000L - i * 10)
          print("❤️$i ")
      }
  }*/

  val startTime = System.currentTimeMillis()
  logStr("Started")

  // val findBigPrime = findBigPrime()
  // logStr("Big prime is ${findBigPrime}")

  exampleBlocking11()
  // exampleBlocking2()

  // exampleBlockingDispatcher()

  // exampleLaunchGlobal()
  // exampleLaunchGlobalWaiting()

  // exampleLaunchCoroutineScope()

  // exampleAsyncAwaitWrong()
  // exampleAsyncAwait()
  // exampleWithContext()
  logStrSuspend("Spent: ${System.currentTimeMillis() - startTime}")

  exampleBlocking111()
}

fun exampleBlocking11() {
  logStr("one")
  // runBlocking block current thread

  runBlocking(Dispatchers.Default) {
    printlnDelayed("two")
  }
  logStr("three")
}

suspend fun exampleBlocking111() {
  logStr("one")
  printlnDelayed("two")
  logStr("three")
}
//
// fun exampleBlocking2() = runBlocking(Dispatchers.Default) {
//   logStr("one")
//   printlnDelayed("two")
//   logStr("three")
// }
//
// // Running on another thread but still blocking the main thread
// fun exampleBlockingDispatcher() {
//   runBlocking(Dispatchers.Default) {
//     logStr("one")
//     printlnDelayed("two")
//   }
//   // Outside of runBlocking to show that it's running in the blocked main thread
//   logStr("three")
//   // It still runs only after the runBlocking is fully executed.
// }
//
// @ExperimentalCoroutinesApi
// fun exampleLaunchGlobal() = runBlocking(Dispatchers.Default) {
//   logStr("one")
//
//   // Will use DefaultDispatcher-worker thread, not in main thread
//   // Default will start immediately
//   GlobalScope.launch(start = CoroutineStart.DEFAULT) {
//     printlnDelayed("two")
//   }
//
//   delay(10)
//   logStr("three")
//
//   //If not delay, this method will exit
//   delay(3000)
// }
//
// fun exampleLaunchGlobalWaiting() = runBlocking {
//   logStr("one")
//
//   val job = GlobalScope.launch {
//     printlnDelayed("two")
//   }
//
//   logStr("three")
//
//   // After job join, this method finished
//   job.join()
// }
//
// fun exampleLaunchCoroutineScope() = runBlocking {
//   logStr("one")
//
//   val customDispatcher = Executors.newFixedThreadPool(2).asCoroutineDispatcher()
//
//   val job = GlobalScope.launch(customDispatcher) {
//     printlnDelayed("two")
//   }
//   // launch(customDispatcher) {
//   //   printlnDelayed("two")
//   // }
//   logStr("three")
//   job.join()
//
//   (customDispatcher.executor as ExecutorService).shutdown()
// }
//
// fun exampleAsyncAwaitWrong() = runBlocking {
//   val startTime = System.currentTimeMillis()
//
//   // Call await after async will sequence execute the code.
//   val deferred1 = withContext(Dispatchers.Default) { calculateHardThings(10) }
//   // val deferred1 = async { calculateHardThings(10) }.await()
//   val deferred2 = async { calculateHardThings(20) }.await()
//   val deferred3 = async { calculateHardThings(30) }.await()
//
//   val sum = deferred1 + deferred2 + deferred3
//   println("async/await result = $sum")
//
//   val endTime = System.currentTimeMillis()
//   println("Time taken: ${endTime - startTime}")
// }
//
// fun exampleAsyncAwait() = runBlocking {
//   val deferred1 = async { calculateHardThings(10) }
//   val deferred2 = async { calculateHardThings(20) }
//   val deferred3 = async { calculateHardThings(30) }
//
//   val sum = deferred1.await() + deferred2.await() + deferred3.await()
//   logStr("async/await result = $sum")
//
//   // val map = listOf(10, 20, 30).map {
//   //   async { calculateHardThings(it) }
//   // }
//   // val result = map.sumBy { it.await() }
// }
//
// fun exampleWithContext() = runBlocking {
//   // withContext just like async followed with await.
//   val result1 = withContext(Dispatchers.Default) { calculateHardThings(10) }
//   val result2 = withContext(Dispatchers.Default) { calculateHardThings(20) }
//   val result3 = withContext(Dispatchers.Default) { calculateHardThings(30) }
//
//   val sum = result1 + result2 + result3
//   logStr("async/await result = $sum")
//
// }
