package com.zzaoen.algo.review;

import java.util.Arrays;

/*
 * Author: Bruce Zhao
 * Date: 2020/10/25 10:25
 * Desc: https://leetcode-cn.com/problems/longest-mountain-in-array/solution/shu-zu-zhong-de-zui-chang-shan-mai-by-leetcode-sol/
 */
public class LongestMountain {
  public static void main(String[] args) {
    LongestMountain main = new LongestMountain();
    int[] array = new int[] {2, 1, 4, 7, 3, 2, 5};
    System.out.println(main.longestMountain(array));

    int[] array2 = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    main.trap(array2);
  }

  public int longestMountain(int[] A) {
    if (A.length <= 2) return 0;

    int[] left = new int[A.length];
    for (int i = 1; i < A.length; i++) {
      if (A[i] > A[i - 1]) {
        left[i] = left[i - 1] + 1;
      }
    }

    int[] right = new int[A.length];
    for (int i = A.length - 2; i >= 0; i--) {
      if (A[i] > A[i + 1]) {
        right[i] = right[i + 1] + 1;
      }
    }

    int ans = 0;
    for (int i = 0; i < A.length; i++) {
      if (left[i] > 0 && right[i] > 0) {
        ans = Math.max(ans, left[i] + right[i] + 1);
      }
    }
    return ans;
  }

  /**
   * https://leetcode-cn.com/problems/trapping-rain-water/ <br>
   * 0,1,0,2,1,0,1,3,2,1,2,1
   *
   * @param height
   * @return
   */
  public int trap(int[] height) {
    if (height == null || height.length == 0)
      return 0;
    int len = height.length;

    int[] left = new int[len];
    left[0] = height[0];
    // 得到每个点左侧可以达到的最高点
    for (int i = 1; i < len; i++) {
      left[i] = Math.max(height[i], left[i - 1]);
    }

    int[] right = new int[len];
    right[len - 1] = height[len - 1];
    // 得到每个点左侧可以达到的最高点
    for (int i = len - 2; i >= 0; i--) {
      right[i] = Math.max(height[i], right[i + 1]);
    }
  
    int ans = 0;
    for (int i = 1; i < len; i++) {
      ans += Math.min(left[i], right[i]) - height[i];
    }
    return ans;
  }
}
