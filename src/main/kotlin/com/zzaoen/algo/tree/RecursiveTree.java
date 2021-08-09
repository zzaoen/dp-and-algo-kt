package com.zzaoen.algo.tree;

import com.zzaoen.algo.common.TreeNode;
import com.zzaoen.algo.common.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bruce Zhao
 * @date: 2020/10/15 13:52
 */
public class RecursiveTree {
  private static List list = new ArrayList<TreeNode>();

  public static void main(String[] args) {
    RecursiveTree main = new RecursiveTree();
    TreeNode node = TreeUtils.buildTreeFromString("4,1,null");
    // TreeNode node = TreeUtils.buildTreeFromString("4,9,0,5,1");
    int result = main.sumNumbers(node);
    System.out.println(result);
  }

  public void preOrderTraversalRecursive(TreeNode root) {
    if (root == null) return;
    list.add(root.getVal());
    preOrderTraversalRecursive(root.getLeft());
    preOrderTraversalRecursive(root.getRight());
  }

  public void inOrderTraversalRecursive(TreeNode root) {
    if (root == null) return;
    inOrderTraversalRecursive(root.getLeft());
    list.add(root.getVal());
    inOrderTraversalRecursive(root.getRight());
  }

  public void postOrderTraversalRecursive(TreeNode root) {
    if (root == null) return;
    postOrderTraversalRecursive(root.getLeft());
    postOrderTraversalRecursive(root.getRight());
    list.add(root.getVal());
  }

  /*
       4
      / \
     9   0
    / \
   5   1
   return 495 + 491 + 40 = 1026
  */
  public int sumNumbers(TreeNode root) {
    return postOrderSumNumbers(root, 0);
  }

  public int postOrderSumNumbers(TreeNode root, int preSum) {
    if (root == null) return 0;
    int sum = preSum * 10 + root.val;
    if (root.left == null && root.right == null) {
      return sum;
    } else {
      return postOrderSumNumbers(root.left, sum) + postOrderSumNumbers(root.right, sum);
    }
  }
}
