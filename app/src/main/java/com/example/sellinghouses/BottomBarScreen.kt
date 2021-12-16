package com.example.sellinghouses

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home

sealed class BottomBarScreen(
    val route: String,
    val icon: Int
){
    object Home :BottomBarScreen(
        route = "Home",
        icon = R.drawable.ic_home,
    )
    object Profile :BottomBarScreen(
        route = "Profile",
        icon = R.drawable.ic_heart
    )
    object AddHouse :BottomBarScreen(
        route = "AddHouse",
        icon = R.drawable.ic_add
    )
}

