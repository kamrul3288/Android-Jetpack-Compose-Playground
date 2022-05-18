package com.iamkamrul.composeplayground.materialcomponent

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iamkamrul.composeplayground.resources.Blue500
import com.iamkamrul.composeplayground.resources.Blue700
import com.iamkamrul.composeplayground.routing.Navigator
import com.iamkamrul.composeplayground.routing.ScreenName
import com.iamkamrul.composeplayground.widget.CustomAppbar

// preview this screen
@Composable
@Preview
fun PreviewMaterialComponentListActivity(){
    MaterialComponentListActivity()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MaterialComponentListActivity(){
    // handle on back press
    BackHandler(onBack = {
        Navigator.navigateTo(ScreenName.PlaygroundListScreen)
    })

    // write @CustomAppbar widget for reducing boilerplate code
    CustomAppbar(
        appBarTitle = "Material Components",
        navigationIconPressed = {
            Navigator.navigateTo(ScreenName.PlaygroundListScreen)
        }
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
          items(items = getMaterialComposeListData()){item->
              MaterialComponentItem(item)
          }
        }
    }

}


@Composable
@Preview
fun PreviewMaterialComponentItem(){
    MaterialComponentItem(getMaterialComposeListData()[0])
}

@Composable
private fun MaterialComponentItem(materialComponent: MaterialComponent){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                Navigator.navigateTo(materialComponent.screenName)
            }
            .height(80.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Blue500),
        verticalAlignment = Alignment.CenterVertically
    ){


        Text(
            text = materialComponent.title,
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier
                .weight(1f)
                .wrapContentSize(Alignment.Center),
            textAlign = TextAlign.Center
        )

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

