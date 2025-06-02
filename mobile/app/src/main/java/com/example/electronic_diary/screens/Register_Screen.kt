package com.example.electronic_diary.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.electronic_diary.ViewModel.RegisterViewModel
import com.example.electronic_diary.navigation.Routes

@Composable
fun Password_recovery_Screen(
    navController: NavHostController,
    registerViewModel:RegisterViewModel)
{

    val login by registerViewModel.login.collectAsState()
    val email by registerViewModel.email.collectAsState()
    val password by registerViewModel.password.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        Text(text = "Регистрация");

        Spacer(modifier = Modifier.height(15.dp))
        TextField(
            value = login,
            placeholder = {Text(text = "Логин...")},
            onValueChange = {
                newlogin:String -> registerViewModel.ChangeLogin(newlogin)
            }
        )


        Spacer(modifier = Modifier.height(15.dp))
        TextField(
            value = email,
            placeholder = {Text(text = "Почта...")},
            onValueChange = {
                newEmail:String -> registerViewModel.ChangeEmail(newEmail)
            }
        )

        Spacer(modifier = Modifier.height(15.dp))
        TextField(
            value = password,
            placeholder = {Text(text = "Пароль...")},
            onValueChange = {
                newPassword:String ->registerViewModel.ChangePassword(newPassword)
            }
        )


        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = {
                registerViewModel.letRegister()
            }
        ) {
            Text(text="Зарегестрироваться")
        }

        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = {navController.navigate(Routes.LOGIN)}) { Text(text="Авторизация") }

    }
}