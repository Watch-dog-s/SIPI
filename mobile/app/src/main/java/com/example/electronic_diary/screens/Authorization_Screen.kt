package com.example.electronic_diary.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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


@Preview
@Composable
fun Authorization_prev(){

   // Authorization_Screen(navController = rememberNavController())
}


@Composable
fun Authorization_Screen(navController: NavHostController,LoginViewModel:LoginViewModel) {

    val login by LoginViewModel.login.collectAsState()
    val password by LoginViewModel.password.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    )

    {

        Spacer(modifier = Modifier.height(300.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    TextField(
                        value = login,
                        onValueChange = { newlogin: String -> LoginViewModel.ChangeLogin(newlogin) },
                        maxLines = 1,
                        singleLine = true,
                        placeholder = { Text("Логин") })

                }


                Spacer(modifier = Modifier.height(50.dp))



                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                )
                {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row {
                            TextField(
                                value = password,
                                onValueChange = { newpassword: String ->
                                    LoginViewModel.ChangePassword(newpassword)
                                },
                                maxLines = 1,
                                singleLine = true,
                                placeholder = { Text("Пароль") })
                        }
                    }
                }


                Spacer(modifier = Modifier.height(50.dp))


                // войти
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                )
                {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(onClick = { navController.navigate("To_Home") }) { Text(text = "Войти") }
                    }
                }


                Spacer(modifier = Modifier.height(50.dp))


            }
        }
    }
}