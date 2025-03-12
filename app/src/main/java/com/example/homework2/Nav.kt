package com.example.homework2

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = "booklist", modifier = modifier
    ) {
        composable(route = "booklist") {
            BookListUI(navController, modifier)
        }
        composable(route = "statistics") {
            BookStatisticsUI(navController, modifier)
        }
        composable(route = "appinfo") {
            AppInfoUI(navController, modifier)
        }
    }
}