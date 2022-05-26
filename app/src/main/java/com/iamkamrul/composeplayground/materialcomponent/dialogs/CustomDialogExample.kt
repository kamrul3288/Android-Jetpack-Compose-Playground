package com.iamkamrul.composeplayground.materialcomponent.dialogs
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun CustomDialogExample(
    openDialog:MutableState<Boolean>
){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    if (openDialog.value){
        AlertDialog(
            title = {
                Text(text = "Login")
            },
            text = {
                Column(Modifier.padding(16.dp)) {
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Enter Email Address") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        placeholder = { androidx.compose.material.Text(text = "Enter your e-mail") },
                        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Enter Password") },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { androidx.compose.material.Text(text = "Enter your password") },
                        leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "password") },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )

                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Login")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Cancel")
                }
            },
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            onDismissRequest = {
                openDialog.value = false
            }
        )
    }
}

