package com.mobile.recfood.components.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.mobile.recfood.R

data class Food(
    val id: Int,
    val foodName: String,
    val imageFood: Int
)

fun getMenu(): List<Food> {
    return listOf(
        Food(
            id = 1,
            foodName = "resep Ayam bakar sambel penye enak, gurih dan bikin nagih",
            imageFood = R.drawable.ayam_bakar
        ),
        Food(
            id = 2,
            foodName = "Sushi",
            imageFood = R.drawable.ayam_bakar
        ),
        Food(
            id = 3,
            foodName = "Burger",
            imageFood = R.drawable.ayam_bakar
        ),
        Food(
            id = 4,
            foodName = "Salad",
            imageFood = R.drawable.ayam_bakar
        )
    )
}

@Composable
fun HeaderMenu() {
    val foodItems = getMenu()
    LazyRow(modifier = Modifier
                .padding(top = 40.dp)
    ) {
        items(foodItems) { food ->
            foodItem(food)
        }
    }
}

@Composable
fun foodItem(food: Food) {
    Box(
        modifier = Modifier
            .height(200.dp)
            .width(380.dp)
            .padding(start = 15.dp)
            .clip(RoundedCornerShape(16.dp))
        ,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = food.imageFood),
            contentDescription = null,
            modifier = Modifier
                .width(380.dp)
                .height(200.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f)),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = food.foodName,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp)
            )
            Button(
                onClick = { /* Tindakan ketika tombol diklik */ },
                modifier = Modifier
                    .padding(top = 20.dp, start = 15.dp)
                    .height(35.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFEF2A39),
                    contentColor = Color.White
                )
                ) {
                Text(
                    text = "Lihat Resep",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun prev() {
    Column(modifier = Modifier.fillMaxSize()){
        HeaderMenu()
    }
}
