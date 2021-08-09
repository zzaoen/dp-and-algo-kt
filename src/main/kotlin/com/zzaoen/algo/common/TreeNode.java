package com.zzaoen.algo.common;

/**
 * @author Bruce Zhao
 * @date 2020/9/20 22:49
 */
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {}

  public TreeNode(int x) {
    val = x;
  }

  /**
   * 1 2 3
   *
   * @return
   */
  public static TreeNode buildTree2Level() {
    TreeNode root = new TreeNode(1);
    root.setLeft(new TreeNode(2));
    root.setRight(new TreeNode(3));
    return root;
  }

  /*
       3
   1
     2
  */
  public static TreeNode buildTree3Level() {
    TreeNode root = new TreeNode(3);
    root.setLeft(new TreeNode(1));
    root.getLeft().setRight(new TreeNode(2));
    return root;
  }

  /**
   * 1 2 3
   *
   * @return preOrder 1,2,3 inOrder 1,3,2 postOrder 3,2,1
   */
  public static TreeNode buildTree3Level2() {
    TreeNode root = new TreeNode(1);
    root.setRight(new TreeNode(2));
    root.getRight().setLeft(new TreeNode(3));
    return root;
  }

  public int getVal() {
    return val;
  }

  public void setVal(int val) {
    this.val = val;
  }

  public TreeNode getLeft() {
    return left;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }

  public TreeNode getRight() {
    return right;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }
}
