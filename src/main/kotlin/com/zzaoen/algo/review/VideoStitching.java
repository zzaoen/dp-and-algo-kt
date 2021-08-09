package com.zzaoen.algo.review;

import java.util.Arrays;

/*
 * Author: Bruce Zhao
 * Date: 2020/10/24 12:42
 * Desc: https://leetcode-cn.com/problems/video-stitching/
 */
public class VideoStitching {
  public static void main(String[] args) {
    VideoStitching main = new VideoStitching();
    
    int result;
    result = main.videoStitching(new int[][] {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10);
    System.out.println(result);
    //
    // result = main.videoStitching(new int[][] {{0, 2}, {4, 8}}, 5);
    // System.out.println(result);
    
    // result = main.videoStitching(new int[][] {{0, 5}, {6, 8}}, 7);
    // System.out.println(result);
    
    // result = main.videoStitching(new int[][] {{0, 1}}, 1);
    // System.out.println(result);
  }
  
  public int videoStitching(int[][] clips, int T) {
    int[] dp = new int[T + 1];
    Arrays.fill(dp, Integer.MAX_VALUE - 1);
    dp[0] = 0;
    for (int i = 1; i <= T; i++) {
      for (int[] clip : clips) {
        if (clip[0] < i && i <= clip[1]) {
          dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
        }
      }
    }
    System.out.println(Arrays.toString(dp));
    return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
  }
  
  public int videoStitchingOvertime(int[][] clips, int T) {
    int result = 0;
    
    int[] helper = new int[T + 1];
    buildHelper(clips, helper, T);
    System.out.println(Arrays.toString(helper));
    
    if (helper[T] == Integer.MAX_VALUE) {
      return -1;
    }
    
    int currentEnd = T;
    while (currentEnd > 0) {
      int value = helper[currentEnd];
      if (value == Integer.MAX_VALUE) return -1;
      // if (value == 0) return result+1;
      int temp = value;
      for (int i = value; i <= currentEnd; i++) {
        if (helper[i] < value) {
          value = helper[i];
          currentEnd = i;
        }
      }
      if (temp == helper[currentEnd]) {
        currentEnd = helper[currentEnd];
      }
      result++;
    }
    
    return result;
  }
  
  /**
   * helper size is 11, from 0 to 10, helper[10] = 8, helper[9] = 1
   *
   * @param clips
   * @param helper
   */
  public void buildHelper(int[][] clips, int[] helper, int T) {
    for (int i = 0; i < helper.length; i++) {
      helper[i] = Integer.MAX_VALUE;
    }
    
    for (int i = 0; i < clips.length; i++) {
      int end = clips[i][1];
      if (end > T) {
        helper[T] = Math.min(clips[i][0], helper[T]);
      } else {
        helper[end] = Math.min(clips[i][0], helper[end]);
      }
    }
  }
}
