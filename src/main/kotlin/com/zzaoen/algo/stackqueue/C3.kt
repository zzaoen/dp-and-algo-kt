package com.zzaoen.algo.stackqueue

import java.util.Stack

/*
 * Author: Bruce Zhao
 * Date: 2020/8/29 15:54
 * Desc: 
 */
class C3

fun main() {
  val stack = Stack<Int>()
  stack.addAll(listOf(1, 2, 3))

  println(stack)
  // stack.reverse()
  // println(stack)

  reverse(stack)
  println(stack)
}

fun getAndRemoveLastItem(stack: Stack<Int>): Int {
  val value = stack.pop()
  if (stack.isEmpty()) {
    return value
  } else {
    val i = getAndRemoveLastItem(stack)
    stack.push(value)
    return i
  }
}

fun reverse(stack: Stack<Int>) {
  if (stack.isEmpty())
    return
  val i = getAndRemoveLastItem(stack)
  reverse(stack)
  stack.push(i)
}
