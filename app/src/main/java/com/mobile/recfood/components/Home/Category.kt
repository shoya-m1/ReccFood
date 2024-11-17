package com.mobile.recfood.components.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class Categorys(
    val id: Int,
    val name: String,
    val url: String,
    val isActive: MutableState<Boolean> = mutableStateOf(false)
)

fun getCategory():List<Categorys>{
    return listOf(
        Categorys(
            id = 0,
            name = "All",
            url = "Semua",
            isActive = mutableStateOf(true)
        ),
        Categorys(
            id = 1,
            name = "Sarapan",
            url = "sarapan",
            isActive = mutableStateOf(false)
        ),
        Categorys(
            id = 2,
            name = "Makan Malam",
            url = "Makan_malam",
            isActive = mutableStateOf(false)
        ),
        Categorys(
            id = 3,
            name = "Makan Siang",
            url = "Makan_siang",
            isActive = mutableStateOf(false)
        ),
        Categorys(
            id = 4,
            name = "Masakan Hari Raya",
            url = "masakan_hari_raya",
            isActive = mutableStateOf(false)
        ),
        Categorys(
            id = 5,
            name = "Masakan Keluarga",
            url = "masakan_keluarga",
            isActive = mutableStateOf(false)
        )
    )
}

@Composable
fun Category(){
    val categorysItems = getCategory()
    LazyRow(modifier = Modifier
        .padding(top = 40.dp, start = 15.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        items(categorysItems) { category ->
            categoryItem(category)
        }
    }
}


@Composable
fun categoryItem(category: Categorys){

    val isActived = category.isActive.value
    val backgroundColor = if (isActived ) Color(0xFFEF2A39) else Color.Black.copy(alpha = 0.1f)
    val textColor = if (isActived ) Color.White else Color.Black.copy(alpha = 0.5f)

    Box( modifier = Modifier
        .height(50.dp)
        .wrapContentWidth()
        .clip(RoundedCornerShape(20.dp))
        .background(backgroundColor),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = category.name,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            color = textColor,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
            )
    }

}

@Preview
@Composable
private fun prev() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ){
        Category()
    }
}
