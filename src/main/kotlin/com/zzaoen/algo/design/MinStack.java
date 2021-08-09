package com.zzaoen.algo.design;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Bruce Zhao
 * @date 2021/5/9 11:31
 * @desc 155. 最小栈 https://leetcode-cn.com/problems/min-stack/solution/
 */
public class MinStack {

  private final Deque<Integer> stack;
  private final Deque<Integer> minStack;
  /** initialize your data structure here. */
  public MinStack() {
    stack = new ArrayDeque<>();
    minStack = new ArrayDeque<>();
  }

  public void push(int val) {
    stack.push(val);
    if (minStack.isEmpty()) {
      minStack.push(val);
    } else {
      Integer currentMin = minStack.peek();
      if (val > currentMin) {
        minStack.push(currentMin);
      } else {
        minStack.push(val);
      }
    }
  }

  public void pop() {
    stack.pop();
    minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}
