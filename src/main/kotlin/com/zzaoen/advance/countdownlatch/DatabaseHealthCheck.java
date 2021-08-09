package com.zzaoen.advance.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author: Bruce Zhao
 * @date: 2020/10/31 16:57
 * @desc:
 */
public class DatabaseHealthCheck extends BaseHealthChecker {
  public DatabaseHealthCheck(CountDownLatch latch) {
    super(latch, "DB service");
  }
  
  @Override
  void verifyService() {
    System.out.println("Checking " + this.getServiceName());
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(this.getServiceName() + " is UP");
  }
}
