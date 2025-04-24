package com.example.electronic_diary.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Preview
@Composable
fun Home_Screen_prev(){
    Home_Screen(navController = rememberNavController())
}



@Composable
fun Home_Screen(navController: NavHostController){
    Box(modifier = Modifier
        .fillMaxSize()
    )
    {
        Text(text="Это домашний скрин")
    }

}