package com.zzaoen.algo.mthread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author Bruce Zhao
 * @date 2021/2/21 14:18
 */
public class AlternatePrint {
  private int n;
  private final Semaphore fooSemaphore = new Semaphore(1);
  private final Semaphore barSemaphore = new Semaphore(0);

  CyclicBarrier cb = new CyclicBarrier(2);

  public AlternatePrint(int n) {
    this.n = n;
  }

  public void foo(Runnable printFoo) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      fooSemaphore.acquire();
      printFoo.run();
      barSemaphore.release();
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      barSemaphore.acquire();
      printBar.run();
      fooSemaphore.release();
    }
  }
}
