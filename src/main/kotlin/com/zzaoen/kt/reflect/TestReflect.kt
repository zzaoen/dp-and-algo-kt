package com.zzaoen.kt.reflect

import com.zzaoen.kt.logStr
import kotlin.reflect.KProperty
import kotlin.reflect.full.memberProperties

data class User(val name: String, val age: Int)

object Mapper {
  fun <T : Any> toMap(t: T) =
    t::class.memberProperties.map { m ->
      val p = m as KProperty<*>
      p.name to p.call(t)
    }.toMap()
}

fun main() {
  val toMap: Map<String, Any?> = Mapper.toMap(User(name = "Bruce", age = 27))
  logStr(toMap.toString())
}
