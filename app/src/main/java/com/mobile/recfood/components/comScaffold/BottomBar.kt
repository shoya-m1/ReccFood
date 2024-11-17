package com.mobile.recfood.components.comScaffold

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mobile.recfood.R
import com.mobile.recfood.ui.theme.Purple80
import com.mobile.recfood.ui.theme.Primary

@Composable
fun BottomBar(navController: NavController){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {

        Image(
            painter = painterResource(id = R.drawable.bottombar),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
//                .size(70.dp)

        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding( bottom = 10.dp),

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth(0.4f)
            ){
                BottomButtonIcon (
                    iconImage = R.drawable.home_icon,
                    isActive = currentRoute == "home_screen",
                    descrition = "home",
                    onClick = { navController.navigate("home_screen") },
                    size = 23,

                )
                BottomButtonIcon (
                    iconImage = R.drawable.search_icon,
                    isActive = currentRoute == "search",
                    descrition = "search",
                    onClick = { navController.navigate("search") },
                    size = 23,

                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth(0.67f)

            ){
                BottomButtonIcon (
                    iconImage = R.drawable.heart_icon,
                    isActive = currentRoute == "bookmark",
                    descrition = "bookmark",
                    onClick = { navController.navigate("bookmark") },
                    size = 23,

                )
                BottomButtonIcon (
                    iconImage = R.drawable.recipes_icon,
                    isActive = currentRoute == "recipes",
                    descrition = "recipes",
                    onClick = { navController.navigate("recipes") },
                    size = 29,
                )

            }
        }
    }
}

@Composable
fun BottomButtonIcon(
    iconImage: Int,
    isActive: Boolean,
    descrition: String,
    onClick: () -> Unit,
    size: Int
) {
    IconButton(onClick = onClick) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Icon(
                painter = painterResource(id = iconImage),
                contentDescription = descrition,
                tint = White,
                modifier = Modifier
                    .size(size.dp),
            )
            Spacer(modifier = Modifier.height(6.dp))
            if(isActive){
                Icon(
                    painter = painterResource(id = R.drawable.rounded),
                    contentDescription = descrition,
                    tint = White,
                    modifier = Modifier
                        .size(6.dp),
                )
            }
        }
    }
}

@Preview
@Composable
private fun prev() {
    val navController = rememberNavController()
    BottomBar(navController = navController)
}