package com.iamkamrul.composeplayground.materialcomponent.bottomsheet

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.iamkamrul.composeplayground.routing.Navigator
import com.iamkamrul.composeplayground.routing.ScreenName
import com.iamkamrul.composeplayground.widget.CustomAppbar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetActivity(){
    // handle on back press
    BackHandler(onBack ={
        Navigator.navigateTo(ScreenName.MaterialComponentListScreen)
    })

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()
    val state = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)

    CustomAppbar(appBarTitle = "BottomSheet") {
        PersistenceBottomSheetScreen(
            state = scaffoldState,
        ){
            ModalBottomSheetScreen(state = state){
                Box (
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    ElevatedButton(
                        onClick = {
                            scope.launch {
                                state.show()
                            }
                        },
                    ){
                        Text(text = "Show Modal BottomSheet")
                    }
                }
            }
        }
    }
}
