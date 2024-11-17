package com.mobile.recfood.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
//import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mobile.recfood.components.Home.Category
import com.mobile.recfood.components.Home.HeaderMenu
import com.mobile.recfood.components.Home.NewArticles
import com.mobile.recfood.components.Home.NewRecipes
import com.mobile.recfood.components.comScaffold.TopBar

@Composable
fun HomeScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        item { TopBar() }
        item { HeaderMenu() }
        item { Category() }
        item {Spacer(modifier = Modifier.height(40.dp))}
        item { NewRecipes(navController) }
        item {Spacer(modifier = Modifier.height(40.dp))}
        item { NewArticles() }
        item {Spacer(modifier = Modifier.height(120.dp))}

    }


}


@Preview
@Composable
private fun Prev() {
    val navController = rememberNavController()
    HomeScreen(navController)
}