package com.zzaoen.algo.backtrack;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author: Bruce Zhao
 * @date: 2020/10/17 20:29
 * @desc:
 */
public class Permutation {
  public static void main(String[] args) {
    new Permutation().permutation("abc");
  }
  
  public String[] permutation(String s) {
    if (s == null || s.isEmpty()) {
      return new String[0];
    }
    char[] chars = s.toCharArray();
    ArrayList resultList = new ArrayList<String>();
    
    backtrack(resultList, chars, 0);
    System.out.println(resultList);

    String[] resultArray = new String[resultList.size()];

    resultList.toArray(resultArray);
    return resultArray;
  }
  
  public void backtrack(ArrayList<String> resultList, char[] chars, int start) {
    if (start == chars.length - 1) {
      resultList.add(String.valueOf(chars));
    } else {
      HashSet<Character> set = new HashSet<>();
      for (int i = start; i < chars.length; i++) {
        if (set.contains(chars[i])) { // 重复，因此剪枝
          continue;
        }
        set.add(chars[i]);
        
        swap(chars, i, start);
        
        backtrack(resultList, chars, start + 1);
        
        swap(chars, start, i);
      }
    }
  }
  
  public void swap(char[] chars, int i, int j) {
    char temp = chars[i];
    chars[i] = chars[j];
    chars[j] = temp;
  }
}
