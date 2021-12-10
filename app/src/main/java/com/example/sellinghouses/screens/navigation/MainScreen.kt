package com.example.sellinghouses.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.PopUpToBuilder
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sellinghouses.BottomBarScreen
import com.example.sellinghouses.screens.navigation.BottomNavGraph
import com.example.sellinghouses.ui.theme.SellingHousesTheme

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
//        topBar = {
//            TopAppBar(
//                backgroundColor = MaterialTheme.colors.background,
//                elevation = 10.dp
//            ) {
//                Row(
//                    modifier = Modifier
//                        .padding(horizontal = 8.dp),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Text(text = "Bottom Navigation Demo")
//                }
//            }
//        },

        bottomBar = { BottomBar(navHostController = navController) }
    ) {innerPadding->
        Box(modifier = Modifier.padding(PaddingValues(start = 0.dp , top = 0.dp , end = 0.dp , bottom =innerPadding.calculateBottomPadding()))) {
            BottomNavGraph(navHostController = navController)
        }
    }
}


@Composable
fun BottomBar(navHostController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.AddHouse,
        BottomBarScreen.Profile
    )
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary, elevation = 16.dp
    ) {
        screens.forEach { screen ->
            addItem(
                screen = screen,
                currentDestination = currentDestination,
                navHostController = navHostController,

                )
        }
    }

}

@Composable
fun RowScope.addItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navHostController: NavHostController
) {
    BottomNavigationItem(
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "navigation icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navHostController.navigate(screen.route) {
                popUpTo(navHostController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}

