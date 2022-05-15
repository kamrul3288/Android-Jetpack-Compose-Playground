package com.iamkamrul.composeplayground.widget

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable

@Composable
fun CustomAppbar(
    appBarTitle:String,
    navigationIconPressed: (() -> Unit)? = null,
    content: @Composable (PaddingValues) -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = appBarTitle)
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navigationIconPressed?.invoke()
                    }){
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = content
    )
}