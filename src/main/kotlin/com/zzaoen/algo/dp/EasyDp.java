package com.zzaoen.algo.dp;

/**
 * @author Bruce Zhao
 * @date 2021/5/9 11:16
 * @desc
 */
public class EasyDp {
  public static void main(String[] args) {
    EasyDp main = new EasyDp();
    System.out.println(main.canWinNim(7));
  }

  /**
   * 292. Nim 游戏 https://leetcode-cn.com/problems/nim-game/
   *
   * @param n
   * @return
   */
  public boolean canWinNim(int n) {
    if (n <= 3) {
      return true;
    }
    int[] target = new int[n + 1];
    target[0] = 0;
    target[1] = 1;
    target[2] = 1;
    target[3] = 1;
    for (int i = 4; i <= n; i++) {
      if (target[i - 1] == 0 || target[i - 2] == 0 || target[i - 3] == 0) {
        target[i] = 1;
      } else {
        target[i] = 0;
      }
    }
    return target[n] == 1;

    // or
    // return n % 4 != 0;
  }
}
