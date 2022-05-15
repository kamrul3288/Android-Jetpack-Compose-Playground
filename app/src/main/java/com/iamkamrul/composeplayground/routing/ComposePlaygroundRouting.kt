package com.iamkamrul.composeplayground.routing

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.iamkamrul.composeplayground.entrypoint.PlaygroundListScreen
import com.iamkamrul.composeplayground.materialcomponent.MaterialComponentListActivity

sealed class PlaygroundScreenName{
    object PlaygroundListScreen:PlaygroundScreenName()
    object MaterialComponentScreen:PlaygroundScreenName()
}

@Composable
fun PlaygroundScreenNavigator(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        when(PlaygroundRouting.currentScreen){
            is PlaygroundScreenName.PlaygroundListScreen-> PlaygroundListScreen()
            is PlaygroundScreenName.MaterialComponentScreen->MaterialComponentListActivity()
        }
    }
}


object PlaygroundRouting{
    var currentScreen:PlaygroundScreenName by mutableStateOf(PlaygroundScreenName.PlaygroundListScreen)
    fun navigateTo(destination:PlaygroundScreenName){
        currentScreen = destination
    }
}
