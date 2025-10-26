package com.example.plantkhojo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.plantkhojo.ui.screens.home.BottomNavApp
import com.example.plantkhojo.presentation.ui.screens.onboarding.WelcomeScreen
import com.example.plantkhojo.ui.screens.plantdetail.PlantDetailScreen
import com.example.plantkhojo.ui.theme.PlantKhojoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlantKhojoTheme {
                App()
            }
        }
    }

    @Composable
    fun App() {
        val navController = rememberNavController()

        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "onboarding",
//                startDestination = "main",
                modifier = Modifier.padding(innerPadding)
            ) {
                // Onboarding Screen
                composable("onboarding") {
                    WelcomeScreen(
                        onSkipClick = {
                            navController.navigate("main") {
                                popUpTo("onboarding") { inclusive = true }
                            }
                        }
                    )
                }
                // Main Screen
                composable("main") {
                    BottomNavApp()
                }

                // Main Screen
                composable("plant_detail") {
                    PlantDetailScreen()
                }
            }
        }
    }
}