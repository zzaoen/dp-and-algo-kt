package com.zzaoen.dp.creator.builder;

import java.util.Objects;

/**
 * @author: Bruce Zhao
 * @date: 2020/11/6 22:17
 * @desc:
 */
public class NyPizza extends Pizza {
  private final Size size;
  
  private NyPizza(Builder builder) {
    super(builder);
    size = builder.size;
  }
  
  public enum Size {
    SMALL,
    MIDIUM,
    LARGE
  }
  
  public static class Builder extends Pizza.Builder<Builder> {
    private final Size size;
    public Builder(Size size) {
      this.size = Objects.requireNonNull(size);
    }
    @Override
    public NyPizza build() {
      return new NyPizza(this);
    }
    
    @Override
    protected Builder self() {
      return this;
    }
  }
  
  @Override
  public String toString() {
    return "NyPizza{" +
        "size=" + size +
        ", toppingSet=" + toppingSet +
        '}';
  }
}
