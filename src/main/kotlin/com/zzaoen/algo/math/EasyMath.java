package com.zzaoen.algo.math;

import java.util.HashSet;

/**
 * @author Bruce Zhao
 * @date 2021/4/11 21:02
 */
public class EasyMath {
  public static void main(String[] args) {
    EasyMath main = new EasyMath();

    // boolean ugly = main.isUgly(14);
    // System.out.println(ugly);

    boolean result = main.isHappy(2);
    System.out.println(result);
  }

  /**
   * 263. 丑数 https://leetcode-cn.com/problems/ugly-number/
   *
   * @param n
   * @return
   */
  public boolean isUgly(int n) {
    int[] factors = {2, 3, 5};
    if (n <= 0) {
      return false;
    }
    for (int factor : factors) {
      while (n % factor != 0) {
        n /= factor;
      }
    }
    return n == 1;
  }

  /**
   * 202. 快乐数
   *
   * @param n
   * @return
   */
  public boolean isHappy(int n) {
    HashSet<Integer> set = new HashSet<>();
    while (n != 1) {
      int sum = 0;
      while (n != 0) {
        int remainder = n % 10;
        n = n / 10;
        sum +=  remainder * remainder;
      }
      n = sum;
    }
    return n == 1;
  }

  /**
   * 231. 2的幂 https://leetcode-cn.com/problems/power-of-two/solution/
   *
   * @param n
   * @return
   */
  public boolean isPowerOfTwo(int n) {
    // if (n <= 0) {
    //   return false;
    // }
    // while (n % 2 == 0) {
    //   n /= 2;
    // }
    // return n == 1;

    if (n == 0) {
      return false;
    }
    long x = (long) n;
    return (x & (x - 1)) == 0; // x & (x - 1) will remove the last 1 in the binary
  }
}
