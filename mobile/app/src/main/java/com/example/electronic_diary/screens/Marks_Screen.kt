package com.example.electronic_diary.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.electronic_diary.ViewModel.MarkData
import com.example.electronic_diary.ViewModel.MarksViewModel

@Composable
fun MarksScreen(
    navController: NavHostController,
    viewModel: MarksViewModel = viewModel()
) {
    val allMarks by viewModel.marks.collectAsState()

    viewModel.setMarks()

    val grouped = allMarks.groupBy { it.subject }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        grouped.forEach { (subject, marks) ->
            item {
                Text(
                    text = subject,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                FullMarkCard(marks)
            }
        }
    }
}

@Composable
fun FullMarkCard(marks: List<MarkData>) {
    LazyRow(modifier = Modifier.padding(start = 8.dp, bottom = 16.dp)) {
        items(marks) { mark ->
            MarkCard(mark)
        }
    }
}

@Composable
fun MarkCard(markData: MarkData) {
    Card(
        modifier = Modifier
            .size(width = 60.dp, height = 80.dp)
            .padding(4.dp)
            .clickable { /* TODO: navigate or show detail */ }
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = markData.mark.toString())
            Text(text = markData.comment, fontSize = 10.sp)
        }
    }
}

@Composable
@Preview
fun PreviewMarksScreen() {
    MarksScreen(navController = rememberNavController())
}
