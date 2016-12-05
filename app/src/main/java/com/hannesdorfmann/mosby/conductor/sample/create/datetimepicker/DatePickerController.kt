package com.hannesdorfmann.mosby.conductor.sample.create.datetimepicker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import com.bluelinelabs.conductor.Controller
import com.hannesdorfmann.mosby.conductor.sample.R
import org.threeten.bp.ZonedDateTime

/**
 * A simple controller to pick a Date
 *
 * @author Hannes Dorfmann
 */
class DatePickerController() : Controller() {

  interface DatePickedListner {
    fun onDatePicked(year: Int, month: Int, day: Int)
  }

  private lateinit var listenerController: DatePickedListner

  constructor(listenerController_: DatePickedListner) : this() {
    listenerController = listenerController_
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
    val view = inflater.inflate(R.layout.controller_date_picker, container, false)
    val datePicker = view.findViewById(R.id.datePicker) as DatePicker
    val now = ZonedDateTime.now()
    datePicker.minDate = now.toEpochSecond() * 1000L

    datePicker.init(now.year, now.monthValue, now.dayOfMonth, { calendarView, year, month, day ->
      listenerController.onDatePicked(year, month, day)
    })

    return view
  }
}