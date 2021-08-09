package com.zzaoen.dp.creator.factory

import com.zzaoen.kt.log

/*
 * Author: Bruce Zhao
 * Date: 2020/7/9 20:46
 * Desc:
 */

interface Computer {
  val cpu: String
}
data class PC(override val cpu: String = "Core") : Computer
data class Server(override val cpu: String = "Xeon") : Computer
enum class ComputerType {
  PC, Server
}

interface Creator {
  companion object {
    operator fun invoke(type: ComputerType): Computer {
      return when (type) {
        ComputerType.PC -> PC()
        ComputerType.Server -> Server()
      }
    }
  }
}

// object ComputerFactory {
//   operator fun invoke(type: ComputerType): Computer {
//     return when (type) {
//       ComputerType.PC -> PC()
//       ComputerType.Server -> Server()
//     }
//   }
// }

fun Creator.Companion.fromCPU(cpu: String): ComputerType? {
  return when (cpu) {
    "Core" -> ComputerType.PC
    "Xeon" -> ComputerType.Server
    else -> null
  }
}

fun main() {
  val pc = Creator(ComputerType.PC)
  log.info(pc.toString())
}
