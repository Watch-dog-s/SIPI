package com.example.electronic_diary.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun grades_prev(){

    grades()
}



@Composable
fun grades(){

    Column(modifier = Modifier.fillMaxSize()){

    Row(modifier = Modifier.padding(vertical = 20.dp, horizontal = 10.dp)){
        Text(text="Оценки по предметам")
    }







    }


}





@Composable
fun SubjectsScreen() {
    val subjects: List<Pair<String, List<String>>> = listOf(
        "Математика" to listOf("5", "4", "3","5", "4", "3"),
        "Физика" to listOf("4", "5", "3"),
        "Химия" to listOf("3", "4", "5")
    )

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(subjects.size) { index ->
            val (subject, grades) = subjects[index]
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = subject,
                    modifier = Modifier.weight(1f),
                    fontSize = 18.sp
                )
                Divider(
                    modifier = Modifier
                        .height(24.dp)
                        .width(1.dp),
                    color = Color.Gray
                )
                Text(
                    text = grades.joinToString(", "),
                    modifier = Modifier.weight(1f),
                    fontSize = 18.sp,
                    textAlign = TextAlign.End
                )
            }
        }
    }
}


