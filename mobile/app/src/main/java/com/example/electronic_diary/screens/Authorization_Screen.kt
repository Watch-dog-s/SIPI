package com.example.electronic_diary.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.electronic_diary.ViewModel.LoginViewModel
import com.example.electronic_diary.navigation.Routes

@Composable
fun Authorization_Screen(navController: NavHostController, loginViewModel: LoginViewModel)
 {
     val login by loginViewModel.login.collectAsState()
     val password by loginViewModel.password.collectAsState()
     val loginSuccess by loginViewModel.loginSuccess.collectAsState()

     if(loginSuccess){
         navController.navigate(Routes.HOME)
         loginViewModel.changeLoginState()
     }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(300.dp))

        TextField(
            value = login,
            onValueChange = { loginViewModel.ChangeLogin(it) },
            maxLines = 1,
            singleLine = true,
            placeholder = { Text("Логин") }
        )

        Spacer(modifier = Modifier.height(50.dp))

        TextField(
            value = password,
            onValueChange = { loginViewModel.ChangePassword(it) },
            maxLines = 1,
            singleLine = true,
            placeholder = { Text("Пароль") }
        )

        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = {
            loginViewModel.login()
        }) {
            Text(text = "Войти")
        }

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = {
                Log.d("NavDebug", "Переход на регистрацию")
                navController.navigate(Routes.PASSWORD_RECOVERY)
            }) {
            Text(text = "Регистрация")
        }
    }


}