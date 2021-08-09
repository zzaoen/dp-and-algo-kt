package com.zzaoen.kt.oo

interface ICanFly { fun can() = "can fly" }
interface ICanEat {
  val name: String
  fun can() = "can eat"
}
class Bird2(override val name: String) : ICanFly, ICanEat {
  // override fun can() = super< ICanEat >.can()
  override fun can() = "can"
}
