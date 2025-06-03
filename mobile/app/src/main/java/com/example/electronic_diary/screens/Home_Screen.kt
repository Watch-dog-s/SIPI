package com.example.electronic_diary.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.electronic_diary.R
import com.example.electronic_diary.navigation.Routes

@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        ) {
            val bitmapImage = ImageBitmap.imageResource(id = R.drawable.image1)

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .size(200.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    Text(
                        text = "ФИО",
                        modifier = Modifier
                            .padding(top = 16.dp, end = 3.dp),
                    )

                    Image(
                        bitmap = bitmapImage,
                        contentDescription = "Фото профиля",
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.LightGray)
                            .padding(top = 3.dp)
                            .clickable {
                                navController.navigate(Routes.LOGIN)
                            },
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Text(text = "День рождения у ученика ......")
            Text(text = "Турнир по Доте ......")
        }
    }
}