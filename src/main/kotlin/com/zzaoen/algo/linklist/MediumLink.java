package com.zzaoen.algo.linklist;

import com.zzaoen.algo.common.ListNode;
import com.zzaoen.algo.common.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bruce Zhao
 * @date 2021/3/27 11:05
 */
public class MediumLink {
  public static void main(String[] args) {
    // MediumLink main = new MediumLink();
    //
    // // int[] ints1 = {2, 4, 3};
    // // int[] ints2 = {5, 6, 4};
    // int[] ints1 = {9, 9, 1};
    // int[] ints2 = {1};
    // ListNode head1 = ListNode.buildLinkList(ints1);
    // ListNode head2 = ListNode.buildLinkList(ints2);
    //
    // ListNode head = main.addTwoNumbers(head1, head2);
    // ListNode.printLinkList(head);

    // int[] ints = {1, 2, 3, 4, 5};
    // ListNode head = ListNode.buildLinkList(ints);
    // ListNode newHead = main.rotateRight(head, 6);
    // ListNode.printLinkList(newHead);

    // int[] ints = {-1, 5, 3, 4, 0};
    // ListNode head = ListNode.buildLinkList(ints);
    // ListNode.printLinkList(main.insertionSortList(head));
    ListNode node1 = new ListNode(7);
    ListNode node2 = new ListNode(13);
    ListNode node3 = new ListNode(11);
    ListNode node4 = new ListNode(10);
    ListNode node5 = new ListNode(1);



    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

    // node1.random = node4;
    node2.random = node1;
    node3.random = node5;
    node4.random = node3;
    node5.random = node1;

    ListNode oldHead = node1;
    while(oldHead!= null){
      System.out.println("val:"+ oldHead.val);
      if(oldHead.next != null){
        System.out.println(" next:"+ oldHead.next.val);
      }
      if( oldHead.random != null){
        System.out.println(" ran:"+ oldHead.random.val);
      }
      oldHead = oldHead.next;
    }

    System.out.println("================");
    ListNode newHead = copyRandomList(node1);
    // ListNode newHead = copyRandomList2(node1);

    while(newHead!= null){
      System.out.println("val:"+ newHead.val  );
      if(newHead.next != null){
        System.out.println(" next:"+ newHead.next.val);
      }
      if(newHead.random != null){
        System.out.println(" ran:"+ newHead.random.val);
      }
      newHead = newHead.next;
    }


  }

  /**
   * 138. 复制带随机指针的链表 https://leetcode-cn.com/problems/copy-list-with-random-pointer/
   * @param head
   * @return
   */
  public static ListNode copyRandomList(ListNode head) {

    ListNode node = head;
    ListNode tmp;
    if(node == null){
      return null;
    }

    while(node != null){
      int var = node.val;
      tmp = new ListNode(var);
      // tmp.val = node.val;
      tmp.next = node.next;
      node.next = tmp;
      if(node.next.next != null){
        node = node.next.next;
      } else {
        break;
      }
    }

    node = head;
    tmp = node.next;
    while(node.next != null){
      if(node.random != null){
        tmp.random = node.random.next;
      }
      if(node.next.next != null){
        node = node.next.next;
        tmp = tmp.next.next;
      } else {
        break;
      }
    }

    node = head;

    ListNode tmpHead = node.next;
    while(node.next.next != null){
      tmp = node.next;
      node.next = tmp.next;
      tmp.next = tmp.next.next;
      node = node.next;
    }
    node.next = null;


   return tmpHead;

  }

  public static ListNode copyRandomList2(ListNode head) {

    ListNode node = head;
    // ListNode tmp;

    if(head == null){
      return null;
    }

    Map<ListNode, ListNode> map = new HashMap<>();
    int val = node.val;
    ListNode tmpHead = new ListNode(val);
    map.put(node, tmpHead);
    node = node.next;
    while(node != null){
      val = node.val;
      map.put(node, new ListNode(val));
      node = node.next;
    }
    node = head;
    while(node != null){
      map.get(node).next = map.get(node.next);
      map.get(node).random = map.get(node.random);
      node = node.next;
    }

    return tmpHead;

  }
  /* ------------------------------------------------------------------ */

  /**
   * 2. 两数相加 https://leetcode-cn.com/problems/add-two-numbers/ l1 = [2,4,3], l2 = [5,6,4] R =
   * [7,0,8] 342 + 465 = 807
   *
   * @param l1
   * @param l2
   * @return
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(-1);
    ListNode head = dummyHead;
    int carry = 0;
    while (l1 != null || l2 != null) {
      int v1 = l1 == null ? 0 : l1.val;
      int v2 = l2 == null ? 0 : l2.val;
      int sum = v1 + v2 + carry;
      ListNode node = new ListNode(sum % 10);
      head.next = node;
      head = node;
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
      carry = sum / 10;
    }
    if (carry != 0) {
      head.next = new ListNode(carry);
    }
    return dummyHead.next;
  }

  /**
   * 61. 旋转链表 https://leetcode-cn.com/problems/rotate-list/ <br>
   * 1->2->3->4->5
   *
   * @param head
   * @param k
   * @return
   */
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return head;
    }
    int length = ListNode.length(head);
    if (length == 0) {
      return head;
    }
    k = k % length;
    if (k == 0) {
      return head;
    }
    // find the partition node, should left (length-k) node, move to this node
    ListNode partitionNode = head;
    int moveLength = length - k - 1;
    int i = 0;
    while (i++ < moveLength) {
      partitionNode = partitionNode.next;
    }
    ListNode newHead = partitionNode.next;
    partitionNode.next = null;
    ListNode tempNewHead = newHead;
    while (tempNewHead.next != null) {
      tempNewHead = tempNewHead.next;
    }
    tempNewHead.next = head;
    return newHead;
  }

  /**
   * 147. 对链表进行插入排序 https://leetcode-cn.com/problems/insertion-sort-list/
   *
   * @param head
   */
  private ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
    dummyHead.next = head;
    ListNode lastSorted = head;
    ListNode curr = head.next;
    while (curr != null) {
      if (lastSorted.val <= curr.val) {
        lastSorted = lastSorted.next;
      } else {
        // insert a small value into sorted list
        ListNode prev = dummyHead;
        while (prev.next.val <= curr.val) {
          prev = prev.next;
        }
        // 1 -> 5 -> 2 -> 6
        lastSorted.next = curr.next; // 5 -> 6
        curr.next = prev.next; // 2 -> 5
        prev.next = curr; // 1 -> 2
      }
      curr = lastSorted.next;
    }
    return dummyHead.next;
  }

  /**
   * 148. 排序链表 https://leetcode-cn.com/problems/sort-list/ <br>
   * -1 -> 5 -> 3 -> 4 -> 0 <br>
   * -1 -> 0 -> 3 -> 4 -> 5
   *
   * @param head
   * @return
   */
  public ListNode sortList(ListNode head) {
    return null;
  }
}
