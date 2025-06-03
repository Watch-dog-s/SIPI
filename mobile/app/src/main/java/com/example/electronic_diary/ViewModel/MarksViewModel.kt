package com.example.electronic_diary.ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

enum class Type { HomeWork, Answer, Test, MegaTEst }

data class MarkData(
    var mark:Int,
    var Type1:Type,
    var comment:String,
    var Teacher: String,
    var subject: String

)

var t = Type.Answer
var mark1 = MarkData( 5, t, "Отлично", "Путуридзе", "Математика")


var AllSubject= listOf("Матан","Линал")
val Allmarks = listOf(
    MarkData( 5, Type.Answer, "Отлично", "Путуридзе", "Математика"),
    MarkData( 4, Type.Test, "Хорошо", "Сидоров", "Математика"),
    MarkData( 3, Type.HomeWork, "Удовлетворительно", "Иванова", "Линал"),
    MarkData( 5, Type.MegaTEst, "Супер", "Петров", "Линал")
)


class MarksViewModel : ViewModel() {
    private val _marks = MutableStateFlow<List<MarkData>>(Allmarks)

    val marks : StateFlow<List<MarkData>> = _marks
}