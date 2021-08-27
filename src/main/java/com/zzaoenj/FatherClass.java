package com.zzaoenj;

/**
 * @author: Bruce Zhao
 * @date: 2020/11/4 22:54
 * @desc:
 */
public class FatherClass {
  protected FatherClass() {}
  // private com.zz.FatherClass() {}

  void testPrivate() {
    System.out.println("son can't call me");
  }
}
