package com.zzaoen.algo.design;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bruce Zhao
 * @date 2021/7/10 19:11
 * 981. 基于时间的键值存储 https://leetcode-cn.com/problems/time-based-key-value-store/
 */
public class TimeMap {
  class Pair implements Comparable<Pair> {
    Integer time;
    String value;

    public Pair(int timestamp, String value) {
      super();
    }

    @Override
    public int compareTo(@NotNull Pair o) {
      return this.time - o.time;
    }
  }

  private Map<String, List<Pair>> map;
  public TimeMap() {
    map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    List<Pair> pairs = map.getOrDefault(key, new ArrayList<>());
    pairs.add(new Pair(timestamp, value));
  }

  /**
   * 返回先前调用set(key, value, timestamp_prev)所存储的值，其中timestamp_prev <= timestamp。
   * 如果有多个这样的值，则返回对应最大的timestamp_prev的那个值。 如果没有值，则返回空字符串（""）。
   *
   * @param key
   * @param timestamp
   * @return
   */
  // public String get(String key, int timestamp) {
  //   return;
  // }
}
