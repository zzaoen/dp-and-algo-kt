package com.zzaoen.kt

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

suspend fun main() = coroutineScope {

  launch {
    delay(2000)
    logStr("3")
  }

  // GlobalScope.launch {
  //   delay(1000)
  //   logStr("1")
  // }
  thread(start = false) {
    Thread.sleep(1000)
    logStr("s1")
  }
  // val launch = GlobalScope.launch {
  //   delay(1000)
  //   logStr("1")
  // }

  logStr("2")
  // launch.join()
}
