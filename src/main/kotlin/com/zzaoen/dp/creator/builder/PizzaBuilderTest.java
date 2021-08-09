package com.zzaoen.dp.creator.builder;

/**
 * @author: Bruce Zhao
 * @date: 2020/11/6 22:23
 * @desc:
 */
public class PizzaBuilderTest {
  public static void main(String[] args) {
    NyPizza nyPizza =
        new NyPizza.Builder(NyPizza.Size.MIDIUM)
            .addTopping(Pizza.Topping.SUGER)
            .addTopping(Pizza.Topping.ONION)
            .build();
    System.out.println(nyPizza.toppingSet.size());
    System.out.println(nyPizza.toString());
  }
}
