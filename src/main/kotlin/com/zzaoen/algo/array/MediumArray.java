package com.zzaoen.algo.array;

import java.util.*;

/**
 * @author Bruce Zhao
 * @date 2020/10/24 09:08
 */
public class MediumArray {
  public static void main(String[] args) {
    MediumArray main = new MediumArray();

    // int[][] matrix =
    //     new int[][] {
    //       {0, 1, 2, 0},
    //       {3, 4, 5, 2},
    //       {1, 3, 1, 5}
    //     };
    // main.setZeroes(matrix);
    // System.out.println(Arrays.deepToString(matrix));

    // int result =
    //     main.evalRPN(
    //         new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
    // System.out.println(result);


    // 189
    // main.rotate(new int[] {1,2,3,4,5,6,7}, 0);
    main.rotate2(new int[] {1,2,3,4,5,6,7}, 3);
  }

  /**
   * 73. 矩阵置零 https://leetcode-cn.com/problems/set-matrix-zeroes/
   *
   * @param matrix
   */
  public void setZeroes(int[][] matrix) {
    List<Integer> targetArray = new ArrayList();
    int row = matrix.length;
    int col = matrix[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (matrix[i][j] == 0) {
          targetArray.add(i);
          targetArray.add(j);
        }
      }
    }
    if (targetArray.isEmpty()) {
      return;
    }
    for (int i = 0; i < targetArray.size(); i++) {
      int targetRow = targetArray.get(i);
      int targetCol = targetArray.get(++i);
      setZero(matrix, targetRow, targetCol);
    }
  }

  /*
    [
    [0,1,2,0],
    [3,4,5,2],
    [1,3,1,5]
    ]
  */
  private void setZero(int[][] matrix, int targetRow, int targetCol) {
    int row = matrix.length;
    int col = matrix[0].length;
    for (int i = 0; i < col; i++) {
      matrix[targetRow][i] = 0;
    }
    for (int j = 0; j < row; j++) {
      matrix[j][targetCol] = 0;
    }
  }

  /**
   * 150. 逆波兰表达式求值 https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
   *
   * @param tokens
   * @return
   */
  public int evalRPN(String[] tokens) {
    if (tokens.length == 0) {
      return 0;
    }
    Deque<Integer> numberStack = new ArrayDeque<>();
    for (String token : tokens) {
      if (isNumber(token)) {
        numberStack.push(Integer.parseInt(token));
      } else {
        int num2 = numberStack.pop();
        int num1 = numberStack.pop();
        switch (token) {
          case "+":
            numberStack.push(num1 + num2);
            break;
          case "-":
            numberStack.push(num1 - num2);
            break;
          case "*":
            numberStack.push(num1 * num2);
            break;
          case "/":
            numberStack.push(num1 / num2);
            break;
          default:
        }
      }
    }
    return numberStack.pop();
  }

  /**
   * 189. 旋转数组 https://leetcode-cn.com/problems/rotate-array/
   * @param nums [1,2,3,4,5,6,7]
   * @param k 3 [5,6,7,1,2,3,4]
   */
  public void rotate(int[] nums, int k) {
    int len = nums.length;
    if (k >= len) {
      k = k % len;
    }
    // 5,6,7
    int[] moved = Arrays.copyOfRange(nums, len-k, len);
    System.arraycopy(nums, 0, nums, k, len-k);
    System.arraycopy(moved, 0, nums, 0, k);
  }

  // 做两次rotate,
  // 1,2,3,4,5,6,7
  // 7,6,5,4,3,2,1
  // 5,6,7, 1,2,3,4
  public void rotate2(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length-1);
    reverse(nums, 0, k-1);
    reverse(nums, k, nums.length-1);
  }

  private void reverse(int[] nums, int startIndexInclusive, int endIndexInclusive) {
    int temp;
    while (startIndexInclusive <= endIndexInclusive) {
      temp = nums[startIndexInclusive];
      nums[startIndexInclusive] = nums[endIndexInclusive];
      nums[endIndexInclusive] = temp;
      startIndexInclusive++;
      endIndexInclusive--;
    }
  }

  public boolean isNumber(String token) {
    return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
  }
}
