package com.example.electronic_diary.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Preview
@Composable
fun Password_Recovery_Screen_Prev(){
    Password_recovery_Screen(navController = rememberNavController())
}


@Composable
fun Password_recovery_Screen(navController: NavHostController){}