package com.zzaoen.dp.creator.factory

/**
 * @author Bruce Zhao
 * @date 2021/2/28 17:33
 */

fun main() {
  val type = MachineType.MAC
  val factory = when (type) {
    MachineType.MAC -> MacFactory()
    MachineType.WIN -> WinFactory()
  }
  factory.doRender()
}

interface Button {
  fun render(): String
}

class WinButton : Button {
  override fun render(): String {
    return "Hello Windows Button"
  }
}

class MacButton : Button {
  override fun render(): String {
    return "Hello Mac Button"
  }
}

enum class MachineType {
  WIN, MAC
}

interface Factory {
  fun doRender() {
    val button = createButton()
    print(button.render())
  }
  fun createButton(): Button
}

class WinFactory : Factory {
  override fun createButton(): Button {
    return WinButton()
  }
}

class MacFactory : Factory {
  override fun createButton(): Button {
    return MacButton()
  }
}
