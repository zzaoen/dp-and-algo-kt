package com.zzaoen.kt

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import com.zzaoen.kt.lastChar as last
/* 
 * Date: 2020/5/8 08:34
 * Desc: 
 */
// class KtTest {
//   suspend fun main() = coroutineScope {
//     launch {
//       delay(1000)
//       println("Kotlin Coroutines World!")
//     }
//     println("Hello")
//   }
// }

// fun main() {
//   GlobalScope.launch {
//     delay(1000)
//     println("ok")
//   }
//   println("Hello")
// }

// suspend fun main() = runBlocking {
//   launch {
//     delay(1000)
//     logStr("Kotlin Coroutines World!")
//   }
//   logStr("After")
// }

// suspend fun main() = coroutineScope {
//
// }

fun main() {
  testRunFunction()
  "aa".last()
}

fun testRunFunction() = runBlocking {
  logStr("------------")
  // Start a coroutine
  launch {
    logStr("In start : ${getThreadName()}")
    Thread.sleep(200)
    // delay(2000)
    logStr("In ended : ${getThreadName()}")
  }

  logStr("before delay")
  delay(2000)
  // Thread.sleep(200)
  logStr("after delay")

  run {
    logStr("Out start: ${getThreadName()}")
    Thread.sleep(300)
    // delay(3000)
    logStr("Out ended: ${getThreadName()}")
  }
}

fun getThreadName(): String = Thread.currentThread().name
