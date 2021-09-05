package com.zzaoenj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Bruce Zhao
 * @date 2021/8/19 09:58
 */
public class Test {
  public static void main(String[] args) {
    // Set<String> set = new TreeSet<>(Comparator.comparing(String::length));
    // set.add("dog");
    // set.add("elephant");
    // set.add("tiger");
    // set.forEach(System.out::println);

    // TreeMap<Integer, String> map = new TreeMap<>();
    // map.put(1, "a");
    // map.put(5, "a");
    // map.put(22, "a");
    // Integer integer = map.ceilingKey(2);
    // System.out.println(integer);

    String str1 = "abc";
    String str3 = new String("abc");
    System.out.println(str3.intern() == str1);

    String str2 = null;
    System.out.println(str1.equals(str2));

    List<Integer> list = new ArrayList<>(1);
    list.add(2);
    list.add(3);

    int i = 1;
    Long j = 1L;
    Integer k = null;
    System.out.println(k != j.intValue());

    System.out.println(list);
  }
}
