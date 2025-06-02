package com.example.electronic_diary.ViewModel

import androidx.compose.runtime.mutableStateOf
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


val Allmarks = listOf(
    MarkData( 5, Type.Answer, "Отлично", "Путуридзе", "Математика"),
    MarkData( 4, Type.Test, "Хорошо", "Сидоров", "Математика"),
    MarkData( 3, Type.HomeWork, "Удовлетворительно", "Иванова", "Линал"),
    MarkData( 5, Type.MegaTEst, "Супер", "Петров", "Линал")
)

class MarksViewModel : ViewModel()
{
    private val _marks = MutableStateFlow<List<MarkData>>(emptyList())

    val marks : StateFlow<List<MarkData>> = _marks

    fun setMarks() {
        _marks.value = Allmarks
    }
}
