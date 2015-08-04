package com.github.tamaki.study.yoda.impl

import org.joda.time.DateTime

/**
 * Created by yohei.oda on 15/07/31.
 */
class ImplicitJodaTime {
  val now = new DateTime()
  val tomorrow = now + 1.day

  implicit class RichDay(int: Int) {
    val value = int

    def day = {
      new RichDay(value)
    }
  }

  implicit class RichDateTime(dateTime: DateTime) {
    val value = dateTime

    def +(richDay: RichDay) = {
      dateTime.plusDays(richDay.value)
    }
  }

}
