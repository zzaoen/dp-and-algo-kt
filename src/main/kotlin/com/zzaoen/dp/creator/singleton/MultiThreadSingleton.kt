package com.zzaoen.dp.creator.singleton

/**
 * @author Bruce Zhao
 * @date 2021/3/1 16:15
 */
class MultiThreadSingleton {
  companion object {
    @Volatile
    private lateinit var instance: MultiThreadSingleton
    fun getInstance(): MultiThreadSingleton {
      if (instance != null) {
        return instance
      }
      synchronized(MultiThreadSingleton.javaClass) {
        if (instance == null) {
          instance = MultiThreadSingleton()
        }
      }
      return instance
    }
  }
}
