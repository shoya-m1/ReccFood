package com.mobile.recfood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.mobile.recfood.navigations.Routes
import com.mobile.recfood.screens.HomeScreen
import com.mobile.recfood.ui.theme.RecfoodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecfoodTheme {
               Routes()
            }
        }
    }
}

@Preview
@Composable
private fun prev() {
    val navController = rememberNavController()
    RecfoodTheme {
        Routes()
    }
}

