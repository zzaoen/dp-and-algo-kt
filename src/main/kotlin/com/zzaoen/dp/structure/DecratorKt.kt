package com.zzaoen.dp.structure

/*
 * Author: Bruce Zhao
 * Date: 2020/7/11 16:33
 * Desc:
 */

interface MacBook {
  fun getPrice(): Int
  fun getMemory(): Int
}
class MacBookPro : MacBook {
  override fun getPrice() = 10000
  override fun getMemory() = 8
}

class UpdateMacBookPro(val macBook: MacBook) : MacBook by macBook {
  override fun getPrice() = macBook.getPrice() + 5000
  override fun getMemory() = macBook.getMemory() + 8
}

fun main() {
  val macBookPro = MacBookPro()
  println(macBookPro.getPrice())

  val newPro = UpdateMacBookPro(macBookPro)
  println(newPro.getPrice())
}
