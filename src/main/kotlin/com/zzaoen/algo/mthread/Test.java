package com.zzaoen.algo.mthread;

/**
 * @author Bruce Zhao
 * @date 2021/2/20 18:05
 */
public class Test {
  public static void main(String[] args) {
    Test main = new Test();

    main.testAlternatePrint();
  }

  public void testSequenceRun() {
    SequenceRun sr = new SequenceRun();
    Thread thread1 = new Thread(() -> {
      sr.first(() -> System.out.println("1"));
    });
    Thread thread2 = new Thread(() -> {
      try {
        sr.second(() -> System.out.println("2"));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    Thread thread3 = new Thread(() -> {
      try {
        sr.third(() -> System.out.println("3"));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    thread1.start();
    thread2.start();
    thread3.start();
  }

  public void testAlternatePrint() {
    AlternatePrint al = new AlternatePrint(3);
    Thread thread1 = new Thread(() -> {
      try {
        al.foo(() -> System.out.println("foo"));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    Thread thread2 = new Thread(() -> {
      try {
        al.bar(() -> System.out.println("bar"));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    thread1.start();
    thread2.start();
  }
}
