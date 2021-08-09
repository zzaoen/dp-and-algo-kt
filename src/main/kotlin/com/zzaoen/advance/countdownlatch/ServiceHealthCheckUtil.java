package com.zzaoen.advance.countdownlatch;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: Bruce Zhao
 * @date: 2020/10/31 17:04
 * @desc:
 */
public class ServiceHealthCheckUtil {
  private static final ServiceHealthCheckUtil INSTANCE = new ServiceHealthCheckUtil();
  private static List<BaseHealthChecker> healthCheckerList;
  private static CountDownLatch latch;
  
  private ServiceHealthCheckUtil() {
  }
  
  public static boolean checkExternalServices() throws Exception {
    latch = new CountDownLatch(2);
    healthCheckerList = Arrays.asList(new DatabaseHealthCheck(latch), new CacheHealthCheck(latch));
    
    // ExecutorService executor = Executors.newFixedThreadPool(healthCheckerList.size());
    
    // Common Thread Pool
    ExecutorService executor = new ThreadPoolExecutor(2, 5,
        0L, TimeUnit.MILLISECONDS,
        new LinkedBlockingQueue<Runnable>(1024), r -> {
      Thread thread = Executors.defaultThreadFactory().newThread(r);
      thread.setName("demo-pool-%d");
      return thread;
    }, new ThreadPoolExecutor.AbortPolicy());
    
    
    for (BaseHealthChecker checker : healthCheckerList) {
      executor.execute(checker);
      // break;
    }
    latch.await();
    
    executor.shutdownNow();
    return true;
  }
  
  public ServiceHealthCheckUtil getInstance() {
    return INSTANCE;
  }
  
}
