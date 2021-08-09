package com.zzaoen.algo.stackqueue

import java.lang.RuntimeException
import java.util.Stack

/* 
 * Author: Bruce Zhao
 * Date: 2020/8/29 12:40
 * Desc: 
 */
class C1 {
  var stackData: Stack<Int> = Stack()
  var stackMin: Stack<Int> = Stack()

  fun push(t: Int) {
    if (stackMin.isEmpty()) {
      stackData.push(t)
      stackMin.push(t)
    } else {
      val pop = stackMin.peek()
      if (t < pop) {
        stackMin.push(t)
      } else {
        stackMin.push(pop)
      }
      stackData.push(t)
    }
  }

  fun pop(): Int {
    if (stackData.isNotEmpty()) {
      stackMin.pop()
      return stackData.pop()
    } else {
      throw RuntimeException("Empty stack")
    }
  }

  fun getMin(): Int {
    return stackMin.peek()
  }
}

fun main() {
  val c1 = C1()
  c1.push(4)
  c1.push(5)
  c1.push(3)
  c1.push(1)
  c1.push(6)

  println(c1.getMin()) // 1

  println(c1.pop()) // 6
  println(c1.getMin()) // 1

  println(c1.pop()) // 1
  println(c1.getMin()) // 3

  println(c1.pop()) // 3
  println(c1.getMin()) // 4

  println(c1.pop()) // 5
  println(c1.pop()) // 4
  println(c1.pop()) // Error
}
