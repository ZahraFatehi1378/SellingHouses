package com.example.sellinghouses.screens.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sellinghouses.BottomBarScreen

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
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(
                PaddingValues(
                    start = 0.dp,
                    top = 0.dp,
                    end = 0.dp,
                    bottom = innerPadding.calculateBottomPadding()
                )
            )
        ) {
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
                painter = painterResource(id = screen.icon),
                contentDescription = "navigation icon",
                //  tint = MaterialTheme.colors.secondary
            Modifier.size(20.dp)
            )

        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = MaterialTheme.colors.secondaryVariant,
        selectedContentColor = MaterialTheme.colors.secondary,
        onClick = {
            navHostController.navigate(screen.route) {
                popUpTo(navHostController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}

