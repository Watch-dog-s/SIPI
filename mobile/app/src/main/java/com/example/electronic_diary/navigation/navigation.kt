package com.example.electronic_diary.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.electronic_diary.ViewModel.LoginViewModel
import com.example.electronic_diary.ViewModel.RegisterViewModel
import com.example.electronic_diary.screens.AuthorizationScreen
import com.example.electronic_diary.screens.HomeScreen
import com.example.electronic_diary.screens.MarksScreen
import com.example.electronic_diary.screens.Password_recovery_Screen
import com.example.electronic_diary.screens.Shedule_Screen

@Composable
fun navigation(nav_controller: NavHostController,loginViewModel: LoginViewModel,registerViewModel: RegisterViewModel)
{

    NavHost(
        navController = nav_controller,
        startDestination = Routes.LOGIN) {

        composable(Routes.SHEDULE){Shedule_Screen(nav_controller)}
        composable(Routes.LOGIN){ AuthorizationScreen(nav_controller,loginViewModel) }
        composable(Routes.HOME){ HomeScreen(nav_controller) }
        composable(Routes.PASSWORD_RECOVERY){ Password_recovery_Screen(nav_controller,registerViewModel) }
        composable(Routes.MARKS){ MarksScreen(nav_controller) }

    }
}