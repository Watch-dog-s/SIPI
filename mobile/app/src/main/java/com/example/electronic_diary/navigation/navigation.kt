package com.example.electronic_diary.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.electronic_diary.screens.Authorization

@Composable
fun navigation(nav_controller: NavHostController)
{
    NavHost(
        navController = nav_controller,
        startDestination = "To_Authorization") {

        composable("To_Authorization"){ Authorization(nav_controller) }



    }
}