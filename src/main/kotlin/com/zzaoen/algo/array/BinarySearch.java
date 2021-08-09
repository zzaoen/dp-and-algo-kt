package com.zzaoen.algo.array;

import java.util.*;

/**
 * @author Bruce Zhao
 * @date 2021/7/4 13:04
 *     https://leetcode-cn.com/problemset/all/?search=%E5%85%88%E5%BA%8F%E9%81%8D%E5%8E%86
 */
public class BinarySearch {
  public static void main(String[] args) {
    BinarySearch main = new BinarySearch();

    // 704
    // int result = main.search(new int[] {-1, 0, 3, 5, 9, 12}, 9);
    // System.out.println(result);

    // System.out.println(main.leftBoundBinarySearch(new int[]{2, 2, 3, 4, 4, 5}, 8));
    // System.out.println(main.leftBoundBinarySearch(new int[] {1}, 1));

    // 34
    // int[] result = main.searchRange(new int[]{5, 7, 7, 7, 8, 8, 10}, 8);
    // System.out.println(Arrays.toString(result));
    // main.findRightIndex(new int[] {5, 7, 7, 8, 8, 10}, 8);

    // 35
    // int result = main.searchInsert(new int[] {1, 5, 5, 5, 6}, 5);
    // System.out.println(result);

    // 278
    // int result = main.firstBadVersion(20);
    // System.out.println(result);
  }

  /**
   * 704. 二分查找 https://leetcode-cn.com/problems/binary-search/
   *
   * @param nums
   * @param target
   * @return
   */
  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      // int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }

  /**
   * 633. 平方数之和 https://leetcode-cn.com/problems/sum-of-square-numbers/
   *
   * @param c
   * @return
   */
  public boolean judgeSquareSum(int c) {
    int left = 0, right = (int) Math.sqrt(c);
    while (left <= right) {
      int sum = left * left + right * right;
      if (sum == c) {
        return true;
      } else if (sum < c) {
        left++;
      } else {
        right--;
      }
    }
    return false;
  }

  /**
   * 34. 在排序数组中查找元素的第一个和最后一个位置
   * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
   *
   * @param nums
   * @param target
   * @return
   */
  public int[] searchRange(int[] nums, int target) {
    if (nums.length == 0) {
      return new int[] {-1, -1};
    }
    int leftIndex = findLeftIndex(nums, target);
    if (leftIndex == -1) {
      return new int[] {-1, -1};
    }
    int rightIndex = findRightIndex(nums, target);
    return new int[] {leftIndex, rightIndex};
  }

  private int findRightIndex(int[] nums, int target) {
    int len = nums.length, left = 0, right = len - 1;
    while (left < right) {
      // 如果是偶数个数字的话，得到的是right mid，向上取中值
      int mid = left + (right - left + 1) / 2;
      if (nums[mid] < target) {
        // mid can't be, [mid+1, right]
        left = mid + 1;
      } else if (nums[mid] == target) {
        // can't make sure mid is the right bound
        // [mid, right]
        left = mid;
      } else {
        // nums[mid] > target
        // [left, mid-1]
        right = mid - 1;
      }
      // System.out.println("left: " + left + ", right: " + right);
    }
    // needn't to check because leftBound exist
    /*if (nums[left] == target) {
      return left;
    }*/
    return left;
  }

  private int findLeftIndex(int[] nums, int target) {
    int len = nums.length, left = 0, right = len - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      // if (nums[mid] < target) {
      //   left = mid + 1;
      // } else {
      //   right = mid;
      // }
      if (nums[mid] < target) {
        // mid can't be, [mid+1, right]
        left = mid + 1;
      } else if (nums[mid] == target) {
        // mid can be, [left, mid]
        right = mid;
      } else {
        // nums[mid] > target
        // [left, mid-1]
        right = mid - 1;
      }
    }
    if (nums[left] == target) {
      return left;
    }
    return -1;
  }

  /**
   * 35. 搜索插入位置 https://leetcode-cn.com/problems/search-insert-position/ find the first one >=
   * target 目的是找到第一个大于等于target的位置，如果nums[mid]<target，那么目标一定在[mid+1, right]这个区间，优先判断这个条件
   *
   * @param nums [1,3,5,6]
   * @param target 5
   * @return 2
   */
  public int searchInsert(int[] nums, int target) {
    int length = nums.length;
    int left = 0, right = length - 1;
    int mid;
    while (left < right) {
      mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        // [mid, right]
        left = mid + 1;
      } else if (nums[mid] == target) {
        // look for left bound
        // [left, mid]
        right = mid;
      } else {
        // nums[mid] > target
        // [left, mid -1]
        right = mid;
      }
    }
    return left;

    // int length = nums.length;
    // if (nums[length - 1] < target) return length;
    // int left = 0, right = length - 1;
    // int mid;
    // while (left < right) {
    //   mid = left + (right - left) / 2;
    //   if (nums[mid] < target) {
    //     left = mid + 1;
    //   } else {
    //     right = mid;
    //   }
    // }
    // return left;
  }

  /**
   * 278. 第一个错误的版本 https://leetcode-cn.com/problems/first-bad-version/ good good good good bad bad
   * bad find the left bound of "bad"
   *
   * @param n
   * @return
   */
  public int firstBadVersion(int n) {
    int left = 1, right = n;
    int mid;
    while (left < right) {
      mid = left + (right - left) / 2;
      if (!isBadVersion(mid)) {
        // mid is good, bad in [mid+1, right]
        left = mid + 1;
      } else {
        // mid is bad, bad in [left, mid]
        right = mid;
      }
    }
    return left;
  }

  boolean isBadVersion(int version) {
    return version >= 13;
  }
}
