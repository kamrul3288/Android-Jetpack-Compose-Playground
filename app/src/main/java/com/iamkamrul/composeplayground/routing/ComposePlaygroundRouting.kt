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
import com.iamkamrul.composeplayground.materialcomponent.appbarandnavdrawer.AppbarAndNavDrawerActivity
import com.iamkamrul.composeplayground.materialcomponent.bottomnavigation.BottomNavigationActivity
import com.iamkamrul.composeplayground.materialcomponent.button.ButtonActivity
import com.iamkamrul.composeplayground.materialcomponent.dialogs.DialogsActivity
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
    object AppbarAndNavDrawerScreen:ScreenName()
    object BottomNavigationScreen:ScreenName()
    object DialogsScreen:ScreenName()
}

@Composable
fun ScreenNavigator(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        when(Navigator.currentScreen){
            ScreenName.PlaygroundListScreen-> PlaygroundListScreen()
            ScreenName.MaterialComponentListScreen->MaterialComponentListActivity()
            ScreenName.TextScreen-> TextScreen()
            ScreenName.ButtonScreen-> ButtonActivity()
            ScreenName.IconAndImageScreen-> IconAndImageActivity()
            ScreenName.TextFieldScreen-> TextFieldActivity()
            ScreenName.RadioSwitchSliderScreen-> RadioSwitchSliderActivity()
            ScreenName.ProgressbarAndChipScreen -> ProgressbarAndChipActivity()
            ScreenName.AppbarAndNavDrawerScreen -> AppbarAndNavDrawerActivity()
            ScreenName.BottomNavigationScreen -> BottomNavigationActivity()
            ScreenName.DialogsScreen -> DialogsActivity()
        }
    }
}


object Navigator{
    var currentScreen:ScreenName by mutableStateOf(ScreenName.PlaygroundListScreen)
    fun navigateTo(destination:ScreenName){
        currentScreen = destination
    }
}
