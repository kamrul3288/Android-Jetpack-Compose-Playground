package com.iamkamrul.composeplayground.materialcomponent.radioswitchslider

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iamkamrul.composeplayground.R
import com.iamkamrul.composeplayground.routing.Navigator
import com.iamkamrul.composeplayground.routing.ScreenName
import com.iamkamrul.composeplayground.widget.CustomAppbar


@Preview
@Composable
fun PreviewRadioSwitchSliderActivity(){
    RadioSwitchSliderActivity()
}

@Composable
fun RadioSwitchSliderActivity(){
    // handle on back press
    BackHandler(onBack ={
        Navigator.navigateTo(ScreenName.MaterialComponentListScreen)
    })


    val radioOptions = listOf("Male", "Female", "Both")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
    val context = LocalContext.current

    val wifiState = remember { mutableStateOf(true) }
    val bluetoothState = remember { mutableStateOf(false) }

    var sliderPosition by remember { mutableStateOf(0f) }




    CustomAppbar(
        appBarTitle = "Radio Switch Slider",
        navigationIconPressed = {
            Navigator.navigateTo(ScreenName.MaterialComponentListScreen)
        }
    ){
        LazyColumn(
            modifier = Modifier.padding(horizontal = 16.dp)
        ){
            item {

                //Radio Button Example
                Text(text = "Radio Button Example")
                Column(Modifier.selectableGroup()) {
                    radioOptions.forEach { text ->
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .selectable(
                                    selected = (text == selectedOption),
                                    onClick = { onOptionSelected(text) },
                                    role = Role.RadioButton
                                )
                                .padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (text == selectedOption),
                                onClick = {
                                    onOptionSelected(text)
                                    when(text){
                                        "Male"-> Toast.makeText(context, "Male", Toast.LENGTH_SHORT).show()
                                        "Female"->Toast.makeText(context, "Female", Toast.LENGTH_SHORT).show()
                                        "Both"->Toast.makeText(context, "Both", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            )
                            Text(
                                text = text,
                                style = MaterialTheme.typography.body1.merge(),
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }
                    }
                }


                //Switch Example
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Switch Example")
                Spacer(modifier = Modifier.height(8.dp))
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()

                ){
                   Text(text = "Wifi")
                    Switch(
                        checked = wifiState.value,
                        onCheckedChange = {
                            wifiState.value = it
                        }
                    )
                }

                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()

                ){
                    Text(text = "Bluetooth")
                    Switch(
                        checked = bluetoothState.value,
                        onCheckedChange = {
                            bluetoothState.value = it
                        }
                    )
                }


                //Slider Example
                Text(text = "Slider Example")
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_volume_mute_24), contentDescription = "")
                    Slider(
                        modifier = Modifier.weight(1f),
                        value = sliderPosition,
                        valueRange = 0f..100f,
                        onValueChange ={
                            sliderPosition = it
                        },
                        colors = SliderDefaults.colors(
                            thumbColor = MaterialTheme.colors.primary,
                            activeTrackColor = MaterialTheme.colors.primary
                        )
                    )
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_volume_up_24), contentDescription = "")
                }


            }
        }

    }

}