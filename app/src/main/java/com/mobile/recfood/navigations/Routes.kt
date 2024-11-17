package com.mobile.recfood.navigations

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mobile.recfood.components.comScaffold.BottomBar
import com.mobile.recfood.screens.DetailRecipe
//import com.mobile.recfood.components.comScaffold.BottomBar

import com.mobile.recfood.screens.HomeScreen

@Composable
fun Routes(navController: NavHostController = rememberNavController()) {
    val currentRoute = navController.currentBackStackEntryAsState()?.value?.destination?.route

    Scaffold(
        modifier = Modifier
            .padding(start = 0.dp),
        bottomBar = { BottomBar(navController) } // bottomBar sebaiknya berupa lambda
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home_screen",
            modifier = Modifier
                .fillMaxWidth(1f)
        ) {
            composable("home_screen") { HomeScreen(navController) }
            composable("detail_recipe") { DetailRecipe() }
        }
    }
}
