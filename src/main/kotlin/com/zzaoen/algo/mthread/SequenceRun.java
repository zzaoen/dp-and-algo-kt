package com.zzaoen.algo.mthread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Bruce Zhao
 * @date 2021/2/20 18:05
 */
public class SequenceRun {
  volatile
  // private final AtomicInteger firstJobStatus = new AtomicInteger(0);
  // private final AtomicInteger secondJobStatus = new AtomicInteger(0);
  private Semaphore secondJobSemaphore = new Semaphore(0);
  private Semaphore thirdJobSemaphore = new Semaphore(0);
  public SequenceRun() {}

  public void first(Runnable printFirst) {
    printFirst.run();
    // firstJobStatus.incrementAndGet();
    secondJobSemaphore.release();
  }

  public void second(Runnable printSecond) throws InterruptedException {
    secondJobSemaphore.acquire();

    // while (firstJobStatus.get() == 0) { }
    printSecond.run();
    // secondJobStatus.incrementAndGet();

    thirdJobSemaphore.release();
  }

  public void third(Runnable printThird) throws InterruptedException {
    thirdJobSemaphore.acquire();

    // while (secondJobStatus.get() == 0) { }
    printThird.run();
  }
}
