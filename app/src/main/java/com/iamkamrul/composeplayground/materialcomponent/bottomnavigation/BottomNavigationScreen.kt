package com.iamkamrul.composeplayground.materialcomponent.bottomnavigation

import androidx.activity.compose.BackHandler
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.iamkamrul.composeplayground.routing.Navigator
import com.iamkamrul.composeplayground.routing.ScreenName
import com.iamkamrul.composeplayground.widget.CustomTopAppbar

@Preview
@Composable
fun PreviewBottomNavigationActivity(){
    BottomNavigationActivity()
}

@Composable
fun BottomNavigationActivity(){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // handle on back press
    BackHandler(onBack ={
        if (navBackStackEntry?.destination?.route == BottomNavItem.Home.route)
            Navigator.navigateTo(ScreenName.MaterialComponentListScreen)
    })

    Scaffold(
        // top app bar
        topBar = {
            CustomTopAppbar(
                appBarTitle = "Bottom Navigation",
                navigationIconPressed = {
                    Navigator.navigateTo(ScreenName.MaterialComponentListScreen)
                }
            )
        },

        //bottom navigation
        bottomBar = {
            val navItems = listOf(BottomNavItem.Home,BottomNavItem.Favourite,BottomNavItem.Notification)
            BottomNavigation(
                contentColor = Color.White
            ){
                val currentRoute = navBackStackEntry?.destination?.route
                navItems.forEach {item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(imageVector = item.icon, contentDescription = item.title)
                        },
                        label = {
                            Text(text = item.title, fontSize = 9.sp)
                        },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.White.copy(0.4f),
                        alwaysShowLabel = true,
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                navController.graph.startDestinationRoute?.let { screen_route ->
                                    popUpTo(screen_route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) {
        //initialize navigation graph
        BottomNavigationGraph(navController = navController)
    }

}


// bottom navigation graph for tracking and navigation screen
@Composable
private fun BottomNavigationGraph(navController:NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route)
    {
        composable(BottomNavItem.Home.route){
            BottomNavHomeScreen()
        }
        composable(BottomNavItem.Favourite.route){
            BottomNavFavouriteScreen()
        }
        composable(BottomNavItem.Notification.route){
            BottomNavNotificationScreen()
        }

    }
}