package com.zzaoen.algo.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Bruce Zhao
 * @date 2021/2/20 15:26
 */
public class WorkBreak {
  public static void main(String[] args) {
    WorkBreak main = new WorkBreak();
    // boolean b = main.wordBreak("leetcodeapplecode", Arrays.asList("leet", "code", "apple"));
    // System.out.println(b);
  }
  /**
   * s = "leetcodeapplecode", wordDict = ["leet", "code", "apple"]
   * 139,
   * @param s
   * @param wordDict
   * @return
   */
  public boolean wordBreak(String s, List<String> wordDict) {
    HashSet<String> set = new HashSet<>(wordDict);
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && set.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }
}
