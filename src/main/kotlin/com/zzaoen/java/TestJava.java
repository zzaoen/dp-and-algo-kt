package com.zzaoen.java;

import com.zzaoen.java.enums.CurrencyEnum;

import java.nio.file.Files;
import java.util.*;

/*
 * Author: Bruce Zhao
 * Date: 2020/6/4 17:10
 * Desc:
 */
public class TestJava {
  int y;
  Integer yy;

  public static void main(String[] args) {
    // String name = "zz";
    // System.out.println(name);
    // changeName(name);
    // System.out.println(name);
    Collections.emptyList();

    TestJava tj = new TestJava();
  
    // int[] arr = new int[] {2, 0, 2, 1, 1, 0};
    // int[] arr = new int[] {1, 0, 0};
    // tj.sortColors(arr);
    // System.out.println(Arrays.toString(arr));
    // tj.printY();
    
    // EnumSet<CurrencyEnum> test = EnumSet.allOf(CurrencyEnum.class);
   
    
    // Map<String, String> map = new HashMap<>();
    // map.keySet();
    
    int a = 0;
    int b = (a = 100);
    System.out.println("a = 0" + (a=1) + "." + b);
  }

  private static void changeName(String name) {
    name = "zzz";
    System.out.println(name);
  }

  private void printY() {
    // System.out.println(y);
  }

  public void sortColors(int[] nums) {
    int zeroIndex = 0;
    int twoIndex = nums.length;

    int i = 0;
    while(i <= twoIndex) {
      // if (i == twoIndex) break;
      if (nums[i] == 2) {
        swap(nums, i, twoIndex);
        twoIndex -= 1;
      } else if (nums[i] == 1) {
        i++;
      } else if (nums[i] == 0) {
        swap(nums, i, zeroIndex);
        zeroIndex++;
        i++;
      }
    }
  }

  public void swap(int[] nums, int index1, int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TestJava testJava = (TestJava) o;
    return y == testJava.y && Objects.equals(yy, testJava.yy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(y, yy);
  }
}
