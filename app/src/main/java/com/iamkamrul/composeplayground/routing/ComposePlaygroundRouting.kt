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
import com.iamkamrul.composeplayground.materialcomponent.button.ButtonActivity
import com.iamkamrul.composeplayground.materialcomponent.iconandimage.IconAndImageActivity
import com.iamkamrul.composeplayground.materialcomponent.progressbarandchips.ProgressbarAndChipActivity
import com.iamkamrul.composeplayground.materialcomponent.radioswitchslider.RadioSwitchSliderActivity
import com.iamkamrul.composeplayground.materialcomponent.text.TextScreen
import com.iamkamrul.composeplayground.materialcomponent.textfield.TextFieldActivity

sealed class ScreenName{
    object PlaygroundListScreen:ScreenName()
    object MaterialComponentListScreen:ScreenName()
    object TextScreen:ScreenName()
    object ButtonScreen:ScreenName()
    object IconAndImageScreen:ScreenName()
    object TextFieldScreen:ScreenName()
    object RadioSwitchSliderScreen:ScreenName()
    object ProgressbarAndChipScreen:ScreenName()
}

@Composable
fun ScreenNavigator(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        when(Navigator.currentScreen){
            is ScreenName.PlaygroundListScreen-> PlaygroundListScreen()
            is ScreenName.MaterialComponentListScreen->MaterialComponentListActivity()
            is ScreenName.TextScreen-> TextScreen()
            is ScreenName.ButtonScreen-> ButtonActivity()
            is ScreenName.IconAndImageScreen-> IconAndImageActivity()
            is ScreenName.TextFieldScreen-> TextFieldActivity()
            is ScreenName.RadioSwitchSliderScreen-> RadioSwitchSliderActivity()
            ScreenName.ProgressbarAndChipScreen -> ProgressbarAndChipActivity()
        }
    }
}


object Navigator{
    var currentScreen:ScreenName by mutableStateOf(ScreenName.PlaygroundListScreen)
    fun navigateTo(destination:ScreenName){
        currentScreen = destination
    }
}
