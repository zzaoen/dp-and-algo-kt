package com.zzaoen.advance.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author: Bruce Zhao
 * @date: 2020/10/31 16:57
 * @desc:
 */
public class CacheHealthCheck extends BaseHealthChecker {
  public CacheHealthCheck(CountDownLatch latch) {
    super(latch, "Cache service");
  }
  
  @Override
  void verifyService() {
    System.out.println("Checking " + this.getServiceName());
    try {
      Thread.sleep(300000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(this.getServiceName() + " is UP");
  }
}
