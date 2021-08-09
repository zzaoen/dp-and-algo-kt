package com.zzaoen.algo.string;

import java.util.*;

/** Author: Bruce Zhao Date: 2020/10/28 20:47 Desc: */
public class EasyString {
  public static void main(String[] args) {
    EasyString main = new EasyString();

    // int result = main.romanToInt("LVIII");
    // System.out.println(result);

    boolean result = main.isValid("([)]");
    System.out.println(result);

    // main.isPalindrome(121);

    // main.CheckPermutation("abc", "bac");
    // main.compress("aabcccccaaa");

    // String result = main.replaceSpaces("               ", 5);
    // System.out.println(result);

  }

  /**
   * 13. 罗马数字转整数 https://leetcode-cn.com/problems/roman-to-integer/
   *
   * @param s
   * @return
   */
  public int romanToInt(String s) {
    int result = 0;
    if (s == null || s.length() == 0) {
      return result;
    }
    Map<String, Integer> romanToIntMap =
        new HashMap<String, Integer>(12) {
          {
            put("I", 1);
            put("IV", 4);
            put("V", 5);
            put("IX", 9);
            put("X", 10);
            put("XL", 40);
            put("L", 50);
            put("XC", 90);
            put("C", 100);
            put("CD", 400);
            put("D", 500);
            put("CM", 900);
            put("M", 1000);
          }
        };
    int len = s.length();
    for (int i = 0; i < len; ) {
      if (i < len - 1 && romanToIntMap.containsKey(s.substring(i, i + 2))) {
        result += romanToIntMap.get(s.substring(i, i + 2));
        i += 2;
      } else {
        result += romanToIntMap.get(s.substring(i, i + 1));
        i++;
      }
    }
    return result;
  }

  /*** 每个字符和其后面一个字符比较,比如MCM,第一个M后面是C,那个M是正值.C后面是M,C变成负值 */
  public int romanToIntOfficial(String s) {
    Map<Character, Integer> symbolValues =
        new HashMap<Character, Integer>() {
          {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
          }
        };
    int result = 0;
    int len = s.length();
    for (int i = 0; i < len; i++) {
      int currentValue = symbolValues.get(s.charAt(i));
      if (i < len - 1 && currentValue < symbolValues.get(s.charAt(i + 1))) {
        result -= currentValue;
      } else {
        result += currentValue;
      }
    }
    return result;
  }

  /* ------------------------------------------------------------------ */

  /**
   * 20. 有效的括号 https://leetcode-cn.com/problems/valid-parentheses/
   *
   * @param s
   * @return
   */
  public boolean isValid(String s) {
    if (s.length() <= 1) {
      return false;
    }
    Map<Character, Character> map =
        new HashMap<Character, Character>() {
          {
            put(')', '(');
            put(']', '[');
            put('}', '{');
          }
        };
    Set<Character> set =
        new HashSet<Character>() {
          {
            add('(');
            add('[');
            add('{');
          }
        };
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      if (set.contains(c)) {
        stack.push(c);
      } else {
        if (stack.isEmpty() || !stack.poll().equals(map.get(c))) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  /* ------------------------------------------------------------------ */

  public boolean isPalindrome(int x) {
    if (x < 0 || (x != 0 && x % 10 == 0)) {
      return false;
    }
    int revertedNumber = 0;
    while (x > revertedNumber) {
      int remainder = x % 10;
      revertedNumber = revertedNumber * 10 + remainder;
      x = x / 10;
    }
    System.out.println(revertedNumber + " " + x);
    return (x == revertedNumber || x == revertedNumber / 10);
  }

  public boolean CheckPermutation(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
    int[] index = new int[128];
    for (int i = 0; i < s1.length(); i++) {
      index[s1.charAt(i)]++;
      index[s2.charAt(i)]--;
    }
    for (int i = 0; i < 128; i++) {
      if (index[i] != 0) return false;
    }
    return true;
  }

  /* --------------------------------------------------- */
  /** a a aa a2 ab a1b1 aabbb aabcccccaaa a2b1c5a3 213 */
  public String compress(String originalString) {
    // write your code here
    if (originalString.length() <= 4) {
      return originalString;
    }
    StringBuilder result = new StringBuilder();
    char[] chars = originalString.toCharArray();
    int currentIndex = 0;
    char currentChar = chars[0];
    for (int i = 1; i < chars.length; i++) {
      if (chars[i] != currentChar) {
        result.append(currentChar).append(i - currentIndex);
        currentChar = chars[i];
        currentIndex = i;
      } else {
        continue;
      }
    }
    result.append(currentChar).append(originalString.length() - currentIndex);
    // System.out.println(result.toString());
    return result.length() >= originalString.length() ? originalString : result.toString();
  }

  /**
   * 面试题 01.03. URL化 https://leetcode-cn.com/problems/string-to-url-lcci/
   *
   * @param S
   * @param length
   * @return
   */
  public String replaceSpaces(String S, int length) {
    char[] chars = S.toCharArray();
    StringBuilder sb = new StringBuilder();
    String space = "%20";
    for (int i = 0; i < length; i++) {
      if (chars[i] == ' ') {
        sb.append(space);
      } else {
        sb.append(chars[i]);
      }
    }
    return sb.toString();
  }

  public boolean canPermutePalindrome(String s) {
    int[] charCounter = new int[128];
    char[] chars = s.toCharArray();
    for (char c : chars) {
      charCounter[c]++;
    }
    int oddNumber = 0;
    for (int i = 0; i < charCounter.length; i++) {
      // if (charCounter[i] % 2 == 1) {
      //   oddNumber++;
      // }
      oddNumber += charCounter[i] & 1;
    }
    return oddNumber <= 1;
  }
}
