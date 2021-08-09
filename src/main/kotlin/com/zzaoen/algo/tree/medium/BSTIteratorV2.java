package com.zzaoen.algo.tree.medium;

import com.zzaoen.algo.common.TreeNode;
import com.zzaoen.algo.common.TreeUtils;

import java.util.*;

/**
 * @author Bruce Zhao
 * @date 2021/3/28 10:19
 */
public class BSTIteratorV2 {
  public BSTIteratorV2(TreeNode root) {}

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTreeFromString("7,3,15,null,null,9,20");
    BSTIteratorV2 main = new BSTIteratorV2(root);
    System.out.println(main.hasNext());
    System.out.println(main.next());
    System.out.println(main.next());
    System.out.println(main.hasNext());
  }

  public int next() {
    return -1;
  }

  public boolean hasNext() {
    return false;
  }
}
