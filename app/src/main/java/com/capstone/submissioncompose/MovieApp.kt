package com.capstone.submissioncompose

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.capstone.submissioncompose.ui.DetailScreen
import com.capstone.submissioncompose.ui.HomeScreen
import com.capstone.submissioncompose.ui.ProfileScreen
import com.capstone.submissioncompose.ui.Screen
import com.capstone.submissioncompose.ui.theme.SubmissionComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieApp(
    navHostController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        topBar = {
            if (currentRoute == Screen.Home.route) {
                TopAppBar(
                    title = {
                        Text(text = "I EM DE BE")
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navHostController.navigate(route = Screen.Profile.route)
                            },
                        ) {
                            Icon(Icons.Filled.Info, "about_page")
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Yellow)
                )
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navHostController,
            modifier = Modifier.padding(innerPadding),
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { title ->
                        navHostController.navigate(route = Screen.Detail.createRoute(title))
                    }
                )
            }
            composable(
                route = Screen.Detail.route,
                arguments = listOf(navArgument("title") {
                    type = NavType.StringType
                })
            ) {
                val movieTitle = it.arguments?.getString("title") ?: ""
                DetailScreen(
                    title = movieTitle
                )
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MovieAppPreview() {
    SubmissionComposeTheme {
        MovieApp()
    }
}
