package com.zzaoenj;

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
  }
}
