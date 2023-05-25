package com.example.wfiappcompose.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.wfiappcompose.ui.screens.DetailView
import com.example.wfiappcompose.ui.screens.InstituteList
import com.example.wfiappcompose.ui.screens.Screens

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.ListScreen.route) {

        composable(route = Screens.ListScreen.route ) {
            InstituteList{navController.navigate(Screens.DetailScreen.withArgs(it.toString()))}
        }

        composable(
            route = Screens.DetailScreen.route + "/{index}",
            arguments = listOf(navArgument("index") {
            type = NavType.StringType
        })) {
            DetailView(id = it.arguments?.getString("index"))
        }
    }
}