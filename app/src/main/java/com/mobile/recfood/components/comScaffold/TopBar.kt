package com.mobile.recfood.components.comScaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.recfood.R


@Composable
fun TopBar(){
    Column(
        modifier = Modifier
        .background(color =  Color.White)
        .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        )

    {
        Image(
            painter = painterResource(id = R.drawable.reccfood),
            contentDescription = "logo",
            modifier = Modifier
                .fillMaxWidth()
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)

        ){
            Text(
                text = "What do you want to cook today",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFCCC2DC)
                )
            )
        }

    }
}
@Preview
@Composable
private fun prev() {
    TopBar()
}