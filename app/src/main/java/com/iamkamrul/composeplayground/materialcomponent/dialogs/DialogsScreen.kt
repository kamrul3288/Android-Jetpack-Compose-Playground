package com.iamkamrul.composeplayground.materialcomponent.dialogs

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.iamkamrul.composeplayground.routing.Navigator
import com.iamkamrul.composeplayground.routing.ScreenName
import com.iamkamrul.composeplayground.widget.CustomAppbar

@Composable
fun DialogsActivity(){
    // handle on back press
    BackHandler(onBack ={
        Navigator.navigateTo(ScreenName.MaterialComponentListScreen)
    })

    val alertDialogState = remember { mutableStateOf(false)  }
    val material3AlertDialogState = remember { mutableStateOf(false)  }
    val customDialogState = remember { mutableStateOf(false)  }

    AlertdialogExamples(openDialog = alertDialogState)
    Material3AlertdialogExamples(openDialog = material3AlertDialogState)
    CustomDialogExample(openDialog = customDialogState)



    CustomAppbar(
        appBarTitle = "Dialogs",
        navigationIconPressed = {
            Navigator.navigateTo(ScreenName.MaterialComponentListScreen)
        }
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                   alertDialogState.value = true
                }
            ) {
                Text(text = "Alert Dialog")
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    material3AlertDialogState.value = true
                }
            ) {
                Text(text = "Material-3 Alert Dialog")
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    customDialogState.value = true
                }
            ) {
                Text(text = "Custom View Dialog")
            }
        }
    }
}



