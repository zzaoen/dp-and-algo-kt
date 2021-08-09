package com.zzaoen.dp.creator.singleton

/**
 * @author Bruce Zhao
 * @date 2021/3/1 16:09
 */
class SingleThreadSingleton private constructor() {
  companion object {
    private var instance: SingleThreadSingleton? = null
    fun getInstance(): SingleThreadSingleton {
      if (instance == null) {
        instance = SingleThreadSingleton()
      }
      return instance!!
    }
  }
}
