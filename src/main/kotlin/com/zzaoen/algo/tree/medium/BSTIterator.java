package com.zzaoen.algo.tree.medium;

import com.zzaoen.algo.common.TreeNode;
import com.zzaoen.algo.common.TreeUtils;

import java.util.*;

/**
 * 173. 二叉搜索树迭代器 https://leetcode-cn.com/problems/binary-search-tree-iterator/
 *
 * @author Bruce Zhao
 * @date 2021/3/28 10:19
 */
public class BSTIterator {
  List<Integer> list;
  Iterator<Integer> iterator;
  public BSTIterator(TreeNode root) {
    list = new ArrayList<>();
    // inOrder(list, root);
    inOrderIterative(list, root);
    iterator = list.iterator();
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTreeFromString("7,3,15,null,null,9,20");
    BSTIterator main = new BSTIterator(root);
    System.out.println(main.hasNext());
    System.out.println(main.next());
    System.out.println(main.next());
    System.out.println(main.hasNext());
  }

  private void inOrder(List<Integer> list, TreeNode root) {
    if (root == null) {
      return;
    }
    inOrder(list, root.left);
    list.add(root.val);
    inOrder(list, root.right);
  }

  /*
   * left root right
   *     7
   *   3   15
   *      9  20
   */
  private void inOrderIterative(List<Integer> list, TreeNode root) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode node = root;
    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      if (!stack.isEmpty()) {
        node = stack.pop();
        list.add(node.val);
        node = node.right;
      }
    }
  }

  public int next() {
    return iterator.next();
  }

  public boolean hasNext() {
    return iterator.hasNext();
  }
}
