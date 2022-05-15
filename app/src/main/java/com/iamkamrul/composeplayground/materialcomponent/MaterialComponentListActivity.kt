package com.iamkamrul.composeplayground.materialcomponent

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import com.iamkamrul.composeplayground.routing.PlaygroundRouting
import com.iamkamrul.composeplayground.routing.PlaygroundScreenName

@Composable
fun MaterialComponentListActivity(){
    // handle on back press
    BackHandler(onBack = {
        PlaygroundRouting.navigateTo(PlaygroundScreenName.PlaygroundListScreen)
    })
}
