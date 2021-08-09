package com.zzaoen.dp.behavior

/*
 * Author: Bruce Zhao
 * Date: 2020/7/11 15:26
 * Desc:
 */

class CivicCenterTask2 {
  fun execute(askForHelp: () -> Unit) {
    askForHelp()
    evaluate()
  }
  private fun evaluate() = println("evaluate")
}
fun socialHelp() {
  println("ask social help")
}
fun main() {
  val socialSecurity = CivicCenterTask2()
  socialSecurity.execute(::socialHelp)
}
