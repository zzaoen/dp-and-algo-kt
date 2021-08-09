package com.zzaoen.dp.behavior.observer

import kotlin.properties.Delegates

/*
 * Author: Bruce Zhao
 * Date: 2020/7/11 13:37
 * Desc:
 */

interface IStockUpdateListener {
  fun onRise(price: Int)
  fun onFall(price: Int)
}
class StockDisplay2 : IStockUpdateListener {
  override fun onRise(price: Int) {
    println("$this, price on rise: $price")
  }
  override fun onFall(price: Int) {
    println("$this, price on fall: $price")
  }
}
class StockUpdate2 {
  val listener = mutableListOf<IStockUpdateListener>()
  var price: Int by Delegates.observable(101) { _, old, new ->
    listener.forEach {
      if (old < new) it.onRise(price) else it.onFall(price)
    }
  }
}

fun main() {
  val su = StockUpdate2()
  val sd1 = StockDisplay2()
  val sd2 = StockDisplay2()
  su.listener.add(sd1)
  su.listener.add(sd2)
  su.price = 100
  su.price = 98
}
