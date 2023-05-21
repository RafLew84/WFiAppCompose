package com.example.wfiappcompose.ui.screens

sealed class Screens(val route: String) {
    object ListScreen : Screens("list")
    object DetailScreen : Screens("detail")
}