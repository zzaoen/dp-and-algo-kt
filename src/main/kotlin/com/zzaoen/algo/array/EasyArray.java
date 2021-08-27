package com.zzaoen.algo.array;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author Bruce Zhao
 * @date 2020/10/8 13:19
 */
public class EasyArray {
  public static void main(String[] args) {
    EasyArray main = new EasyArray();

    // 27
    // int[] ints = {0, 1, 2, 2, 3, 0, 4, 2};
    // int length = main.removeElement(ints, 2);
    // System.out.println(length);
    // System.out.println(Arrays.toString(ints));

    // int[] ints = {2, 7, 11, 15};
    // int[] result = main.twoSum(ints, 17);
    // System.out.println(Arrays.toString(result));

    // main.reverseString("abccdds".toCharArray());

    // System.out.println(main.commonChars(new String[] {"abc", "aac", "bbc"}));
    // System.out.println(main.commonChars(new String[] {"bella","label","roller"}));

    // int[] ints1 = new int[4];

    // System.arraycopy(ints, 0, ints1, 1, 3);
    // System.out.println(Arrays.toString(ints1));
    // int[] result = main.plusOne(ints);
    // System.out.println(Arrays.toString(result));

    // int[] ints1 = {1, 2, 3, 0, 0, 0, 9};
    // int[] ints2 = {2, 5, 6, 7};
    // int[] ints1 = {1, 5, 6, 0, 0, 0};
    // int[] ints2 = {2, 3, 4};
    // main.merge(ints1, 3, ints2, 3);
    // System.out.println(Arrays.toString(ints1));

    // int[] ints = new int[] {6,5,4,8};
    // main.smallerNumbersThanCurrent(ints);

    // int[] ints = new int[] {6, 5, 4, 8};
    // int[] ints = new int[] {1, 2, 2, 1, 1, 3};
    // System.out.println(main.uniqueOccurrences(ints));

    // boolean covered = main.isCovered(new int[][] {{1, 2}, {3, 5}, {7, 8}}, 2, 6);
    // System.out.println(covered);

    // 283
    // main.moveZeroes(new int[] {0, 1, 0, 3, 12});

    // 557
    String s = main.reverseWords("Let's take LeetCode contest");
    System.out.println(s);


    // int[][] array =
    //     new int[][] {
    //       {1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}
    //     };
    int[][] array =
            new int[][] {
                    {1,0},{1,0},{1,0},{1,1},
            };
    int[] result = main.kWeakestRows(array, 4);
    System.out.println(Arrays.toString(result));
  }

  /* ------------------------------------------------------------------ */

  /**
   * 1. 两数之和 https://leetcode-cn.com/problems/two-sum/ <br>
   * nums = [2,7,11,15], target = 9, result = [0,1]
   *
   * @param nums
   * @param target
   * @return
   */
  public int[] twoSum(int[] nums, int target) {
    int[] result = new int[] {-1, -1};
    int i = 0, j;
    for (; i < nums.length; i++) {
      j = twoSumHelper(nums, i + 1, target - nums[i]);
      if (j != -1) {
        result[0] = i;
        result[1] = j;
        break;
      }
    }
    return result;
  }

  private int twoSumHelper(int[] nums, int startIndex, int target) {
    if (startIndex == nums.length) {
      return -1;
    }
    for (int i = startIndex; i < nums.length; i++) {
      if (nums[i] == target) {
        return i;
      }
    }
    return -1;
  }
  /* ------------------------------------------------------------------ */

  /**
   * 面试题 17.10. 主要元素 https://leetcode-cn.com/problems/find-majority-element-lcci/
   *
   * @param nums
   * @return
   */
  public int majorityElement(int[] nums) {
    int candidate = Integer.MIN_VALUE, count = 0, length = nums.length;
    for (int i : nums) {
      if (count == 0) {
        candidate = i;
      }
      if (candidate == i) {
        count++;
      } else {
        count--;
      }
    }
    count = 0;
    for (int i : nums) {
      if (candidate == i) {
        count++;
      }
    }
    return count * 2 > length ? candidate : -1;
  }
  /* ------------------------------------------------------------------ */

  /**
   * 27. 移除元素 https://leetcode-cn.com/problems/remove-element/ <br>
   * 输入：nums = [0,1,2,2,3,0,4,2], val = 2 <br>
   * 输出：5, nums = [0,1,4,0,3]
   *
   * @param nums
   * @param val
   * @return the length of the array after remove val
   */
  public int removeElement(int[] nums, int val) {
    int length = nums.length;
    int endIndex = length - 1;
    int startIndex = 0;
    while (startIndex <= endIndex) {
      if (nums[startIndex] != val) {
        startIndex++;
      } else {
        // swap(nums, startIndex, endIndex); // don't care about the data out of the final length
        nums[startIndex] = nums[endIndex];
        endIndex--;
        length--;
      }
    }
    return length;
  }
  /* ------------------------------------------------------------------ */

