package com.zzaoen.algo.stackqueue

import java.util.Stack

/*
 * Author: Bruce Zhao
 * Date: 2020/8/29 15:18
 * Desc: 
 */
class C2<T> {
  val stackIn: Stack<T> = Stack()
  val stackOut: Stack<T> = Stack()

  fun add(t: T) {
    stackIn.push(t)
  }

  fun poll(): T {
    /*if (stackIn.isEmpty() && stackOut.isEmpty())
      throw RuntimeException("Empty queue")
    if (stackOut.isEmpty()) {
      while (stackIn.isNotEmpty()) {
        stackOut.add(stackIn.pop())
      }
    }
    return stackOut.pop()*/
    return pollOrPeek {
      stackOut.pop()
    }
  }

  fun peek(): T {
    return pollOrPeek {
      stackOut.peek()
    }
  }

  inline fun pollOrPeek(block: () -> T): T {
    if (stackIn.isEmpty() && stackOut.isEmpty())
      throw RuntimeException("Empty queue")
    if (stackOut.isEmpty()) {
      while (stackIn.isNotEmpty()) {
        stackOut.add(stackIn.pop())
      }
    }
    return block()
  }
}

fun main() {
  val c2 = C2<Int>()
  c2.add(4)
  c2.add(5)
  c2.add(3)

  println(c2.poll()) // 4

  c2.add(6)
  println(c2.poll()) // 5
  println(c2.poll()) // 3
  println(c2.poll()) // 6
  // println(c2.poll()) //Error

  c2.add(1)
  println(c2.peek()) // 1
  println(c2.poll()) // 1
  println(c2.poll()) // Error
}
