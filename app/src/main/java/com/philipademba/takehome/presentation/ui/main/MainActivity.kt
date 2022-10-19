package com.philipademba.takehome.presentation.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.rememberScaffoldState
import androidx.navigation.compose.rememberNavController
import com.philipademba.takehome.presentation.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {

                val scaffoldState = rememberScaffoldState()
                val navController = rememberNavController()

                MainScreen(
                    navController = navController,
                    scaffoldState = scaffoldState
                )
            }
        }
    }
}
