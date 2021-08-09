package com.zzaoen.dp.behavior.observer

import java.util.Observable
import java.util.Observer

/**
 * @author Bruce Zhao
 * @date 2021/3/15 14:30
 */

fun main() {
  val classRoom = ClassRoom.getInstance()
  classRoom.addObserver(Teacher("A"))
  classRoom.addObserver(Teacher("B"))

  classRoom.publishNotification(Question("Bruce", 100))
}

data class Question(val studentName: String, val money: Int)

class ClassRoom private constructor() : Observable() {
  companion object {
    private var instance: ClassRoom? = null
    fun getInstance(): ClassRoom {
      if (instance == null) {
        instance = ClassRoom()
      }
      return instance!!
    }
  }

  fun publishNotification(question: Question) {
    setChanged()
    notifyObservers(question)
  }
}

class Teacher(val name: String) : Observer {
  override fun update(o: Observable?, arg: Any?) {
    val question = arg as Question
    println("Teacher: $name, ${question.studentName} ask your question, you can get ${question.money}")
  }
}
