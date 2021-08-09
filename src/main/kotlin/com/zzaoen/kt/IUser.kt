package com.zzaoen.kt

/**
 * @author: Bruce Zhao
 * @date: 2020/12/19 20:39
 * @desc:
 */
interface IUser {
  val name: String
  val email: String
    get() = name.substringBefore("@")
}
