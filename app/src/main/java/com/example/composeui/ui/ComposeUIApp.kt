package com.example.composeui.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeui.ui.screens.ButtonScreen
import com.example.composeui.ui.screens.ScreenNav
import com.example.composeui.ui.screens.StartScreen
import com.example.composeui.ui.screens.TextFieldScreen

@Composable
fun ComposeUiApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold() { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = ScreenNav.StartScreen.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable(route = ScreenNav.StartScreen.name) {
                StartScreen(
                    gotoTextFieldScreen = {
                        navController.navigate(ScreenNav.TextFieldsScreen.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }
            composable(route = ScreenNav.TextFieldsScreen.name) {
                TextFieldScreen(
                    gotoButtonScreen = {
                        navController.navigate(ScreenNav.ButtonScreen.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                )
            }
            composable(route = ScreenNav.ButtonScreen.name) {
                ButtonScreen(
                    gotoStartScreen = {
                        navController.popBackStack(
                            route = ScreenNav.StartScreen.name,
                            inclusive = false
                        )
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }
        }
    }
}