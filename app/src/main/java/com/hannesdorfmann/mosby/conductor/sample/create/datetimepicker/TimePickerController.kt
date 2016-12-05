package com.hannesdorfmann.mosby.conductor.sample.create.datetimepicker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import com.bluelinelabs.conductor.Controller
import com.hannesdorfmann.mosby.conductor.sample.R

/**
 * A simple controller to pick a Date
 *
 * @author Hannes Dorfmann
 */
class TimePickerController() : Controller() {

  interface TimePickedListner {
    fun onTimePicked(hour: Int, minute: Int)
  }

  private lateinit var listenerController: TimePickedListner

  constructor(listenerController_: TimePickedListner) : this() {
    listenerController = listenerController_
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
    val view = inflater.inflate(R.layout.controller_time_picker, container, false)
    val timePicker = view.findViewById(R.id.timePicker) as TimePicker
    timePicker.setOnTimeChangedListener { timePicker, hour, minute ->
      listenerController.onTimePicked(hour, minute)
    }
    return view
  }
}