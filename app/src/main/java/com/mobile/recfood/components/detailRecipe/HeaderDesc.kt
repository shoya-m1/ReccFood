package com.mobile.recfood.components.detailRecipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.recfood.R
import com.mobile.recfood.components.Home.Category
import com.mobile.recfood.components.Home.Recipes

data class RecipeDesc(
    val id: Int,
    val title: String,
    val image: Int,
    val features: Features,
    val desc: String,
)

data class Features(
    val time: Int,
    val dificulty: String,
    val kkal: Int
)

fun getRecipeDesc(): RecipeDesc{
    return RecipeDesc(
            id = 0,
            image = R.drawable.ayam_geprek,
            title = "ayam bakar ala mak nyus",
            features = Features(time = 120, dificulty = "mudah", kkal = 80),
            desc = "Masih banyak sayuran sisa di kulkas? Yuk, bikin sayur asem rumahan yang kuahnya menyegarkan! Kamu jadi bisa mengolah sisa labu siam, terong, kacang panjang, atau jagung manis dalam kulkas sebelum layu. Cocok dipadukan dengan lauk sederhana seperti tempe bacem, ayam goreng, atau aneka pepes"
    )
}

@Composable
fun HeaderDesc(){
    val recipeDesc = getRecipeDesc()

    Column(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
        .background(Color.White)
        .padding(top = 25.dp, bottom = 30.dp , start = 15.dp, end = 15.dp)



    ){
        Text(
            text = recipeDesc.title,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
            )
        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier.fillMaxWidth(1f),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ){
                Image(
                    painter = painterResource(id = R.drawable.time_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
                Text(text = "${recipeDesc.features.time}",
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp)
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ){
                Image(
                    painter = painterResource(id = R.drawable.difficulty_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
                Text(text = "${recipeDesc.features.dificulty}",
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp)
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.kcal_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
                Text(text = "${recipeDesc.features.kkal}",
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp)
            }
        }
        Spacer(modifier = Modifier.height(23.dp))

        Text(
            text = recipeDesc.desc,
            color = Color.DarkGray,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview
@Composable
private fun prev() {
    Column(modifier = Modifier
//        .fillMaxSize()
//        .background(Color.White)
    ){
        HeaderDesc()
    }
}