package com.zzaoen.dp.behavior

/*
 * Author: Bruce Zhao
 * Date: 2020/7/11 15:26
 * Desc:
 */

abstract class CivicCenterTask {
  fun execute() {
    askForHelp()
    evaluate()
  }
  abstract fun askForHelp()
  private fun evaluate() = println("evaluate")
}
class SocialSecurity : CivicCenterTask() {
  override fun askForHelp() = println("ask social help")
}
class Pension : CivicCenterTask() {
  override fun askForHelp() = println("ask pension help")
}

fun main() {
  val socialSecurity = SocialSecurity()
  socialSecurity.execute()
}
