package com.zzaoen.algo.math;

/**
 * @author Bruce Zhao
 * @date 2021/4/11 21:02
 */
public class EasyMath {
  public static void main(String[] args) {
    EasyMath main = new EasyMath();

    boolean ugly = main.isUgly(14);
    System.out.println(ugly);
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
