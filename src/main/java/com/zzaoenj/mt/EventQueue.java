package com.zzaoenj.mt;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Author: Bruce Zhao
 * Date: 2020/8/27 12:51
 * Desc:
 */
public class EventQueue {
  private final int max;
  private static final int DEFAULT_MAX_EVENT = 5;
  private final LinkedList<Event> eventQueue = new LinkedList<>();
  static AtomicInteger atomicInteger = new AtomicInteger();

  public EventQueue() {
    this(DEFAULT_MAX_EVENT);
  }

  public EventQueue(int max) {
    this.max = max;
  }

  static class Event {
    private Integer id;

    public Event(Integer id) {
      this.id = id;
    }
  }

  public void offer(Event event) {
    synchronized (eventQueue) {
      while (eventQueue.size() >= max) {
        try {
          System.out.println("queue full");
          eventQueue.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      eventQueue.addLast(event);
      System.out.println(Thread.currentThread().getName() + " offer: " + event.id);
      eventQueue.notifyAll();
    }
  }

  public void take() {
    synchronized (eventQueue) {
      while (eventQueue.size() <= 0) {
        try {
          System.out.println("queue empty");
          eventQueue.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      try {
        TimeUnit.SECONDS.sleep(5);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      Event event = eventQueue.removeFirst();
      System.out.println(Thread.currentThread().getName() + " take: " + event.id);
      eventQueue.notifyAll();
    }
  }

  public static void main(String[] args) {
    EventQueue eventQueue = new EventQueue();
    new Thread(
        () -> {
          for (; ; ) {
            eventQueue.offer(new Event(atomicInteger.incrementAndGet()));
          }
        }).start();
  
    new Thread(
        () -> {
          for (; ; ) {
            eventQueue.take();
          }
        }).start();
    
    new Thread(
        () -> {
          for (; ; ) {
            eventQueue.offer(new Event(atomicInteger.incrementAndGet()));
          }
        }).start();
  
    new Thread(
        () -> {
          for (; ; ) {
            eventQueue.take();
          }
        }).start();
  
    
  }
}
