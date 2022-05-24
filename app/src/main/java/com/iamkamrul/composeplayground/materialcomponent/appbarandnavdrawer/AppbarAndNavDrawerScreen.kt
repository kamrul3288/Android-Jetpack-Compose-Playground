package com.iamkamrul.composeplayground.materialcomponent.appbarandnavdrawer

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.iamkamrul.composeplayground.R
import com.iamkamrul.composeplayground.resources.Blue700
import com.iamkamrul.composeplayground.routing.Navigator
import com.iamkamrul.composeplayground.routing.ScreenName
import kotlinx.coroutines.launch

@Composable
fun AppbarAndNavDrawerActivity(){
    // handle on back press
    BackHandler(onBack ={
        Navigator.navigateTo(ScreenName.MaterialComponentListScreen)
    })

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()

    fun closeDrawer(){
        scope.launch {
            scaffoldState.drawerState.close()
        }
    }

    Scaffold(

        // top appbar
        topBar = {
            TopAppBar(
                //app bar title
                title = {
                    Text(text = "Title")
                },

                //navigation icon
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }){
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                    }
                },

                //action left side 3 dots

                actions = {
                    //dropdown menu when click 3 dots icon
                    var expanded by remember { mutableStateOf(false) }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                            Text("Refresh")
                        }
                        DropdownMenuItem(onClick = { /* Handle settings! */ }) {
                            Text("Settings")
                        }
                        Divider()
                        DropdownMenuItem(onClick = { /* Handle send feedback! */ }) {
                            Text("Send Feedback")
                        }
                    }

                    IconButton(onClick = {
                        expanded = true
                    }){
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_more_vert_24),
                            contentDescription = "More"
                        )
                    }
                },
            )
        },

        //navigation drawer
        scaffoldState = scaffoldState,
        drawerContentColor = Color.White,
        drawerBackgroundColor = Blue700,
        drawerContent = {
            //nav header
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bunny),
                    contentDescription = "",
                    modifier = Modifier
                        .size(80.dp)
                        .aspectRatio(1f)
                        .clip(CircleShape)
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Mr. Bunny")
                Text(text = "+880xxxxxxxxxx")
                
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.White)
            )


            //drawer item
            Row(
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth()
                    .clickable {
                        closeDrawer()
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Filled.Home, contentDescription = "Home")
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Home")
            }

            Row(
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth()
                    .clickable {
                        closeDrawer()
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile")
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Profile")
            }

            Row(
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth()
                    .clickable {
                        closeDrawer()
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Bookmark")
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Bookmark")
            }

            Row(
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth()
                    .clickable {
                        closeDrawer()
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Filled.Notifications, contentDescription = "Notifications")
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Notifications")
            }

            Row(
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth()
                    .clickable {
                        closeDrawer()
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = "Settings")
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Settings")
            }

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.White)
                .padding(vertical = 16.dp)
            )

            Row(
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth()
                    .clickable {
                        closeDrawer()
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Filled.Share, contentDescription = "Share")
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Share")
            }

            Row(
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth()
                    .clickable {
                        closeDrawer()
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Filled.Send, contentDescription = "Send")
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Send")
            }
        }

    ) {

    }
}