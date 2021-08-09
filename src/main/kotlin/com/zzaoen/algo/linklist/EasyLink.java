package com.zzaoen.algo.linklist;

import com.zzaoen.algo.common.ListNode;

import java.util.Arrays;

/**
 * @author Bruce Zhao
 * @date 2020/10/13 13:07
 */
public class EasyLink {
  public static void main(String[] args) {
    EasyLink main = new EasyLink();

    /*ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;*/
    // ListNode newHead = main.swapPairsIterative(node1);
    // ListNode newHead = main.swapPairsRecursive(node1);

    ListNode node = ListNode.buildLinkList(Arrays.asList(0, 1, 2));
    ListNode newNode = main.reverseList(node);
    // System.out.println(main.isPalindrome(node));
    ListNode.printLinkList(newNode);
  }

  // 1 -> 2 -> 3 -> 4
  // 考虑只有两个节点的情况
  public ListNode swapPairsRecursive(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode newHead = head.next; // newHead = 2
    head.next = swapPairsRecursive(newHead.next); // 1 ->
    newHead.next = head; // 2 -> 1
    return newHead;
  }

  public ListNode swapPairsIterative(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode dummyHead = new ListNode(-1);
    ListNode temp = dummyHead;
    ListNode next;

    while (head != null && head.next != null) {
      next = head.next;

      head.next = next.next; // 1 -> 3
      next.next = head; // 2 -> 1

      temp.next = next; // dummyHead -> 2
      temp = head;
      head = head.next;
    }
    return dummyHead.next;
  }

  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;
    ListNode middleLeftNode = findMiddleLeftBound(head);

    ListNode reverseMiddle = reverseList(middleLeftNode.next);
    middleLeftNode.next = reverseMiddle;

    ListNode left = head;
    ListNode right = middleLeftNode.next;
    for (; right != null; left = left.next, right = right.next) {
      if (left.val != right.val) {
        return false;
      }
    }
    return true;
  }

  // 1->2->2->1 return first 2
  // 1->2->3->2->1 return 3
  public ListNode findMiddleLeftBound(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    return slow;
  }

  /**
   * 206. 反转链表 https://leetcode-cn.com/problems/reverse-linked-list
   *
   * @param head 1->2->3
   * @return 3->2->1
   */
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  // 2 -> 1 to 1 -> 2
  // 3 -> 2 -> 1 to 1 -> 2 -> 3
  public ListNode reverseListRecursive(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode temp = reverseListRecursive(head.next);
    head.next.next = head;
    head.next = null;
    return temp;
  }
}
