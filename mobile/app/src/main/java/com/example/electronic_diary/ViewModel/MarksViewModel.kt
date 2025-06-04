package com.example.electronic_diary.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.electronic_diary.api.dto.MarksRequest
import com.example.electronic_diary.api.dto.MarksResponse
import com.example.electronic_diary.api.dto.Subject
import com.example.electronic_diary.api.dto.SubjectRequest
import com.example.electronic_diary.api.remote.diary.getMarks
import com.example.electronic_diary.api.remote.diary.getSubject
import com.example.electronic_diary.cache.TokenCache
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class MarkData(
    var mark: Double,
    var subject: String

)

class MarksViewModel : ViewModel() {
    private val _marks = MutableStateFlow<List<MarkData>>(getSubjectMarks())

    val marks : StateFlow<List<MarkData>> = _marks

    fun getSubjectMarks() : List<MarkData> {
        val result = mutableListOf<MarkData>()
        val token = TokenCache.token.get(0)

        viewModelScope.launch {
            try {
                val subjectRequest = SubjectRequest(token)
                val subjectsResult: Result<List<Subject>> = getSubject(subjectRequest)

                subjectsResult.onSuccess { subjectList ->
                    for (subject in subjectList) {
                        val marksResult: Result<MarksResponse> = getMarks(MarksRequest(token, subject.id))

                        marksResult.onSuccess { marksResponse ->
                            val marks = marksResponse.marks
                            marks.forEach { mark ->
                                result.add(MarkData(mark = mark.value, subject = subject.name))
                            }
                        }.onFailure { e ->
                            println("Error fetching marks for subject ${subject.name}: ${e.localizedMessage}")
                        }
                    }
                }.onFailure { e ->
                    println("Error fetching subjects: ${e.localizedMessage}")
                }
            } catch (e: Exception) {
                println("Unexpected error: ${e.localizedMessage}")
            }
        }

        return result
    }


}