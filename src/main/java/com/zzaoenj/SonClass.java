package com.zzaoenj;

/**
 * @author: Bruce Zhao
 * @date: 2020/11/4 22:54
 * @desc:
 */
public class SonClass extends FatherClass {
  private final String name;
  private final String age;

  public SonClass(String name, String age) {
    this.name = name;
    this.age = age;
  }

  public static void main(String[] args) {
    SonClass sc = new SonClass("name", "age");
    sc.testPrivate();
  }
}
