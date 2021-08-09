package com.zzaoen.algo.review;

import java.util.Arrays;

/*
 * Author: Bruce Zhao
 * Date: 2020/10/11 11:32
 * Desc: 分割等和子集 https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
public class CanPartition {
  public static void main(String[] args) {
    //
    CanPartition canPartition = new CanPartition();
    boolean b = canPartition.canPartition(new int[] {1, 2, 3, 6});
    System.out.println(b);
  }
  
  public boolean canPartition(int[] nums) {
    int sum = Arrays.stream(nums).reduce((a, b) -> a + b).getAsInt();
    int n = nums.length;
    if (n < 2) {
      return false;
    }
    if (sum % 2 != 0) return false;
    int target = sum / 2;
    boolean[][] dp = new boolean[n][target + 1];

    // base case
    for (int i = 0; i < n; i++) {
      dp[i][0] = true;
    }
    // dp[0][nums[0]] = true;
    if (nums[0] <= target) {
      dp[0][nums[0]] = true;
    }

    // 问题转变为求和， 数组1，2，3，6，target是6
    for (int i = 1; i < n; i++) {
      int num = nums[i];
      for (int j = 0; j <= target; j++) {
        if (j >= num) {
          dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    // printArray(dp);
    return dp[n - 1][target];
  }

  void printArray(boolean[][] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[0].length; j++) {
        System.out.print(array[i][j] + " ");
      }
      System.out.println();
    }
  }
}
