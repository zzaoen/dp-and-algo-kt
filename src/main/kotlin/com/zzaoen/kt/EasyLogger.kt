package com.zzaoen.kt

import org.slf4j.Logger
import org.slf4j.LoggerFactory

val log: Logger = LoggerFactory.getLogger("KtCoroutine")

fun logStr(msg: Any?) {
  when (msg) {
    is Number ->
      logStr(msg.toString())
    is String ->
      logStr(msg)
    else ->
      throw Exception("Unknown msg type")
  }
}

fun logStr(msg: String?) {
  log.info(msg)
}

suspend fun logStrSuspend(msg: String?) {
  log.info(msg)
}
