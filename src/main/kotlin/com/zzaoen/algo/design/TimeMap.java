package com.zzaoen.algo.design;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bruce Zhao
 * @date 2021/7/10 19:11 981. 基于时间的键值存储 https://leetcode-cn.com/problems/time-based-key-value-store/
 */
public class TimeMap {

  public static void main(String[] args) {
    //
    TimeMap tm = new TimeMap();
    tm.set("foo", "bar", 10);
    tm.set("foo", "bar", 20);
    System.out.println(tm.get("foo", 5));
  }

  class Pair implements Comparable<Pair> {
    Integer timesstamp;
    String value;

    public Pair(int timestamp, String value) {
      super();
      this.timesstamp = timestamp;
      this.value = value;
    }

    @Override
    public int compareTo(@NotNull Pair o) {
      return this.timesstamp - o.timesstamp;
    }
  }

  private final Map<String, List<Pair>> map;

  public TimeMap() {
    map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    List<Pair> pairs = map.getOrDefault(key, new ArrayList<>());
    pairs.add(new Pair(timestamp, value));
    map.put(key, pairs);
  }

  /**
   * 返回先前调用set(key, value, timestamp_prev)所存储的值，其中timestamp_prev <= timestamp。
   * 如果有多个这样的值，则返回对应最大的timestamp_prev的那个值。 如果没有值，则返回空字符串（""）。
   *
   * @param key
   * @param timestamp
   * @return
   */
  public String get(String key, int timestamp) {
    List<Pair> pairs = map.getOrDefault(key, new ArrayList<>());
    if (pairs.isEmpty()) {
      return "";
    }
    Pair target = new Pair(timestamp, "");

    // Binary search, find the right bound of index <= target
    int left = 0, right = pairs.size() - 1;
    int mid;
    while (left < right) {
      // 假设只有两个节点，一定要用右侧开始比较
      mid = left + (right - left + 1) / 2;
      Pair pair = pairs.get(mid);
      if (pair.compareTo(target) > 0) {
        // mid > target
        right = mid - 1;
      } else if (pair.compareTo(target) == 0) {
        left = mid;
      } else {
        // mid < target
        left = mid;
      }
    }
    return pairs.get(left).timesstamp <= timestamp ? pairs.get(left).value : "";
  }
}