  /**
   * 88. 合并两个有序数组 https://leetcode-cn.com/problems/merge-sorted-array/ <br>
   * [1, 2, 3], [2, 5, 6]
   *
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int p = m + n - 1;
    int p1 = m - 1;
    int p2 = n - 1;
    while ((p1 >= 0) && (p2 >= 0)) {
      nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
    }
    if (p2 > 0) {
      while (p2 >= 0) {
        nums1[p--] = nums2[p2--];
      }
    }
  }

  /**
   * 283. 移动零 https://leetcode-cn.com/problems/move-zeroes/
   *
   * @param nums [0,2,0,3,12] [2,3,12,0,0]
   */
  public void moveZeroes(int[] nums) {
    int n = nums.length, left = 0, right = 0;
    while (right < n) {
      if (nums[right] != 0) {
        swap(nums, left, right);
        left++;
      }
      right++;
    }
    /*
    // right but not good
    int zeroIndex = -1;
    int currentIndex = 0;
    int len = nums.length;
    while (currentIndex != len) {
      if (nums[currentIndex] == 0) {
        if (zeroIndex == -1) {
          zeroIndex = currentIndex;
        }
        currentIndex++;
      } else {
        if (zeroIndex != -1) {
          swap(nums, currentIndex, zeroIndex);
          currentIndex = zeroIndex + 1;
          zeroIndex = -1;
        } else {
          currentIndex++;
        }
      }
    }*/
  }

  /**
   * 1893. 检查是否区域内所有整数都被覆盖
   * https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/
   *
   * @param ranges [[1,2],[3,4],[5,6]]
   * @param left 2
   * @param right 5
   * @return true
   */
  public boolean isCovered(int[][] ranges, int left, int right) {
    int[] flags = new int[52];
    for (int[] range : ranges) {
      for (int j = range[0]; j <= range[1]; j++) {
        flags[j] = 1;
      }
    }

    for (int i = left; i <= right; i++) {
      if (flags[i] == 0) {
        return false;
      }
    }
    return true;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private void swap(int[] nums1, int i, int[] nums2, int j) {
    int temp = nums1[i];
    nums1[i] = nums2[j];
    nums2[j] = temp;
  }

  /* ------------------------------------------------------------------ */

  public int[] plusOne(int[] digits) {
    int adv = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      int temp = digits[i] + adv;
      if (temp >= 10) {
        temp = temp -= 10;
        adv = 1;
      } else {
        adv = 0;
      }
      digits[i] = temp;
    }
    if (adv == 1) {
      int[] result = new int[digits.length + 1];
      System.arraycopy(digits, 0, result, 1, digits.length);
      result[0] = 1;
      return result;
    } else {
      return digits;
    }
  }

  // 1002
  public List<String> commonChars(String[] A) {
    List<String> result = new ArrayList<>();
    if (A == null || A.length <= 1) {
      return result;
    }

    HashMap<Character, Integer> targetMap = new HashMap<>();
    for (char c : A[0].toCharArray()) {
      Integer value = targetMap.get(c);
      if (targetMap.get(c) == null) {
        targetMap.put(c, 1);
      } else {
        targetMap.put(c, value + 1);
      }
    }

    HashMap<Character, Integer> tempMap = new HashMap<>();

    for (int i = 1; i < A.length; i++) {
      String item = A[i];
      char[] chars = item.toCharArray();
      for (char c : chars) {
        Integer value = tempMap.get(c);
        if (tempMap.get(c) == null) {
          tempMap.put(c, 1);
        } else {
          tempMap.put(c, value + 1);
        }
      }
      List<Character> keysList = new ArrayList<>();
      targetMap.keySet().forEach(keysList::add);
      for (char c : keysList) {
        if (tempMap.get(c) == null) {
          targetMap.remove(c);
          // targetMap.put(c, 0);
        } else {
          targetMap.put(c, Math.min(targetMap.get(c), tempMap.get(c)));
        }
      }
      tempMap.clear();
    }

    // targetMap to result;
    for (char c : targetMap.keySet()) {
      Integer value = targetMap.get(c);
      if (value != null) {
        for (int i = 0; i < value; i++) {
          result.add(c + "");
        }
      }
    }
    return result;
  }

  /**
   * 344. 反转字符串 https://leetcode-cn.com/problems/reverse-string/
   * [a,b,c,d]
   * tmp = d
   * a =
   * @param s
   */
  public void reverseString(char[] s) {
    if (s.length <= 1) return;
    int len = s.length;
    for (int i = 0; i < len / 2; i++) {
      char tmp = s[i];
      s[i] = s[len - i - 1];
      s[len - i - 1] = tmp;
    }
    // System.out.println(s);
  }


