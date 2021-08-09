package com.zzaoen.algo.tree;

import com.zzaoen.algo.common.TreeNode;
import com.zzaoen.algo.common.TreeUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Bruce Zhao
 * @date: 2020/10/6 19:13
 */
public class EasyTree {
  public static void main(String[] args) {
    EasyTree et = new EasyTree();

    //        3
    //  9           20
    //           15      7
    TreeNode node = TreeUtils.buildTreeFromString("3,9,20,null,null,15,7");

    System.out.println(et.hasPathSum(node, 30));
  }

  /**
   * 翻转一棵树
   *
   * @param root
   * @return
   */
  public TreeNode invertTree(TreeNode root) {
    if (root == null) return root;
    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;

    invertTree(root.left);
    invertTree(root.right);
    return root;
  }

  /**
   * 判断是否是镜像对称的树
   *
   * @param root
   * @return
   */
  public boolean isSymmetricRecursive(TreeNode root) {
    if (root == null) return true;
    return checkSymmetric(root.getLeft(), root.getRight());
  }

  private boolean checkSymmetric(TreeNode left, TreeNode right) {
    // 递归的终止条件是两个节点都为空
    // 或者两个节点中有一个为空
    // 或者两个节点的值不相等
    if (left == null && right == null) {
      return true;
    }
    if (left == null || right == null) {
      return false;
    }
    if (left.getVal() != right.getVal()) {
      return false;
    }
    return checkSymmetric(left.getLeft(), right.getRight())
        && checkSymmetric(left.getRight(), right.getLeft());
  }

  /**
   * 层序遍历的思路，每次poll两个出来比较，offer的时候也是offer两个，而且要注意offer的顺序
   *
   * @param root
   * @return
   */
  public boolean isSymmetricIterative(TreeNode root) {
    if (root == null) {
      return true;
    }
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode node1 = queue.pop();
      TreeNode node2 = queue.pop();
      if (node1 == null && node2 == null) {
        continue;
      }
      if ((node1 == null || node2 == null) || node1.getVal() != node2.getVal()) {
        return false;
      }
      queue.offer(node1.getLeft());
      queue.offer(node2.getRight());
      queue.offer(node1.getRight());
      queue.offer(node2.getLeft());
    }
    return true;
  }

  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    if (root.getLeft() == null && root.getRight() == null) {
      return sum == root.getVal();
    }

    boolean a = hasPathSum(root.getLeft(), sum - root.getVal());
    boolean b = hasPathSum(root.getRight(), sum - root.getVal());
    return a || b;
  }

  /**
   * 100. 相同的树
   * https://leetcode-cn.com/problems/same-tree/
   * @param p
   * @param q
   * @return
   */
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null && q != null) {
      return false;
    }
    if (p != null && q == null) {
      return false;
    }
    if (p.val != q.val) {
      return false;
    }
    boolean sameTreeLeft = isSameTree(p.left, q.left);
    boolean sameTreeRight = isSameTree(p.right, q.right);
    return sameTreeLeft && sameTreeRight;
  }
}
