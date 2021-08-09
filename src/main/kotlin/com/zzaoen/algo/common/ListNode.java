package com.zzaoen.algo.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bruce Zhao
 * @date 2020/5/24 22:46
 */
public class ListNode {
  public int val;
  public ListNode next;
  public ListNode random;

  // public ListNode() {
  // }

  public ListNode(int x) {
    val = x;
  }

  public static void printLinkList(ListNode head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }

  public static ListNode buildLinkList(int[] intArray) {
    List<Integer> intList = Arrays.stream(intArray).boxed().collect(Collectors.toList());
    return buildLinkList(intList);
  }

  public static ListNode buildLinkList(List<Integer> intList) {
    ListNode dummyHead = new ListNode(-1);
    ListNode head = dummyHead;
    for (int i : intList) {
      ListNode temp = new ListNode(i);
      head.next = temp;
      head = temp;
    }
    return dummyHead.next;
  }

  public static int length(ListNode head) {
    int result = 0;
    while (head != null) {
      head = head.next;
      result++;
    }
    return result;
  }
}
