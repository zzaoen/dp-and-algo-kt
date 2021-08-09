package com.zzaoen.dp.creator.builder

/**
 * @author Bruce Zhao
 * @date 2021/3/1 15:03
 */

fun main() {
  val director = Director()
  val s5Builder = CarBuilder()

  director.constructAudiS5(s5Builder)
  val car: Car = s5Builder.build()
  println(car)

  val manualBuilder = CarManualBuilder()
  director.constructAudiS5(manualBuilder)
  val manual = manualBuilder.build()
  manual.print()
}

interface Builder {
  fun setType(type: String)
  fun setSeats(seats: Int)
  fun setEngine(engine: String)
}

class CarBuilder : Builder {
  private lateinit var type: String
  private var seats: Int? = null
  private lateinit var engine: String
  override fun setType(type: String) {
    this.type = type
  }
  override fun setSeats(seats: Int) {
    this.seats = seats
  }
  override fun setEngine(engine: String) {
    this.engine = engine
  }
  fun build() = Car(type, seats ?: 0, engine)
}
class CarManualBuilder : Builder {
  private var type: String? = null
  private var seats: Int? = null
  private var engine: String? = null
  override fun setType(type: String) {
    this.type = type
  }
  override fun setSeats(seats: Int) {
    this.seats = seats
  }
  override fun setEngine(engine: String) {
    this.engine = engine
  }
  fun build() = CarManual(type ?: "")
}

data class Car(val type: String, val seats: Int, val engine: String)
data class CarManual(val type: String, val seats: Int? = null, val engine: String? = null) {
  fun print() {
    println(toString())
  }
}

class Director {
  fun constructAudiS5(builder: Builder) {
    builder.setType("Audi S5 sportback")
    builder.setSeats(5)
    builder.setEngine("v8")
  }
  fun constructBenzAmg(builder: Builder) {
    builder.setType("Benz Amg")
    builder.setSeats(4)
    builder.setEngine("v8")
  }
}
