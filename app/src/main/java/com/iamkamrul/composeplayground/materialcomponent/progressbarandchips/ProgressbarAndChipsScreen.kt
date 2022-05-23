package com.iamkamrul.composeplayground.materialcomponent.progressbarandchips

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iamkamrul.composeplayground.resources.Blue700
import com.iamkamrul.composeplayground.routing.Navigator
import com.iamkamrul.composeplayground.routing.ScreenName
import com.iamkamrul.composeplayground.widget.CustomAppbar


@Composable
@Preview
fun PreviewProgressbarAndChipsActivity(){
    ProgressbarAndChipActivity()
}

@Composable
fun ProgressbarAndChipActivity(){
    // handle on back press
    BackHandler(onBack ={
        Navigator.navigateTo(ScreenName.MaterialComponentListScreen)
    })

    CustomAppbar(
        appBarTitle = "Progressbar & Chip",
        navigationIconPressed = {
            Navigator.navigateTo(ScreenName.MaterialComponentListScreen)
        }
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            //circular progressbar Example
            Text(text = "Circular progressbar Example")
            Spacer(modifier = Modifier.height(8.dp))
            CircularProgressIndicator()

            //Customized circular progressbar Example
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Customized circular progressbar Example")
            Spacer(modifier = Modifier.height(8.dp))
            CircularProgressIndicator(
                color = Blue700,
                strokeWidth = 10.dp
            )


            //Linear progressbar Example
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Linear progressbar Example")
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())


            //Chip Example
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Chip Example coming soon...")
            Spacer(modifier = Modifier.height(8.dp))




        }
    }
}