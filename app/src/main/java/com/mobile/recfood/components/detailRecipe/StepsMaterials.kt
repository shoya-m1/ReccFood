package com.mobile.recfood.components.detailRecipe

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

// Data Bahan
data class Ingredients(
    val servings: Int,
    val ingredientList: List<Ingredient>
)
data class Ingredient(
    val quantity: String,
    val ingredient: String
)

// Data Steps
data class Steps(
    val step: String
)

fun getIngredients(): Ingredients {
    return Ingredients(
        servings = 4,
        ingredientList = listOf(
            Ingredient(quantity = "2", ingredient = "ekor ayam (@600-700 g), potong 4 bagian"),
            Ingredient(quantity = "7", ingredient = "lembar daun jeruk"),
            Ingredient(quantity = "3", ingredient = "batang serai, memarkan"),
            Ingredient(quantity = "1/2", ingredient = "lembar daun salam")
        )
    )
}

fun getSteps(): List<Steps> {
    return listOf(
        Steps(step = "Siapkan wajan, masukkan potongan daging ayam, bumbu halus beserta air. Tambahkan daun jeruk, serai, dan daun salam."),
        Steps(step = "Masak hingga mendidih. Tambahkan Royco Kaldu Ayam dan lengkuas."),
        Steps(step = "Aduk-aduk hingga bumbu meresap dan ayam matang."),
        Steps(step = "Angkat dan sajikan hangat.")
    )
}

@Composable
fun StepsMaterials() {
    val baseIngredients = getIngredients() // Ambil data bahan awal
    var selectedTab by remember { mutableStateOf("Bahan") }
    val initialServings = baseIngredients.servings
    var servings by remember { mutableStateOf(initialServings) } // Default porsi awal
    val steps = getSteps()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color.LightGray.copy(alpha = 0.2f)),

            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight(1f),
                onClick = { selectedTab = "Bahan" },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedTab == "Bahan") Color(0xFFEF2A39) else Color.Transparent,

                )
            ) {
                Text(text = "Bahan",
                    color = if (selectedTab == "Bahan") Color.White else Color.Gray,
                    fontSize = 18.sp)
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight(1f),
                onClick = { selectedTab = "CaraMasak" },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedTab == "Cara Masak") Color(0xFFEF2A39) else Color.Transparent,

                )
            ) {
                Text(text = "Cara Masak",
                    color = if (selectedTab == "Cara Masak") Color.White else Color.Gray,
                    fontSize = 18.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (selectedTab == "Bahan") {
            PorsiSetting(servings = servings, initialServings = initialServings) { newServings ->
                servings = newServings
            }
            Spacer(modifier = Modifier.height(10.dp))

            BahanResep(baseIngredients = baseIngredients.ingredientList, servings = servings, initialServings = initialServings)
        }  else {
            ListResep(steps = steps)
        }
    }
}

@Composable
fun PorsiSetting(servings: Int, initialServings: Int, onServingsChanged: (Int) -> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(Color.LightGray.copy(alpha = 0.2f))
            .padding(horizontal = 20.dp),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Porsi : ", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.DarkGray)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(0.75f),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ){
            Button(
                onClick = { if (servings > initialServings)  onServingsChanged(servings - initialServings) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,)
            ){
                Icon(painter = painterResource(id = R.drawable.min_icon),
                    contentDescription = "Kurang Porsi",
                    tint = Color(0xFFEF2A39)
                )
            }
            Text(text = "$servings", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Button(onClick = {onServingsChanged(servings + initialServings) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,)) {
                Icon(painter = painterResource(id = R.drawable.add_icon),
                    contentDescription = "Tambah Porsi",
                    tint = Color(0xFFEF2A39)
                )
            }
        }

    }
}

@Composable
fun BahanResep(baseIngredients: List<Ingredient>, servings: Int, initialServings: Int){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        baseIngredients.forEach { item ->
            val numericQuantity = item.quantity.toDoubleOrNull() ?: 0.5
            val adjustedQuantity = numericQuantity * (servings / initialServings.toDouble())

            val quantityValue = if (adjustedQuantity % 1 == 0.0) {
                adjustedQuantity.toInt().toString()
            } else {
                adjustedQuantity.toString()
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = quantityValue,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    color = Color(0xFFEF2A39),
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = item.ingredient,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    color = Color.DarkGray
                )
            }
        }
    }
}

@Composable
fun ListResep(steps: List<Steps>){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        steps.forEachIndexed { index, step ->
            Row(modifier = Modifier
                .padding(vertical = 6.dp),

                ){
                Text(
                    text = "${index + 1}",
                    modifier = Modifier.padding(horizontal = 8.dp),
                    fontSize = 18.sp,
                )

                Text(
                    text = "${step.step}",
                    textAlign = TextAlign.Justify,
                    fontSize = 18.sp,

                    )
            }
        }
    }
}

@Preview
@Composable
private fun prev() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ){
        StepsMaterials()
    }
}
