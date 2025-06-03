package com.example.electronic_diary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.electronic_diary.ViewModel.LoginViewModel
import com.example.electronic_diary.ViewModel.RegisterViewModel
import com.example.electronic_diary.screens.MainScreen
import com.example.electronic_diary.ui.theme.Electronic_diaryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val login1=LoginViewModel()
        val reg1=RegisterViewModel()
        setContent {
            Electronic_diaryTheme {
                val navController = rememberNavController()
                MainScreen(navController,login1,reg1)
                }
            }


        }
}



