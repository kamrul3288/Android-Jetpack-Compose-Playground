package com.iamkamrul.composeplayground.materialcomponent.bottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var title:String,var icon:ImageVector,var route:String){
    object Home:BottomNavItem(title = "Home", icon = Icons.Default.Home, route = "home")
    object Favourite:BottomNavItem(title = "Favourite", icon = Icons.Default.Favorite, route = "favourite")
    object Notification:BottomNavItem(title = "Notification", icon = Icons.Default.Notifications, route = "notification")
}