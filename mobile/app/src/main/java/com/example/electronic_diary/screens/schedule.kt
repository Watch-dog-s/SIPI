package com.example.electronic_diary.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun schedule_prev(){

    shedule()
}



@Composable
fun shedule(){

    Column(modifier = Modifier.fillMaxSize()){

    Row(modifier = Modifier.padding(vertical = 20.dp, horizontal = 10.dp)){
        Text(text="День недели")
        Spacer(modifier = Modifier.padding(horizontal = 55.dp))
        Text(text="Число")
    }



    }


}


@Composable
fun subject(){
    Row(modifier = Modifier.padding(vertical = 20.dp, horizontal = 10.dp)) {


    }
}