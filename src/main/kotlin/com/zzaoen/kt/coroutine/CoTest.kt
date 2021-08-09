package com.zzaoen.kt.coroutine

import com.zzaoen.kt.logStr
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author Bruce Zhao
 * @date 2021/3/24 17:20
 */
suspend fun main() {
  runBlocking {
    asyncOperation() // this is running in bg thread
  }

  GlobalScope.launch {
    asyncOperation() // this is running in bg thread
//    launch {
//      completionHandler() // this is running in main thread.
//    }
//    completionHandler() // this is running in main thread.
  }

  /*GlobalScope.launch {
    asyncOperation()
  }
  GlobalScope.launch {
    completionHandler()
  }*/
  delay(1000)
}
suspend fun asyncOperation() {
  logStr("Thread is ${Thread.currentThread().name} AsyncOperation")
  logStr("Started async operation")
  delay(300)
  logStr("Completed async operation")
}
suspend fun completionHandler() {
  logStr("Thread is ${Thread.currentThread().name} completionHandler")
  logStr("Running after async opearion")
}
