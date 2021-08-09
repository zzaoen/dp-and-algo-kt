package com.zzaoen.dp.creator.singleton

import com.zzaoen.kt.logStr

/* 
 * Date: 2020/3/12 20:11
 * Desc: 
 */

fun main() {
  // instance is a companion object, so DPSingleton needn't initialize
  // companion is a static final class,
  val dpSingleton1 = SingletonMoreKt.instance
  val dpSingleton2 = SingletonMoreKt.instance
  logStr(dpSingleton1.toString())
  logStr(dpSingleton2.toString())

  // object has a static INSTANCE variable, DPObjectSingleton means
  // DPObjectSingleton.INSTANCE
  val dpSingleton3 = DPObjectSingleton
  val dpSingleton4 = DPObjectSingleton
  logStr(dpSingleton3.toString())
  logStr(dpSingleton4.toString())

  val dpNotSingleton1 = DPNotSingleton()
  val dpNotSingleton2 = DPNotSingleton()
  logStr(dpNotSingleton1.toString())
  logStr(dpNotSingleton2.toString())

  // val sts = SingleThreadSingleton()
  val instance = SingleThreadSingleton.getInstance()
  val instance2 = SingleThreadSingleton.getInstance()
  println(System.identityHashCode(instance))
  println(System.identityHashCode(instance2))
}
