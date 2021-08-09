package com.zzaoen.algo.design;

/**
 * @author Bruce Zhao
 * @date 2021/5/9 11:31
 * @desc
 */
public class DesignTest {
  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.top());
    System.out.println(minStack.getMin());
  }
}
