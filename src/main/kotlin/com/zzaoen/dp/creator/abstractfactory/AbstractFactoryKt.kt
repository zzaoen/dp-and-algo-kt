package com.zzaoen.dp.creator.abstractfactory

import com.zzaoen.kt.log
import java.lang.IllegalArgumentException

/*
 * Author: Bruce Zhao
 * Date: 2020/7/9 21:33
 * Desc:
 */
interface Computer
class Mac : Computer
class Dell : Computer
abstract class AbstractFactory {
  abstract fun produce(): Computer
  companion object {
    inline operator fun <reified T : Computer> invoke(): AbstractFactory {
      return when (T::class) {
        Mac::class -> MacbookFactory()
        Dell::class -> DellFactory()
        else -> throw IllegalArgumentException()
      }
    }
  }
}

class MacbookFactory : AbstractFactory() {
  override fun produce() = Mac()
}

class DellFactory : AbstractFactory() {
  override fun produce() = Dell()
}

fun main() {
  val macFactory = AbstractFactory<Mac>()
  log.info(macFactory.toString())
  println(macFactory is MacbookFactory)
  val mac = macFactory.produce()
  log.info(mac.toString())
}
