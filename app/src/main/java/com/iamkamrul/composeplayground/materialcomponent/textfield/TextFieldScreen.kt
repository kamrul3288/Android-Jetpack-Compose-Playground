package com.iamkamrul.composeplayground.materialcomponent.textfield

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iamkamrul.composeplayground.routing.Navigator
import com.iamkamrul.composeplayground.routing.ScreenName
import com.iamkamrul.composeplayground.widget.CustomAppbar


@Preview
@Composable
fun PreviewTextFieldActivity(){
    TextFieldActivity()
}

@Composable
fun TextFieldActivity(){
    // handle on back press
    BackHandler(onBack ={
        Navigator.navigateTo(ScreenName.MaterialComponentListScreen)
    })

    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var text3 by remember { mutableStateOf("") }
    var text4 by remember { mutableStateOf("") }
    var text5 by remember { mutableStateOf("") }


    CustomAppbar(
        appBarTitle = "TextField Screen",
        navigationIconPressed = {
            Navigator.navigateTo(ScreenName.MaterialComponentListScreen)
        }
    ){
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 16.dp)
        ){
            item {

                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Default TextFiled")
                TextField(
                    value = text1,
                    onValueChange = { text1 = it },
                    label = { Text("Label") },
                    modifier = Modifier.fillMaxWidth()
                )


                //Outline border TextFiled Example
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Outline border TextFiled Example")
                OutlinedTextField(
                    value = text2,
                    onValueChange = { text2 = it },
                    label = { Text("Enter Name") },
                    modifier = Modifier.fillMaxWidth()
                )


                //Password TextFiled Example
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Password TextFiled Example")
                OutlinedTextField(
                    value = text3,
                    onValueChange = { text3 = it },
                    label = { Text("Enter Password") },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                //Icon TextFiled Example
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Icon TextFiled Example")
                OutlinedTextField(
                    value = text4,
                    onValueChange = { text4 = it },
                    label = { Text("Enter Address") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    placeholder = { Text(text = "Enter your e-mail") },
                    leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
                )

                //Customized TextFiled Example
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Customized TextFiled Example")
                OutlinedTextField(
                    value = text5,
                    onValueChange = { text5 = it },
                    label = { Text("Enter Address") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Red,
                        unfocusedBorderColor = Color.Red,
                        focusedLabelColor = Color.Red,
                        unfocusedLabelColor = Color.Gray,
                        cursorColor = Color.Red
                    ),
                )

                //Custom Bg TextFiled Example
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Custom Bg TextFiled Example")
                TextField(
                    value = text1,
                    shape = RoundedCornerShape(30.dp),
                    onValueChange = { text1 = it },
                    placeholder = { Text("Enter Name") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        disabledLabelColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent,
                        errorBorderColor = Color.Transparent,
                        backgroundColor = Color.Red,
                        placeholderColor = Color.White,
                        textColor = Color.White,
                        cursorColor = Color.White,
                    ),
                )

            }
        }
    }
}