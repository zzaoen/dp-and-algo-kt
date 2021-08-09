package com.zzaoen.kt.coroutine

import com.zzaoen.kt.logStr
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
class ExampleCoroutine : CoroutineScope {
  override val coroutineContext: CoroutineContext
    get() = Dispatchers.Default

  fun exampleCoroutineScope(): Job {
    logStr("outside")

    return launch {
      printlnDelayed("inside")
    }
  }

  private suspend fun printlnDelayed(message: String) = coroutineScope {
    withContext(Dispatchers.Default) {
      delay(1000)
      logStr(message)
      // Complex calculation
    }
  }
}
