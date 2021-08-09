package com.zzaoen.algo.array

import kotlin.collections.HashMap

/**
 * @author Bruce Zhao
 * @date 2020/11/2 09:15
 */

fun main() {
  val main = EasyArrayKt()
  // val result = main.intersection(intArrayOf(1, 2, 2, 1), intArrayOf(3, 3))
  // val result = main.intersectionSimple(intArrayOf(1, 2, 2, 1), intArrayOf(1, 3))
  // println(result.contentToString())

  // val array = intArrayOf(0, 3, 2, 1)
  // println(main.validMountainArray(array))

  // val array = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
  // main.removeDuplicates(array)

  val array = intArrayOf(2, 2, 1, 1, 1, 2, 2)
  println(main.majorityElement(array))
}

class EasyArrayKt {
  fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val map = HashMap<Int, Int>()
    for (num in nums1) {
      map.putIfAbsent(num, 1)
    }

    for (num in nums2) {
      map[num]?.let {
        map.put(num, it + 1)
      }
    }

    val result = mutableListOf<Int>()
    for (entry in map) {
      println(" " + entry.key + " " + entry.value)
    }
    map.entries.filter {
      it.value > 1
    }.forEach {
      result.add(it.key)
    }
    return result.toIntArray()
  }

  fun intersectionSimple(nums1: IntArray, nums2: IntArray): IntArray {
    return nums1.toSet().intersect(nums2.toSet()).toIntArray()
  }

  /**
   * 0,3,5,9,2,1 true
   * 0,3,5,2,1 true
   * 0,1,2,3,4,8,9,10,11,12,11
   */
  fun validMountainArray(A: IntArray): Boolean {
    if (A.size <= 2) {
      return false
    }
    var i = 0
    val N = A.size
    while (i + 1 < N && A[i] < A[i + 1]) {
      i++
    }
    if (i == 0 || i == N - 1) return false
    while (i + 1 < N && A[i] > A[i + 1]) {
      i++
    }
    return i == N - 1
  }

  /**
   * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
   * 26. 删除有序数组中的重复项
   * [0,0,1,1,1,2,2,3,3,4]
   * 5, nums = [0,1,2,3,4]
   */
  fun removeDuplicates(nums: IntArray): Int {
    val n = nums.size
    if (n == 0) {
      return n
    }
    var fast = 1
    var slow = 1
    while (fast < n) {
      if (nums[fast] != nums[fast - 1]) {
        nums[slow] = nums[fast]
        slow++
      }
      fast++
    }
    // println(nums.contentToString())
    return slow
  }

  /**
   * 169. 多数元素 https://leetcode-cn.com/problems/majority-element/
   */
  fun majorityElement(nums: IntArray): Int {
    // 排序
    // nums.sort()
    // return nums[nums.size / 2]

    // 统计出现次数
    // val count: List<Pair<Int, Int>> = nums.groupBy { i -> i }.map {
    //   it.key to it.value.size
    // }
    // return count.first {
    //   it.second > nums.size / 2
    // }.first

    // 摩尔投票法
    // 1 2 2 1 1 3
    var result = nums[0]
    var count = 1
    for (i in 1 until nums.size) {
      if (count == 0) {
        count++
        result = nums[i]
      } else if (nums[i] == result) {
        count++
      } else {
        count--
      }
    }
    return result
  }
}
