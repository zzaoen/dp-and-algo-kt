package com.zzaoen.algo.match;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Bruce Zhao
 * @date 2021/2/20 12:28
 */
public class NewsBreak {
  public static void main(String[] args) {
    NewsBreak main = new NewsBreak();
    int i = main.longestValidParentheses(")()())()()()(");
    System.out.println(i);
  }

  /**
   * (()(()   )()())    )()())()()((()()
   * @param s
   * @return
   */
  public int longestValidParentheses(String s) {
    // write your code here
    int result = 0;
    Deque<Integer> stack = new LinkedList<Integer>();
    stack.push(-1);
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          result = Math.max(result, i - stack.peek());
        }
      }
    }
    return result;
  }
}
