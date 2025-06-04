package com.example.electronic_diary.ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class ScheduleItem(
    val subject: String,
    val room: String,
    val teacher: String,
    val time: String
)

class ScheduleViewModel : ViewModel(){

    private val _scheduleList = MutableStateFlow<List<ScheduleItem>>(emptyList())

    val scheduleList : StateFlow<List<ScheduleItem>> = _scheduleList

}