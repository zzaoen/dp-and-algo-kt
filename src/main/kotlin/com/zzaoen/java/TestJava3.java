package com.zzaoen.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Collections;
import java.util.EnumSet;

/**
 * @author: Bruce Zhao
 * @date: 2020/12/14 16:25
 * @desc:
 */
public class TestJava3 {
  public static void main(String[] args) throws IOException {
    String s = new StringBuilder().append("open").append("jdk").toString();
    String intern = s.intern();
    System.out.println(s == intern);
    String intern2 = s.intern();
    String ss = "open" + "jdk";
    String sss = new String("openjdk");
    String ssss = new StringBuilder().append("open").append("jdk").toString();
    String sssss = new StringBuilder().append("open").append("jdk").toString();
    System.out.println(System.identityHashCode(s));
    System.out.println(System.identityHashCode(s.intern()));
    System.out.println(System.identityHashCode(sss.intern()));
    System.out.println(System.identityHashCode(ssss.intern()));
    System.out.println(System.identityHashCode(sssss.intern()));

    System.out.println(intern == ss);
    System.out.println(intern == sss);
    System.out.println(ss == sss);

    // System.out.println(intern);
    // System.out.println(intern == s);


    // String s1 = "hello";
    // String s2 = "world";
    // String s3 = "helloworld";
    // String s4 = s1+s2;
    // String s5 = "hello"+"world";
    // System.out.println(s3.hashCode());
    // System.out.println(s4.hashCode());
    // System.out.println(System.identityHashCode(s3));
    // System.out.println(System.identityHashCode(s4));
    // System.out.println(System.identityHashCode(s5));
    // System.out.println(s3 == s4);
    // System.out.println(s3 == s5);

    // readLine(new BufferedReader(null));
  }

  public static int readLine(BufferedReader reader) throws IOException {
    try {
      String s = reader.readLine();
      return Integer.parseInt(s);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      reader.close();
    }
    return -1;
  }
}
