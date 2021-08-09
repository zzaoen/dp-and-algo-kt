package com.zzaoen.algo.design;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存机制 https://leetcode-cn.com/problems/lru-cache/
 *
 * @author Bruce Zhao
 * @date 2021/3/26 20:29
 */
public class LRUCache {
  Map<Integer, DNode> cache;
  int capacity, size;
  DNode head, tail;

  public LRUCache(int capacity) {
    cache = new HashMap<>();
    this.capacity = capacity;
    this.size = 0;
    head = new DNode();
    tail = new DNode();
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    DNode node = cache.get(key);
    if (node == null) {
      return -1;
    }
    moveToHead(node);
    return node.value;
  }

  public void put(int key, int value) {
    DNode node = cache.get(key);
    if (node != null) {
      node.value = value;
      moveToHead(node);
    } else {
      DNode temp = new DNode(key, value);
      cache.put(key, temp);
      addToHead(temp);
      ++size;
      if (size > capacity) {
        DNode tailNode = removeTail();
        cache.remove(tailNode.key);
        --size;
      }
    }
  }

  /**
   * add current to the head
   *
   * @param node
   */
  private void addToHead(DNode node) {
    node.prev = head;
    node.next = head.next;
    head.next.prev = node;
    head.next = node;
  }

  /**
   * remove current node
   *
   * @param node
   */
  private void remove(DNode node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  /**
   * move this node next to the head of the List
   *
   * @param node
   */
  private void moveToHead(DNode node) {
    // remove current
    remove(node);
    // add current to the head
    addToHead(node);
  }

  /** remove tail node */
  private DNode removeTail() {
    DNode tailNode = tail.prev;
    tailNode.prev.next = tailNode.next;
    tailNode.next.prev = tailNode.prev;
    return tailNode;
  }

  class DNode {
    int key;
    int value;
    DNode prev;
    DNode next;

    public DNode() {}

    public DNode(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
}
