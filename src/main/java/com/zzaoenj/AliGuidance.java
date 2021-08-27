package com.zzaoenj;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Bruce Zhao
 * @date: 2020/11/6 14:54
 * @desc:
 */
public class AliGuidance {
  
  private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
    @Override
    protected DateFormat initialValue() {
      return new SimpleDateFormat("yyyy-MM-dd");
    }
  };
  
  public static void main(String[] args) {
    // List<String> list = Arrays.asList("1", "2");
    List<String> list = new ArrayList<>();
    list.add("1");
    list.add("2");
    list.add("3");
    
    Iterator<String> iterator = list.iterator();
    int i = 1;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    while (iterator.hasNext()) {
      String next = iterator.next();
      System.out.println(next);
      if ("2".equals(next)) {
        iterator.remove();
        System.out.println("remove" + next);
      }
    }
    
    /*while (iterator.hasNext()) {
      if (i == 1) {
        i++;
        iterator.remove();
      } else {
        list.add("4");
      }
      System.out.println(iterator.next());
    }*/
  }
}
