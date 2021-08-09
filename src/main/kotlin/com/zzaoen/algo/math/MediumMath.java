package com.zzaoen.algo.math;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Bruce Zhao
 * @date 2021/4/1 16:53
 */
public class MediumMath {
  public static void main(String[] args) {
    MediumMath main = new MediumMath();
    System.out.println(main.clumsy(4));
  }

  /**
   * 1006. 笨阶乘 https://leetcode-cn.com/problems/clumsy-factorial/
   *
   * @param N
   * @return
   */
  public int clumsy(int N) {
    int result = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(N);
    N--;
    int operatorIndex = 0;
    while (N > 0) {
      if (operatorIndex % 4 == 0) {
        stack.push(stack.pop() * N);
      } else if (operatorIndex % 4 == 1) {
        stack.push(stack.pop() / N);
      } else if (operatorIndex % 4 == 2) {
        stack.push(N);
      } else {
        stack.push(-N);
      }
      operatorIndex++;
      N--;
    }
    while (!stack.isEmpty()) {
      result += stack.pop();
    }
    return result;
  }
}
