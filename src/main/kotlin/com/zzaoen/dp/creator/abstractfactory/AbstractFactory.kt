package com.zzaoen.dp.creator.abstractfactory

/**
 * @author Bruce Zhao
 * @date 2021/2/28 17:51
 * type: Button, CheckBox
 * factory: Win, Mac
 */
fun main() {
  val type = 1
  val factory = when (type) {
    0 -> MacFactory()
    else -> WinFactory()
  }
  val button = factory.createButton()
  println(button.click())
}

interface Button {
  fun click(): String
}

interface CheckBox {
  fun check(): String
}

class WinButton : Button {
  override fun click(): String {
    return "Win Button Clicked"
  }
}
class WinCheckBox : CheckBox {
  override fun check(): String {
    return "Win CheckBox Checked"
  }
}

class MacButton : Button {
  override fun click(): String {
    return "Mac Button Clicked"
  }
}
class MacCheckBox : CheckBox {
  override fun check(): String {
    return "Mac CheckBox Checked"
  }
}

interface GUIFactory {
  fun createButton(): Button
  fun createCheckBox(): CheckBox
}

class WinFactory : GUIFactory {
  override fun createButton(): Button {
    return WinButton()
  }

  override fun createCheckBox(): CheckBox {
    return WinCheckBox()
  }
}

class MacFactory : GUIFactory {
  override fun createButton(): Button {
    return MacButton()
  }

  override fun createCheckBox(): CheckBox {
    return MacCheckBox()
  }
}
