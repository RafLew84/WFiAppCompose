package com.example.wfiappcompose.ui.screens

sealed class Screens(val route: String) {
    object ListScreen : Screens("list")
    object DetailScreen : Screens("detail")

    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}