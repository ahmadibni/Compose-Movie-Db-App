package com.capstone.submissioncompose.ui

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("home/{title}"){
        fun createRoute(title: String) = "home/$title"
    }
    object Profile : Screen("profile")
}