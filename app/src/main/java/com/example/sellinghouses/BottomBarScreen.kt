package com.example.sellinghouses

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen (
    val route : String,
    val icon : ImageVector
){
    object Home :BottomBarScreen(
        route = "Home",
        icon = Icons.Default.Home
    )
    object Profile :BottomBarScreen(
        route = "Profile",
        icon = Icons.Default.Person
    )
    object AddHouse :BottomBarScreen(
        route = "AddHouse",
        icon = Icons.Default.Add
    )
}

