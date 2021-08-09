package com.zzaoen.java.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author: Bruce Zhao
 * @date: 2020/11/4 21:48
 * @desc:
 */
public enum CurrencyEnum {
  /**
   * USD
   */
  USD(1, "USD"),
  CAD(2, "CAD");
  
  private int id;
  private String currency;
  
  CurrencyEnum(int id, String currency) {
    this.id = id;
    this.currency = currency;
  }
  
  public static CurrencyEnum byId(int id) {
    return Arrays.stream(CurrencyEnum.values()).filter(it -> it.id == id).findFirst().orElse(null);
    /*for (CurrencyEnum currencyEnum : CurrencyEnum.values()) {
      if (currencyEnum.id == id) {
        return currencyEnum;
      }
    }
    return null;*/
  }
}
