package com.philipademba.takehome.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.philipademba.takehome.R
import com.philipademba.takehome.presentation.navigation.AppRouteDestinations

@Composable
fun MainScreen(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
) {
    Box(modifier = Modifier) {
        Scaffold(
            modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState,
            topBar = {
                TopAppBar(
                    modifier = Modifier.height(60.dp),
                    title = {
                        Box(modifier = Modifier.padding(vertical = 8.dp)) {
                            Text(
                                text = stringResource(R.string.discover_movies),
                                style = MaterialTheme.typography.h6,
                                color = Color.DarkGray
                            )
                        }
                    },
                    backgroundColor = Color.White,
                    contentColor = Color.Black,
                    elevation = 5.dp,
                )
            }
        ) { it ->

            Column(
                Modifier
                    .background(color = Color.Black)
                    .fillMaxSize()
                    .padding(it)
                    .verticalScroll(rememberScrollState())
            ) {


                Box(
                    Modifier
                        .weight(1f)
                        .background(color = Color.White)
                ) {
                    Card(
                        shape = RoundedCornerShape(20f),
                        elevation = 4.dp,
                        backgroundColor = Color.White,
                        contentColor = Color.White,
                        modifier = Modifier.background(color = Color.White)
                    ) {
                        AppRouteDestinations(
                            navController = navController,
                        )
                    }
                }
            }
            LaunchedEffect(key1 = true) {
                navController.addOnDestinationChangedListener { _, destination, _ ->

                }
            }
        }
    }
}