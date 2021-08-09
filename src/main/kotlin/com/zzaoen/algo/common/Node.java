package com.zzaoen.algo.common;

/*
 * Author: Bruce Zhao
 * Date: 2020/10/15 13:04
 * Desc:
 */
public class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;
  
  public Node() {}
  
  public Node(int val) {
    this.val = val;
  }
  
  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
}
