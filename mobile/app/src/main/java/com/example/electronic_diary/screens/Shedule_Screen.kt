package com.example.electronic_diary.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.electronic_diary.ViewModel.ScheduleViewModel
import androidx.compose.runtime.getValue

@Composable
fun Shedule_Screen(
    navController: NavHostController,
    scheduleViewModel: ScheduleViewModel = viewModel()
) {
    val scheduleList by scheduleViewModel.scheduleList.collectAsState(initial = emptyList())

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        scheduleList.forEach { item ->
            Subject(
                subject = item.subject,
                room = item.room,
                teacher = item.teacher,
                time = item.time
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun Subject(subject:String,   room:String, teacher:String    ,time:String){

    Column(modifier = Modifier.fillMaxWidth().border(width = 2.dp, color = Color.Black).padding(4.dp)) {
        Text(text=subject)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
            Text(text=room)

        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
            Text(text=teacher)
            Text(text=time)
        }
    }

}