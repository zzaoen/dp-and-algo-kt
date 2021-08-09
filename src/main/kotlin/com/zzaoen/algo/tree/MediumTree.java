package com.zzaoen.algo.tree;

import com.zzaoen.algo.common.Node;

/**
 * Author: Bruce Zhao
 * Date: 2020/10/15 13:04
 * Desc:
 */
public class MediumTree {
  public static void main(String[] args) {
    MediumTree mt = new MediumTree();
    
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    Node n6 = new Node(6);
    Node n7 = new Node(7);
    n1.left = n2; n1.right = n3;
    n2.left = n4; n2.right = n5;
    n3.left = n6; n3.right = n7;
    
    mt.connect(n1);

    System.out.println(n1);
  }

  public Node connect(Node root) {
    if (root == null) return null;
    connectPreOrder(root.left, root.right);
    root.next = null;
    return root;
  }
  
  // https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487126&idx=1&sn=4de13e66397bc35970963c5a1330ce18&chksm=9bd7f09eaca0798853c41fba05ad5fa958b31054eba18b69c785ae92f4bd8e4cc7a2179d7838&scene=21#wechat_redirect
  private void connectPreOrder(Node node1, Node node2) {
    if (node1 == null || node2 == null) return;
    node1.next = node2;
    connectPreOrder(node1.left, node1.right);
    connectPreOrder(node2.left, node2.right);
    // 跨越两个根节点的情况
    connectPreOrder(node1.right, node2.left);
  }
  
  // 这个确实不行，如果树很高，底下不同节点之间还是无法连接上。上面因为利用了递归，能不断往下走
  /*private void connectPreOrderError(Node left, Node right) {
    if (left == null || right == null) return;
    connectPreOrderError(left.left, left.right);
    connectPreOrderError(right.left, right.right);
    left.next = right;
    right.next = null;
    
    if (left.right != null) {
      left.right.next = right.left;
    }
  }*/
}
