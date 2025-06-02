package com.example.electronic_diary.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.electronic_diary.R
import com.example.electronic_diary.ViewModel.LoginViewModel
import com.example.electronic_diary.ViewModel.RegisterViewModel
import com.example.electronic_diary.navigation.Routes
import com.example.electronic_diary.navigation.navigation

@Composable
fun MainScreen(navController: NavHostController,loginViewModel: LoginViewModel,registerViewModel: RegisterViewModel) {
    val currentRoute = currentRoute(navController)

    // Список экранов с BottomBarом
    val bottomBarRoutes = listOf(
        Routes.HOME,
        Routes.MARKS,
        Routes.SHEDULE,
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
            navigation(navController,loginViewModel,registerViewModel)
        }
    }
}




//Эта функция получает весь маршрут, и если пользователь хочет вернуться на прошлый экран, надо проверить, нужно ли отрисовывать нижнее меню
@Composable
private fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Composable
fun BottomBar(navController: NavController) {
    BottomAppBar(

        actions = {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                IconButton(onClick = {navController.navigate(Routes.SHEDULE) }) {
                    Icon(
                        painter = painterResource(id = R.drawable.shedule),
                        contentDescription = "",
                        modifier = Modifier.size(60.dp)
                    )
                }
                IconButton(onClick = { navController.navigate(Routes.MARKS) }) {
                    Icon(
                        painter = painterResource(id = R.drawable.analysis),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )
                }
                IconButton(onClick = { navController.navigate(Routes.HOME) }) {
                    Icon(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }

        },

        )
}
