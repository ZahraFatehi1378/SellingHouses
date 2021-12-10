package com.example.sellinghouses.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sellinghouses.BottomBarScreen
import com.example.sellinghouses.screens.AddHousesScreen
import com.example.sellinghouses.screens.HousesListScreen
import com.example.sellinghouses.screens.ProfileScreen

@Composable
fun BottomNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(BottomBarScreen.Home.route){
            HousesListScreen()
        }
        composable(BottomBarScreen.AddHouse.route){
            AddHousesScreen()
        }
        composable(BottomBarScreen.Profile.route){
            ProfileScreen()
        }
    }
}
