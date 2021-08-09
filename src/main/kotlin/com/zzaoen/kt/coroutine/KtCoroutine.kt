package com.zzaoen.kt.coroutine

/* 
 * Date: 2020/3/10 20:58
 * Desc: 
 */
import com.zzaoen.kt.logStr
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
fun main() {
  logStr("Start")

  // Start a coroutine
  GlobalScope.launch {
    delay(1000)
    logStr("Hello")
  }

  Thread.sleep(2000) // wait for 2 seconds
  logStr("Stop")
}
