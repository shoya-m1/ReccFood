package com.mobile.recfood.components.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.recfood.R


data class Articles(
    val id: Int,
    val image: Int,
    val title: String
)

fun getArticle(): List<Articles>{
    return listOf(
        Articles(
            id = 0,
            image = R.drawable.img_article,
            title = "10 resep makanan di rumah, tanpa ribet"
        ),
        Articles(
            id = 1,
            image = R.drawable.img_article,
            title = "10 resep makanan di rumah, tanpa ribet"
        ),
        Articles(
            id = 0,
            image = R.drawable.img_article,
            title = "10 resep makanan di rumah, tanpa ribet"
        ),
        Articles(
            id = 0,
            image = R.drawable.img_article,
            title = "10 resep makanan di rumah, tanpa ribet"
        ),
        Articles(
            id = 0,
            image = R.drawable.img_article,
            title = "10 resep makanan di rumah, tanpa ribet"
        ),
        Articles(
            id = 0,
            image = R.drawable.img_article,
            title = "10 resep makanan di rumah, tanpa ribet"
        ),
    )
}

@Composable
fun NewArticles(){
    val listArticles = getArticle()

    Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(horizontal = 15.dp)
    ){
        Text(
            text = "New Articles",
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
            .background(Color.White)
            .fillMaxWidth()
    ) {
        listArticles.forEachIndexed { index, article ->
            ArticleItem(article)

            if (index < listArticles.size - 1) {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }

}

@Composable
fun ArticleItem(article: Articles){
    Row(){
        Image(
            painter = painterResource(id = article.image),
            contentDescription = "img_article",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(150.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Text(
            text = article.title,
            fontWeight = FontWeight.Medium,
            fontSize = 19.sp,
            textAlign = TextAlign.Start,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(horizontal = 15.dp)
        )
    }
}

@Preview
@Composable
private fun prev() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        NewArticles()
    }
}