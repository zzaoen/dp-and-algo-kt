package com.zzaoen.algo.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: Bruce Zhao
 * @date: 2020/10/22 13:06
 */
public class MediumString {
  private volatile int age = 0;

  public static void main(String[] args) {
    MediumString main = new MediumString();

    // System.out.println(main.lengthOfLongestSubstring(""));
    // System.out.println(main.lengthOfLongestSubstring("abcabcbb"));
    // System.out.println(main.lengthOfLongestSubstring("bbbbb"));
    // System.out.println(main.lengthOfLongestSubstring("pwwkew"));

    // String str = "abc";
    // System.out.println(str.indexOf('a'));
    // System.out.println(str.lastIndexOf('a'));
    // System.out.println(str.substring(0, 1));
    // str = "ababcbacadefegdehijhklij";
    // str = "abbcade";
    // List<Integer> result = main.partitionLabels(str);
    // System.out.println(result);

    // String result = main.longestCommonPrefix(new String[] {"flower", "flow", "flight"});
    // System.out.println(result);

    // 1593
    // int result = main.maxUniqueSplit("wwwzfvedwfvhsww");
    int result = main.maxUniqueSplit2("wwwzfvedwfvhsww");
    // int result = main.maxUniqueSplit("aa");
  }

  /**
   * 3. 无重复字符的最长子串 https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
   *
   * @param s
   * @return
   */
  public int lengthOfLongestSubstring(String s) {
    HashSet<Character> set = new HashSet<>();
    int length = s.length();
    int right = 0, maxLength = 0;
    for (int i = 0; i < length; i++) {
      // remove previous char, it's handled
      if (i != 0) {
        set.remove(s.charAt(i - 1));
      }

      while (right < length && !set.contains(s.charAt(right))) {
        set.add(s.charAt(right));
        right++;
      }
      maxLength = Math.max(maxLength, (right - i));
    }
    return maxLength;
  }
  /* ------------------------------------------------------------------ */

  /*
  输入：S = "ababcbacadefegdehijhklij"
  输出：[9,7,8]
  解释：
  划分结果为 "ababcbaca", "defegde", "hijhklij"。
  每个字母最多出现在一个片段中。
  像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
  */
  public List<Integer> partitionLabels(String S) {
    List<String> result = new ArrayList<>();
    int i = 0;
    char c = S.charAt(0);
    int left = S.indexOf(c), right = S.lastIndexOf(c);
    int tempLeft = 0, tempRight = 0;
    for (i = 1; i < S.length(); i++) {
      if (S.charAt(i) == S.charAt(i - 1)) {
        continue;
      }

      c = S.charAt(i);
      tempLeft = i;
      tempRight = S.lastIndexOf(c);

      if (left == right) {
        result.add(S.substring(left, right + 1));
        left = tempLeft;
        right = tempRight;
      } else {
        if (tempLeft > right) {
          result.add(S.substring(left, right + 1));
          left = tempLeft;
          right = tempRight;
        }
        if (tempRight <= right) {
          continue;
        } else if (tempRight > right) {
          right = tempRight;
        }
      }
    }
    result.add(S.substring(left, tempRight + 1));
    System.out.println(result);
    List<Integer> collect = result.stream().map(String::length).collect(Collectors.toList());
    return collect;
  }

  /**
   * 14. 最长公共前缀 https://leetcode-cn.com/problems/longest-common-prefix/
   *
   * @param strs
   * @return
   */
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
      prefix = longestCommonPrefix(prefix, strs[i]);
      if (prefix.isEmpty()) {
        return prefix;
      }
    }
    return prefix;
  }

  // "flower","flow","flight"
  private String longestCommonPrefix(String str1, String str2) {
    int len = Math.min(str1.length(), str2.length());
    int i = 0;
    for (; i < len; i++) {
      if (str1.charAt(i) != str2.charAt(i)) {
        break;
      }
    }
    return str1.substring(0, i);
  }

  /**
   * 1593. 拆分字符串使唯一子字符串的数目最大
   * https://leetcode-cn.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
   *
   * @param s ababccc
   * @return ['a', 'b', 'ab', 'c', 'cc']
   */
  public int maxUniqueSplit(String s) {
    Set<String> set = new HashSet<>();
    StringBuilder sb = new StringBuilder(s);

    while (sb.length() != 0) {
      for (int i = 1; i <= sb.length(); i++) {
        String temp = sb.substring(0, i);
        if (!set.contains(temp)) {
          set.add(temp);
          sb.delete(0, i);
          break;
        } else {
          if (i == sb.length()) {
            sb.delete(0, 1);
          }
        }
      }
    }

    return set.size();
  }

  int maxSplit = 1;
  public int maxUniqueSplit2(String s) {
    Set<String> set = new HashSet<String>();
    backtrack(0, 0, s, set);
    return maxSplit;
  }

  public void backtrack(int index, int split, String s, Set<String> set) {
    int length = s.length();
    if (index >= length) {
      maxSplit = Math.max(maxSplit, split);
    } else {
      for (int i = index; i < length; i++) {
        String substr = s.substring(index, i + 1);
        if (set.add(substr)) {
          backtrack(i + 1, split + 1, s, set);
          set.remove(substr);
        }
      }
    }
  }
}
