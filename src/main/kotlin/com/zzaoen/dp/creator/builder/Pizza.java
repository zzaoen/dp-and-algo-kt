package com.zzaoen.dp.creator.builder;

import java.util.EnumSet;
import java.util.Set;

/**
 * @author: Bruce Zhao
 * @date: 2020/11/6 22:12
 * @desc: 带有层次结构的builder模式
 */
public class Pizza {
  /** 披萨上面的配料 **/
  public enum Topping {
    SAUSAGE,
    ONION,
    PEPPER,
    SUGER
  }
  
  final Set<Topping> toppingSet;
  
  abstract static class Builder<T extends Builder<T>> {
    EnumSet<Topping> toppingEnumSet = EnumSet.noneOf(Topping.class);
    public T addTopping(Topping topping) {
      toppingEnumSet.add(topping);
      return self();
    }
    
    abstract Pizza build();
    
    protected abstract T self();
  }
  
  Pizza(Builder<?> builder) {
    toppingSet = builder.toppingEnumSet.clone();
  }
}
