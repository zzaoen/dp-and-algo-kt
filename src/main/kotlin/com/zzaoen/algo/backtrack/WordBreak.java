package com.zzaoen.algo.backtrack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Bruce Zhao
 * @date: 2020/11/1 11:06
 * @desc:
 */
public class WordBreak {
  
  public static void main(String[] args) {
    WordBreak main = new WordBreak();
    
    // String s = "catsanddog";
    // List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
  
    String s = "pineapplepenapple";
    List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
    // List<String> wordDict = Arrays.asList("a", "b", "c");
    main.wordBreak(s, wordDict);
  }
  
  /**
   * 输入:
   * s = "catsanddog"
   * wordDict = ["cat", "cats", "and", "sand", "dog"]
   * 输出:
   * [
   * "cats and dog",
   * "cat sand dog"
   * ]
   */
  public List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> result = new HashSet<>();
    backTrack(s, wordDict,0, result, "");
  
    System.out.println(Arrays.asList(result));
    return Collections.emptyList();
  }
  
  public void backTrack(String s, List<String> wordDict, int start, Set<String> result, String target) {
    if (target.equals(s)) {
      result.add(buildResult(wordDict, start-1));
      // System.out.println(Arrays.asList(wordDict));
    } else {
      for (int i = start; i < wordDict.size(); i++) {
        swap(wordDict, i, start);
        String temp = buildCurrentStr(wordDict, start);
        if (s.startsWith(temp)) {
          System.out.println("*****************" + temp);
          backTrack(s, wordDict, start + 1, result, temp);
          swap(wordDict, start, i);
        }
      }
    }
  }
  
  private String buildCurrentStr(List<String> wordDict, int end) {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < end; i++) {
      sb.append(wordDict.get(i));
    }
    return sb.toString();
  }
  
  private String buildResult(List<String> wordDict, int end) {
    List<String> strings = wordDict.subList(0, end);
    return strings.stream().collect(Collectors.joining(" "));
  }
  
  private void swap(List<String> wordDict, int i, int start) {
    String temp = wordDict.get(i);
    wordDict.set(i, wordDict.get(start));
    wordDict.set(start, temp);
  }
}
