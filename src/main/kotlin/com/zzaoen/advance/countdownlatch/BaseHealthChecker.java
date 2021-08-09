package com.zzaoen.advance.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author: Bruce Zhao
 * @date: 2020/10/31 16:52
 * @desc:
 */
public abstract class BaseHealthChecker implements Runnable {
  private final CountDownLatch latch;
  private final String serviceName;
  private boolean status;
  
  protected BaseHealthChecker(CountDownLatch latch, String serviceName) {
    this.latch = latch;
    this.serviceName = serviceName;
    this.status = false;
  }
  
  @Override
  public void run() {
    try {
      verifyService();
      status = true;
    } catch (Exception e) {
      status = false;
    } finally {
      if (latch != null) {
        latch.countDown();
      }
    }
  }
  
  protected String getServiceName() {
    return serviceName;
  }
  
  /**
   * To check service status
   */
  abstract void verifyService();
}
