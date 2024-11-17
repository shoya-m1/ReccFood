package com.mobile.recfood.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.navigation.NavController
import com.mobile.recfood.R
import com.mobile.recfood.components.detailRecipe.HeaderDesc
import com.mobile.recfood.components.detailRecipe.StepsMaterials
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
fun DetailRecipe(){
    val scrollState = rememberScrollState()

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ayam_geprek),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .graphicsLayer {
                    translationY = scrollState.value * 0.5f
                }
        )

        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxSize()
                .clip(RoundedCornerShape(30.dp))
        ) {
            Spacer(modifier = Modifier.height(250.dp)) // Tinggi yang sama dengan gambar latar belakang

            // Konten utama
            HeaderDesc()
            StepsMaterials()
        }
    }

}

@Preview
@Composable
private fun prev() {
    Column(modifier = Modifier
//        .fillMaxSize()

    ){
        DetailRecipe()
    }
}