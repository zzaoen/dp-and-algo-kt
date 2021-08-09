package com.zzaoen.algo.common;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Bruce Zhao
 * @date 2020/9/27 09:17
 */
public class TreeUtils {

  public static void main(String[] args) {
    buildTreeFromString("3,9,20,null,null,15,7");
  }
  /**
   * 3,9,20,null,null,15,7
   *
   * @param treeStr
   * @return
   */
  public static TreeNode buildTreeFromString(String treeStr) {
    Deque<TreeNode> queueNode = new ArrayDeque<>();

    Deque<String> queueStr = new ArrayDeque<>(Arrays.asList(treeStr.split(",")));
    // queueStr.addAll(Arrays.asList(treeStr.split(",")));
    // Arrays.stream(treeStr.split(",")).forEach(queueStr::add);

    if (queueStr.isEmpty() || "null".equalsIgnoreCase(queueStr.getFirst())) {
      return null;
    }

    TreeNode root = new TreeNode(Integer.parseInt(queueStr.removeFirst()));
    queueNode.addFirst(root);

    while (!queueNode.isEmpty() && !queueStr.isEmpty()) {
      TreeNode currentNode = queueNode.removeFirst();
      String leftVal = queueStr.removeFirst();
      String rightVal = queueStr.removeFirst();
      TreeNode leftNode = null;
      TreeNode rightNode = null;
      if (!"null".equals(leftVal)) {
        leftNode = new TreeNode(Integer.parseInt(leftVal));
        currentNode.setLeft(leftNode);
        queueNode.offer(leftNode);
      }
      if (!"null".equals(rightVal)) {
        rightNode = new TreeNode(Integer.parseInt(rightVal));
        currentNode.setRight(rightNode);
        queueNode.offer(rightNode);
      }
    }
    return root;
  }
}
