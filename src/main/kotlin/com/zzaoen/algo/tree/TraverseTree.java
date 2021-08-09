package com.zzaoen.algo.tree;

import com.zzaoen.algo.common.TreeNode;
import com.zzaoen.algo.common.TreeUtils;

import java.util.*;

/**
 * @author: Bruce Zhao
 * @date: 2020/9/20 22:48
 */

public class TraverseTree {
  public static List<Integer> list = new ArrayList<>();

  public static void main(String[] args) {
    TraverseTree tt = new TraverseTree();
    TreeNode root = TreeNode.buildTree3Level();
    // tt.preOrderTraversalRecursive(root);
    // tt.postOrderTraversalRecursive(root);
    // tt.postOrderTraversalRecursive(root);

    // tt.preOrderTraversalIterative(root);
    // tt.inOrderTraversalIterative(root);
    // System.out.println(tt.postOrderTraversalIterative(root));
    // System.out.println(tt.postOrderTraversalIterative2(root));

    // System.out.println(tt.levelOrder(root));
    // System.out.println(tt.levelOrder2(root));

    //        3
    //  9           20
    //           15      7
    TreeNode node = TreeUtils.buildTreeFromString("3,9,20,null,null,15,7");
    // System.out.println(tt.levelOrder2(node));
  }

  /**
   * root left right
   *
   * @param root
   */
  public void preOrderTraversalIterative(TreeNode root) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    // List<Integer> resultList = new ArrayList<>();
    TreeNode node = root;

    while (node != null || !stack.isEmpty()) {
      // 一直走到左边的null
      while (node != null) {
        list.add(node.getVal());
        stack.push(node);
        node = node.getLeft();
      }
      if (!stack.isEmpty()) {
        node = stack.pop();
        node = node.getRight();
      }
    }
  }

  /**
   * left root right
   *
   * @param root
   */
  public void inOrderTraversalIterative(TreeNode root) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode node = root;

    while (node != null || !stack.isEmpty()) {
      // 一直走到左边的null
      while (node != null) {
        stack.push(node);
        node = node.getLeft();
      }
      if (!stack.isEmpty()) {
        node = stack.pop();
        list.add(node.getVal());
        node = node.getRight();
      }
    }
  }

  /**
   * left right root
   *
   * @param root
   */
  public List postOrderTraversalIterative(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode node = root;
    TreeNode lastVisited = root;
    while (node != null || !stack.isEmpty()) {
      // 一直走到左边的null
      while (node != null) {
        stack.push(node);
        node = node.getLeft();
      }
      node = stack.peek();
      if (node.getRight() == null || node.getRight() == lastVisited) {
        stack.pop();
        list.add(node.getVal());
        lastVisited = node;
        node = null;
      } else {
        node = node.getRight();
      }
    }
    return list;
  }

  /**
   * 前序遍历 root left right, 调整一下 root right left 后续遍历 left right root. 所以前序调整一下，输出逆序就是后续
   *
   * @param root
   * @return
   */
  public List postOrderTraversalIterative2(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
    TreeNode node = root;

    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        /** add at the front of the list, needn't reverse list later */
        list.add(0, node.getVal());
        stack.push(node);
        node = node.getRight();
      }
      if (!stack.isEmpty()) {
        node = stack.pop();
        node = node.getLeft();
      }
    }
    return list;
  }

  /*
   * 层序遍历的思路，画个图就明白了，按照根 右 左的顺序
   *          1
   *      2       3
   *   4     5  6
   * @param root
   * @return 4 5 2 6 3 1
   */
  public List postOrderTraversalIterative3(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
    TreeNode node = root;
    stack.push(root);
    while (!stack.isEmpty()) {
      node = stack.pollLast(); // keypoint
      list.add(0, node.getVal()); // keypoint
      if (node.getLeft() != null) {
        stack.add(node.getLeft());
      }
      if (node.getRight() != null) {
        stack.add(node.getRight());
      }
    }
    return list;
  }
}
