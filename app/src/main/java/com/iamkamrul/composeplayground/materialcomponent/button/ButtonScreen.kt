package com.iamkamrul.composeplayground.materialcomponent.button

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iamkamrul.composeplayground.resources.Blue700
import com.iamkamrul.composeplayground.routing.Navigator
import com.iamkamrul.composeplayground.routing.ScreenName
import com.iamkamrul.composeplayground.widget.CustomAppbar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview
@Composable
fun PreviewButtonActivity(){
    ButtonActivity()
}

@Composable
fun ButtonActivity(){
    // handle on back press
    BackHandler(onBack ={
        Navigator.navigateTo(ScreenName.MaterialComponentListScreen)
    })

    CustomAppbar(
        appBarTitle = "Buttons Screen",
        navigationIconPressed = {
            Navigator.navigateTo(ScreenName.MaterialComponentListScreen)
        }
    ){
        Column(
            modifier = Modifier.padding(16.dp)
        ){

            // text button example
            TextButton(onClick = { }) {
                Text(text = "Text Button")
            }

            // text disable button example
            TextButton(
                onClick = { },
                enabled = false
            ) {
                Text(text = "Text Button Disabled")
            }

            //default button example
            Button(onClick = {}) {
                Text(text = "Default Button")
            }

            //default button with custom size example
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text(text = "Default Button with custom size")
            }

            //Rounded shape button example
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text(text = "Rounded shape button")
            }

            //Custom shape button example
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                shape = RoundedCornerShape(topStart = 20.dp, bottomEnd = 20.dp)
            ) {
                Text(text = "Custom shape button")
            }

            val outlineButtonColor: ButtonColors = ButtonDefaults.outlinedButtonColors(
                contentColor = Blue700,

            )

            //Outline Border button example
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(
                colors = outlineButtonColor,
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
            ) {
                Text(text = "Outline Border button")
            }

            //Custom Outline Border button example
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(
                border = BorderStroke(width = 1.dp, color = Blue700),
                shape = RoundedCornerShape(30.dp),
                colors = outlineButtonColor,
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
            ) {
                Text(text = "Custom Outline Border button")
            }

            //Horizontal gradient background button example
            val horizontalGradient = Brush.horizontalGradient(
                colors = listOf(Blue700, Color.Magenta),
                0f,
                750f
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Horizontal gradient",
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(brush = horizontalGradient)
                    .wrapContentSize(Alignment.Center)
                    .clickable {

                    }
            )


            //Vertical gradient background button example
            val verticalGradient = Brush.verticalGradient(
                colors = listOf(Blue700, Color.Magenta),
                0f,
                150f
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Vertical gradient",
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(brush = verticalGradient)
                    .wrapContentSize(Alignment.Center)
                    .clickable {

                    }
            )


            //Swipe button example
            Spacer(modifier = Modifier.height(16.dp))
            val swipeButtonState = remember {
                mutableStateOf(SwipeButtonState.INITIAL)
            }
            val coroutineScope = rememberCoroutineScope()
            SwipeButton(
                onSwiped = {
                    swipeButtonState.value = SwipeButtonState.SWIPED
                    coroutineScope.launch {
                        swipeButtonState.value = SwipeButtonState.COLLAPSED
                    }
                },
                swipeButtonState = swipeButtonState.value,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp),
                iconPadding = PaddingValues(4.dp),
                shape = CircleShape,
            ) {
                Text(text = "Swipe Button", color = Color.White)
            }


        }
    }
}