  /**
   * 541. 反转字符串 II https://leetcode-cn.com/problems/reverse-string-ii/
   * @param s
   * @param k
   * @return
   */
  public String reverseStr(String s, int k) {
    return null;
  }

  /**
   * 557. 反转字符串中的单词 III https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
   *
   * @param s
   * @return
   */
  public String reverseWords(String s) {
    String[] strArray = s.split(" ");
    StringBuilder sb = new StringBuilder();
    for (String str : strArray) {
      char[] chars = str.toCharArray();
      reverseString(chars);
      sb.append(chars).append(" ");
    }
    return sb.substring(0, sb.length()-1);
  }

  /* ------------------------------------------------------------------ */

  /**
   * 1337. 矩阵中战斗力最弱的 K 行 https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/
   * @param mat
   * @param k
   * @return
   */
  public int[] kWeakestRows(int[][] mat, int k) {
    int[] result = new int[k];
    Map<Integer, List<Integer>> map = new HashMap<>(mat.length);
    Set<Integer> sumSet = new HashSet<>();
    for (int i = 0; i < mat.length; i++) {
      int sum = 0;
      for (int j = 0; j < mat[i].length; j++) {
        sum += mat[i][j];
      }
      map.putIfAbsent(sum, new ArrayList<>());
      map.get(sum).add(i);
      sumSet.add(sum);
    }
    ArrayList<Integer> integers = new ArrayList<>(sumSet);
    Collections.sort(integers);

    int index = 0;
    for (int a : integers) {
      List<Integer> integers1 = map.get(a);
      for (int b : integers1) {
        if (index == k) {
          break;
        }
        result[index++] = b;
      }
    }
    return result;
    /*int[] result = new int[k];
    int index = 0;
    boolean[] markedRow = new boolean[mat.length];
    for (int i = 0; i < mat[0].length && index < k; i++) { // col
      for (int j = 0; j < mat.length; j++) { // row
        if (mat[j][i] == 0 && !markedRow[j]) {
          result[index++] = j;
          markedRow[j] = true;
        }
        if (index == k) {
          break;
        }
      }
    }

    return result;*/
  }

  // 8, 1, 2, 2, 2, 3
  public int[] smallerNumbersThanCurrent(int[] nums) {
    int[] ints = Arrays.copyOf(nums, nums.length);
    Arrays.sort(ints);

    int[] count = new int[ints.length];
    for (int i = 1; i < ints.length; i++) {
      if (ints[i] == ints[i - 1]) {
        count[i] = count[i - 1];
      } else {
        count[i] = i;
      }
    }
    // System.out.println(Arrays.toString(count)); // 0, 1, 1, 1, 4, 5

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < ints.length; i++) {
      map.putIfAbsent(ints[i], count[i]);
    }

    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      result[i] = map.get(nums[i]);
    }
    // System.out.println(Arrays.toString(result));

    return result;
  }

  // [1,2,2,1,1,3]
  public boolean uniqueOccurrences(int[] arr) {
    HashMap<Integer, Integer> countMap = new HashMap<>();
    for (int i : arr) {
      if (!countMap.containsKey(i)) {
        countMap.put(i, 1);
      } else {
        countMap.put(i, countMap.get(i) + 1);
      }
    }

    HashSet<Integer> checkMap = new HashSet<>();
    for (int key : countMap.keySet()) {
      if (checkMap.contains(countMap.get(key))) {
        return false;
      } else {
        checkMap.add(countMap.get(key));
      }
    }
    return true;
  }

  /**
   * https://leetcode-cn.com/problems/insert-interval/
   *
   * @param intervals [[1,2],[3,5],[6,7],[8,10],[12,16]]
   * @param newInterval [4,8]
   * @return [[1,2],[3,10],[12,16]]
   */
  public int[][] insert(int[][] intervals, int[] newInterval) {
    ArrayList<int[]> resultList = new ArrayList<>();

    int left = newInterval[0];
    int right = newInterval[1];

    for (int i = 0; i < intervals.length; i++) {
      int[] cur = intervals[i];
      int curLeft = intervals[i][0];
      int curRight = intervals[i][1];

      if (curRight < right) {
        resultList.add(cur);
      } else if (curRight <= right) {
        for (int j = i + 1; j < intervals.length; j++) {
          if (right > intervals[j][1]) {
            continue;
          }
        }
      }
    }

    int size = resultList.size();
    int[][] result = new int[size][2];
    for (int i = 0; i < size; i++) {
      result[i] = resultList.get(i);
    }
    return result;
  }
}
