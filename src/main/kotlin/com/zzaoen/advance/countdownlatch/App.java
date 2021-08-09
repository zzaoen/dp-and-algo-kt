package com.zzaoen.advance.countdownlatch;

/**
 * @author: Bruce Zhao
 * @date: 2020/10/31 17:03
 * @desc:
 */
public class App {
  public static void main(String[] args) {
    try {
      ServiceHealthCheckUtil.checkExternalServices();
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("External services validation completed !!");
  }
}
