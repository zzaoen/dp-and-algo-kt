package com.zzaoen.algo.tree;

import com.zzaoen.algo.common.CNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 429. N 叉树的层序遍历 https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 *
 * @author Bruce Zhao
 * @date 2021/2/20 11:03
 */
public class ComplexTree {
  public static void main(String[] args) {
    ComplexTree main = new ComplexTree();

    /*
         1
      2  3  4
    */
    CNode root = new CNode(1);
    root.children = Arrays.asList(new CNode(2), new CNode(3), new CNode(4));
    main.levelOrder(root);
  }

  public List<List<Integer>> levelOrder(CNode root) {
    List<List<Integer>> result = new ArrayList<>();
    Deque<CNode> stack = new ArrayDeque<>();
    if (root == null) {
      return result;
    }
    stack.push(root);
    while (!stack.isEmpty()) {
      int len = stack.size();
      List<Integer> currentLevel = new ArrayList<>();
      for (int i = 0; i < len; i++) {
        CNode node = stack.pop();
        currentLevel.add(node.val);
        if (node.children != null) {
          stack.addAll(node.children);
        }
      }
      result.add(currentLevel);
    }
    return result;
  }
}
