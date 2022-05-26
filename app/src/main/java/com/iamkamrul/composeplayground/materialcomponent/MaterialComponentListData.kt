package com.iamkamrul.composeplayground.materialcomponent

import com.iamkamrul.composeplayground.routing.ScreenName

enum class MaterialComponentType{
    TEXT,BUTTON,ICON_AND_IMAGE,TEXT_FIELD,
    RADIO_SWITCH_SLIDER,PROGRESSBAR_CHIPS,APP_BAR_AND_NAVIGATION_DRAWER,
    BOTTOM_NAVIGATION_BAR,DIALOGS,BOTTOM_SHEET,TAG_LAYOUT,PULL_REFRESH,
    SNACK_BAR,CARDS,SCA_FOLD,TAB_BAR,BOTTOM_APP_BAR,FLOATING_ACTION_BUTTON
}

data class MaterialComponent(
    val title:String,
    val type:MaterialComponentType,
    val screenName: ScreenName = ScreenName.TextScreen
)

fun getMaterialComposeListData():List<MaterialComponent>{
    return  listOf(
        MaterialComponent(title = "Text", type = MaterialComponentType.TEXT, screenName = ScreenName.TextScreen),
        MaterialComponent(title = "Button", type = MaterialComponentType.BUTTON, screenName = ScreenName.ButtonScreen),
        MaterialComponent(title = "Icon & Image", type = MaterialComponentType.ICON_AND_IMAGE, screenName = ScreenName.IconAndImageScreen),
        MaterialComponent(title = "TextFiled", type = MaterialComponentType.TEXT_FIELD, screenName = ScreenName.TextFieldScreen),
        MaterialComponent(title = "Radio, Switch, Slider", type = MaterialComponentType.RADIO_SWITCH_SLIDER, screenName = ScreenName.RadioSwitchSliderScreen),
        MaterialComponent(title = "Progressbar & Chips", type = MaterialComponentType.PROGRESSBAR_CHIPS, screenName = ScreenName.ProgressbarAndChipScreen),
        MaterialComponent(title = "Appbars & Navigatin Drawer", type = MaterialComponentType.APP_BAR_AND_NAVIGATION_DRAWER, screenName = ScreenName.AppbarAndNavDrawerScreen),
        MaterialComponent(title = "Bottom Navigation", type = MaterialComponentType.BOTTOM_NAVIGATION_BAR, screenName = ScreenName.BottomNavigationScreen),
        MaterialComponent(title = "Dialogs", type = MaterialComponentType.DIALOGS, screenName = ScreenName.DialogsScreen),
        MaterialComponent(title = "Bottom sheet", type = MaterialComponentType.BOTTOM_SHEET),
        MaterialComponent(title = "Tab layout", type = MaterialComponentType.TAG_LAYOUT),
        MaterialComponent(title = "Pull Refresh", type = MaterialComponentType.PULL_REFRESH),
        MaterialComponent(title = "Snack bar", type = MaterialComponentType.SNACK_BAR),
        MaterialComponent(title = "Cards", type = MaterialComponentType.CARDS),
        MaterialComponent(title = "Scafold", type = MaterialComponentType.SCA_FOLD),
        MaterialComponent(title = "Tabbar", type = MaterialComponentType.TAB_BAR),
        MaterialComponent(title = "Bottom Appbar", type = MaterialComponentType.BOTTOM_APP_BAR),
        MaterialComponent(title = "FloatingAction Button", type = MaterialComponentType.FLOATING_ACTION_BUTTON),
    )
}