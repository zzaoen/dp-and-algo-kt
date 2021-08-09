package com.zzaoen.algo.tree;

import com.zzaoen.algo.common.TreeNode;

import java.util.*;

/** @Author: Bruce Zhao @Date: 2020/10/15 13:52 */
public class IterativeTree {
  private static List list = new ArrayList<TreeNode>();

  public static void main(String[] args) {
    IterativeTree it = new IterativeTree();
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> levelList = new ArrayList<>();
    Deque<TreeNode> queue = new ArrayDeque<>();
    if (root == null) {
      return list;
    }
    queue.add(root);
    TreeNode thisLevelLastNode = root;
    while (!queue.isEmpty()) {
      TreeNode node = queue.removeFirst();
      levelList.add(node.getVal());
      if (node.getLeft() != null) {
        queue.add(node.getLeft());
      }
      if (node.getRight() != null) {
        queue.add(node.getRight());
      }
      if (node == thisLevelLastNode) {
        list.add(levelList);
        levelList = new ArrayList<>();
        if (!queue.isEmpty()) {
          thisLevelLastNode = queue.getLast();
        }
      }
    }
    return list;
  }

  /**
   * 上一个解法用了一个Node来标识一个level的结束，也可以通过判断一个level节点的数量
   *
   * @param root
   * @return
   */
  public List<List<Integer>> levelOrder2(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    Deque<TreeNode> queue = new ArrayDeque<>();

    if (root == null) {
      return list;
    }

    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> levelList = new ArrayList<>();
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.removeFirst();
        levelList.add(node.getVal());
        if (node.getLeft() != null) {
          queue.add(node.getLeft());
        }
        if (node.getRight() != null) {
          queue.add(node.getRight());
        }
      }
      list.add(levelList);
    }
    return list;
  }
}
