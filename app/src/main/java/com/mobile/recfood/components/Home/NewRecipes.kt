package com.mobile.recfood.components.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mobile.recfood.R
import com.mobile.recfood.ViewModel.ReccfoodViewModel
import com.mobile.recfood.model.Recipe

data class Recipes(
    val id: Int,
    val image: Int,
    val title: String,
    val features: Features
)

data class Features(
    val time: Int,
    val dificulty: String,
    val kkal: Int

)

fun getRecipes(): List<Recipes>{
    return listOf(
        Recipes(
            id = 0,
            image = R.drawable.ayam_geprek,
            title = "ayam bakar ala mak nyus, ayam bakar ala mak nyus,  ",
            features = Features(time = 120, dificulty = "mudah", kkal = 80)
        ),
        Recipes(
            id = 1,
            image = R.drawable.ayam_bakar,
            title = "ayam bakar ala mak nyus, ",
            features = Features(time = 120, dificulty = "mudah", kkal = 80)
        ),
        Recipes(
            id = 2,
            image = R.drawable.ayam_bakar,
            title = "ayam bakar ala mak nyus",
            features = Features(time = 120, dificulty = "mudah", kkal = 80)
        ),
        Recipes(
            id = 3,
            image = R.drawable.ayam_bakar,
            title = "ayam bakar ala mak nyus",
            features = Features(time = 120, dificulty = "mudah", kkal = 80)
        ),
        Recipes(
            id = 4,
            image = R.drawable.ayam_bakar,
            title = "ayam bakar ala mak nyus",
            features = Features(time = 120, dificulty = "mudah", kkal = 80)
        ),
        Recipes(
            id = 5,
            image = R.drawable.ayam_bakar,
            title = "ayam bakar ala mak nyus",
            features = Features(time = 120, dificulty = "mudah", kkal = 80)
        ),
        Recipes(
            id = 6,
            image = R.drawable.ayam_bakar,
            title = "ayam bakar ala mak nyus",
            features = Features(time = 120, dificulty = "mudah", kkal = 80)
        ),
        Recipes(
            id = 7,
            image = R.drawable.ayam_bakar,
            title = "ayam bakar ala mak nyus",
            features = Features(time = 120, dificulty = "mudah", kkal = 80)
        ),
        Recipes(
            id = 8,
            image = R.drawable.ayam_bakar,
            title = "ayam bakar ala mak nyus",
            features = Features(time = 120, dificulty = "mudah", kkal = 80)
        )
    )
}

@Composable
fun NewRecipes(navController: NavController){
    val recipes = getRecipes()
//    val reccfoodViewModel: ReccfoodViewModel = viewModel()
//    val recipeList by reccfoodViewModel.recipeList.collectAsState()
//    val isLoading by reccfoodViewModel.isLoading.collectAsState()


    Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(horizontal = 15.dp)
    ){
        Text(
            text = "New Recipes",
            color = Color.DarkGray,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )
        Row(verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text = "View all",
                color = Color(0xFFEF2A39),
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )
            Icon(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = null,
                tint = Color.Red
            )
        }

    }
    Spacer(modifier = Modifier.height(20.dp))

    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp)
    ) {
        if (recipes.isNotEmpty()) {
            recipes.chunked(2).forEach { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    rowItems.forEach { recipe ->
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .wrapContentHeight()
                        ) {
                            RecipeItem(recipe = recipe, navController)
                        }
                    }

                    if (rowItems.size < 2) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
            }
        } else {
            // Tampilkan pesan jika tidak ada data
            Text(text = "No recipes available", modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }

}

@Composable
fun RecipeItem(recipe: Recipes, navController: NavController) {

    ElevatedCard(
        modifier = Modifier
            .padding(0.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column (
            verticalArrangement = Arrangement.SpaceBetween

        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth(1f),
                contentAlignment = Alignment.TopEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ayam_bakar),
                    contentDescription = "img_food",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                )
                Box(modifier = Modifier
                    .size(35.dp)
                    .padding(end = 10.dp, top = 10.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White),
                    contentAlignment = Alignment.Center

                ){
                    Image(
                        painter = painterResource(id = R.drawable.red_heart_icon),
                        contentDescription = "heart",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
//                            .fillMaxWidth()
                            .size(15.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Text(
                    text = "${recipe.features.time}Manit",
//                    text = "Manit",
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFFEF2A39),
                    fontSize = 10.sp
                )
                Text(
                    text = "${recipe.features.dificulty}",
//                    text = "Manit",
                    color = Color(0xFFEF2A39),
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp
                )
                Text(
                    text = "${recipe.features.kkal} kkal",
//                    text = "Manit",
                    color = Color(0xFFEF2A39),
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp
                )

            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = recipe.title,
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(bottom = 15.dp, start = 10.dp, end = 15.dp)
                    .clickable {
                        navController.navigate("detail_recipe")
                    }

            )

        }
    }
}

@Preview
@Composable
private fun prev() {
    val navController = rememberNavController()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        NewRecipes(navController)
    }
}

