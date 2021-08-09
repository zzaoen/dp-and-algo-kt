package com.zzaoen.algo.tree;

import com.zzaoen.algo.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: Bruce Zhao
 * @date: 2020/12/5 19:21
 * @desc:
 */
public class BinarySearchTree {

  /** 783, 1746 */
  /** 二叉搜索树的最小绝对差 二叉搜索树的中序遍历是排好序的数组。一个排好序的数组上（非负）两个元素之差的绝对值的最小值，一定是相邻的两元素。 */
  int ans = Integer.MAX_VALUE;

  int pre = -1;

  public int minDiffInBSTIterative(TreeNode root) {
    minDiffInBSTInorder(root);
    return ans;
  }
  // left root right
  public void minDiffInBSTInorder(TreeNode root) {
    if (root == null) {
      return;
    }
    minDiffInBSTInorder(root.left);
    // handle root
    if (pre == -1) {
      pre = root.val;
    } else {
      ans = Math.min(ans, root.val - pre);
      pre = root.val;
    }
    minDiffInBSTInorder(root.right);
  }

  /** 783, 1746 */
  public int minDiffInBSTRecursive(TreeNode root) {
    // List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode node = root;
    TreeNode pre = null;
    int result = Integer.MAX_VALUE;

    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      if (!stack.isEmpty()) {
        node = stack.pop();
        if (pre != null) {
          result = (node.val - pre.val) < result ? node.val - pre.val : result;
        }
        pre = node;
        node = node.right;
      }
    }
    // System.out.println(result);
    return result;
  }
  /* --------------------------------------------------- */

  /** 897, 1744 */
  public TreeNode increasingBST(TreeNode root) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode node = root;
    TreeNode newRoot = new TreeNode(-1);
    TreeNode cur = newRoot;

    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      if (!stack.isEmpty()) {
        node = stack.pop();
        // handle new tree from here
        cur.right = node;
        node.left = null; // remember this
        cur = cur.right;

        node = node.right;
      }
    }
    return newRoot.right;
  }
  /* --------------------------------------------------- */
  /** 938 */
  public int rangeSumBST(TreeNode root, int low, int high) {
    List<Integer> result = new ArrayList<>(1);
    result.add(0);
    rangeSumBSTInOrder(root, low, high, result);
    System.out.println(result);
    return result.get(0);
  }

  private void rangeSumBSTInOrder(TreeNode node, int low, int high, List<Integer> result) {
    if (node == null) {
      return;
    }
    if (node.val > low) {
      rangeSumBSTInOrder(node.left, low, high, result);
    }
    //
    if (node.val >= low && node.val <= high) {
      result.set(0, result.get(0) + node.val);
    }
    if (node.val < high) {
      rangeSumBSTInOrder(node.right, low, high, result);
    }
  }
}
