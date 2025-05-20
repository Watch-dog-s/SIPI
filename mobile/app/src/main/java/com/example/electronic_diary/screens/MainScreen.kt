package com.example.electronic_diary.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.electronic_diary.Bar.BottomBar
import com.example.electronic_diary.navigation.Routes
import com.example.electronic_diary.navigation.navigation

@Composable
fun MainScreen(navController: NavHostController) {
    val currentRoute = currentRoute(navController)

    // Список экранов с BottomBarом
    val bottomBarRoutes = listOf(
        Routes.HOME,
        Routes.MARKS,
        Routes.SHEDULE,
        Routes.ANALYSIS
    )

    Scaffold(
        bottomBar = {
            if (currentRoute in bottomBarRoutes) {
                BottomBar(navController)
            }
        }
    ) { innerPadding ->
        // Тут мы учитываем отступы (например, из-за BottomBar) и рендерим навигацию
        Box(modifier = Modifier.padding(innerPadding)) {
            navigation(navController)
        }
    }
}




//Эта функция получает весь маршрут, и если пользователь хочет вернуться на прошлый экран, надо проверить, нужно ли отрисовывать нижнее меню
@Composable
private fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}
