package com.zzaoenj;

/**
 * @author: Bruce Zhao
 * @date: 2020/12/16 12:55
 * @desc:
 */
public class NestClass {
  private String name;

  public static void main(String[] args) {
    //
    NestClass main = new NestClass();
    main.setName("aaa");
    main.test();
    
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void test() {
    NestStatus nestStatusGood = new NestStatus("good");
    System.out.println(nestStatusGood.getName());
  
  
    this.setName("bbb");
    NestStatus nestStatusBad = new NestStatus("Bad");

    System.out.println(nestStatusBad.getName());
  }

  public class NestStatus {
    private String status;

    public NestStatus(String status) {
      this.status = status;
    }

    public String getName() {
      return NestClass.this.getName();
    }

    public String getStatus() {
      return status;
    }

    public void setStatus(String status) {
      this.status = status;
    }
  }
}
