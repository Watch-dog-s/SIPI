package com.example.electronic_diary.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Preview
@Composable
fun Marks_Screen_prev(){

    Marks_Screen(navController = rememberNavController())
}


@Composable
fun Marks_Screen(navController: NavHostController){}




