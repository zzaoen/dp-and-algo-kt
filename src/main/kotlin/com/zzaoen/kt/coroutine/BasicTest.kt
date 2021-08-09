package com.zzaoen.kt.coroutine

import com.zzaoen.kt.logStr
import com.zzaoen.kt.logStrSuspend
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author Bruce Zhao
 * @date 2021/4/8 13:13
 */

// suspend fun main() {
//  val deferredList: List<Deferred<Int>> = (1..100).map {
//    GlobalScope.async {
//      it
//    }
//  }
//  val sum = deferredList.sumOf {
//    it.await().toLong()
//  }
//  logStr(sum)
// }

fun main() = runBlocking {

  val job = launch {
    try {
      while (isActive) {
        logStr("!")
        delay(1000)
      }
    } catch (ex: CancellationException) {
//      logStr("exception")
      logStrSuspend("ex")
    }
  }
  delay(3000)
  job.cancelAndJoin()
  logStr("quit!")
}
