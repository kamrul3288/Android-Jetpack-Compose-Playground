package com.iamkamrul.composeplayground.entrypoint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iamkamrul.composeplayground.resources.Blue500
import com.iamkamrul.composeplayground.resources.Blue700
import com.iamkamrul.composeplayground.resources.ComposePlaygroundTheme
import com.iamkamrul.composeplayground.routing.Navigator
import com.iamkamrul.composeplayground.routing.ScreenName
import com.iamkamrul.composeplayground.routing.ScreenNavigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                ScreenNavigator()
            }
        }
    }
}


/*
*play ground item list screen
**/
@Composable
fun PlaygroundListScreen(){
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            Appbar(scope,scaffoldState)
        },
        drawerContent = {

        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
        ){
            itemsIndexed(
                items = composePlayGroundDataList(),
                itemContent = {index,item ->
                    PlaygroundItem(item,index)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            )
        }
    }
}

//top app bar
@Composable
private fun Appbar(scope:CoroutineScope,scaffoldState: ScaffoldState){
    TopAppBar(
        title = {
            Text(text = "Compose Playground")
        },
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(Icons.Filled.Menu, "")
            }
        }
    ) 
}

@Preview
@Composable
fun PreviewPlaygroundItem(){
    PlaygroundItem(composePlayGroundDataList()[0],0)
}

@Composable
fun PlaygroundItem(composePlayGroundData: ComposePlayGroundData,index:Int){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                when(index){
                    0->Navigator.navigateTo(ScreenName.MaterialComponentListScreen)
                }
            }
            .height(80.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Blue500),
        verticalAlignment = Alignment.CenterVertically
    ){

        //prefix round background with text
        Spacer(modifier = Modifier.width(16.dp))
        Box(modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(Blue700),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = composePlayGroundData.prefix,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            )
        }

        //title & sub title section
        Column(modifier = Modifier
            .weight(1f)
            .padding(horizontal = 16.dp)) {
            //title
            Text(
                text = composePlayGroundData.title,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                ),
                maxLines = 1
            )
            //sub-title
            Text(
                text = composePlayGroundData.subTitle,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                ),
                maxLines = 2
            )
        }

        //end background & back icon
        Box(modifier = Modifier
            .width(50.dp)
            .height(80.dp)
            .clip(RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp))
            .background(Blue700),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "", tint = Color.White)
        }
    }
}

