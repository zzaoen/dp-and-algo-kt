package com.zzaoen.dp.behavior.observer

import java.util.Observable
import java.util.Observer

/*
 * Author: Bruce Zhao
 * Date: 2020/7/11 13:29
 * Desc:
 */

class StockUpdate : Observable() {
  val observers = mutableSetOf<Observer>()
  fun setStockChanged(price: Int) {
    observers.forEach {
      it.update(this, price)
    }
  }
}
class StockDisplay(val name: String) : Observer {
  override fun update(o: Observable, price: Any) {
    if (o is StockUpdate) {
      println("$name Got update price: $price")
    }
  }
}
fun main() {
  val su = StockUpdate()
  val sd1 = StockDisplay("sd1")
  val sd2 = StockDisplay("sd2")
  su.observers.addAll(arrayOf(sd1, sd2))
  su.setStockChanged(100)
}
