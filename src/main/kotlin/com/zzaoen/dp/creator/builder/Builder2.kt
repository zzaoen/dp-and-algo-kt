package com.zzaoen.dp.creator.builder

/**
 * @author Bruce Zhao
 * @date 2021/3/1 15:03
 */

fun main() {
  val director = Director2()
  val s5Builder = Car2.CarBuilder2()

  director.constructAudiS5(s5Builder)
  val car: Car2 = s5Builder.build()
  println(car)

  val manualBuilder = CarManual2.CarManualBuilder2()
  director.constructAudiS5(manualBuilder)
  val manual = manualBuilder.build()
  manual.print()
}

interface Builder2 {
  fun setType(type: String)
  fun setSeats(seats: Int)
  fun setEngine(engine: String)
}

data class Car2(val type: String, val seats: Int, val engine: String) {
  class CarBuilder2 : Builder2 {
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
    fun build() = Car2(type, seats ?: 0, engine)
  }
}
data class CarManual2(val type: String, val seats: Int? = null, val engine: String? = null) {
  class CarManualBuilder2 : Builder2 {
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
    fun build() = CarManual2(type ?: "")
  }
  fun print() {
    println(toString())
  }
}

class Director2 {
  fun constructAudiS5(builder: Builder2) {
    builder.setType("Audi S5 sportback")
    builder.setSeats(5)
    builder.setEngine("v8")
  }
  fun constructBenzAmg(builder: Builder2) {
    builder.setType("Benz Amg")
    builder.setSeats(4)
    builder.setEngine("v8")
  }
}
