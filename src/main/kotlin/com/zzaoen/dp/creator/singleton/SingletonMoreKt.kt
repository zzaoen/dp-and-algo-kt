package com.zzaoen.dp.creator.singleton

/*
 * Author: Bruce Zhao
 * Date: 2020/3/12 20:03
 * Desc: Singleton design pattern implementation
 */
class SingletonMoreKt private constructor() {
  // private object HOLDER {
  //   val INSTANCE = DPSingleton()
  // }
  companion object {
    // lazy indicates it will be computed on the first access only. It's synchronized, the value
    // is computed only in one thread, and all threads will see the same value.
    val instance: SingletonMoreKt by lazy { SingletonMoreKt() }
  }
}

object DPObjectSingleton

class DPNotSingleton
