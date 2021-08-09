package com.zzaoen.kt

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/* 
 * Date: 2020/3/24 19:12
 * Desc: 
 */
interface IExampleCoroutine : CoroutineScope {
  val job: Job

  override val coroutineContext: CoroutineContext
    get() = job + Dispatchers.Default

  fun exampleCoroutineScope() {
    logStr("outside")

    val job = launch {
      printlnDelayed("inside")
    }
  }

  suspend fun printlnDelayed(message: String) = coroutineScope {
    withContext(Dispatchers.Default) {
      delay(1000)
      logStr(message)
      // Complex calculation
    }
  }
}
