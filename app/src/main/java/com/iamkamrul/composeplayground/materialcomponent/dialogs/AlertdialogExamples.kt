package com.iamkamrul.composeplayground.materialcomponent.dialogs

import androidx.compose.material.AlertDialog
import androidx.compose.material.TextButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun AlertdialogExamples(
    openDialog:MutableState<Boolean>
){
    if (openDialog.value){
        AlertDialog(
            title = {
                Text(text = "Hello Alert Dialog!")
            },
            text = {
                Text(text = "Alert dialogs description text data text.Alert dialogs description text data text.")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Dismiss")
                }
            },
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            onDismissRequest = {
                openDialog.value = false
            }
        )
    }
}