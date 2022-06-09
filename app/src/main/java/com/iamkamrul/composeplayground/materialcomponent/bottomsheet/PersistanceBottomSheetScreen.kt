package com.iamkamrul.composeplayground.materialcomponent.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PersistenceBottomSheetScreen(
    state:BottomSheetScaffoldState,
    content: @Composable (PaddingValues) -> Unit
){
    BottomSheetScaffold(
        scaffoldState = state,
        sheetContent = {
            Box(
                modifier = Modifier.fillMaxWidth().height(50.dp)
                    .background(Color.LightGray)
                    .wrapContentSize(align = Alignment.Center)
            ) {
                Text("Swipe up to expand sheet")
            }
            LazyColumn {
                items(50) {
                    ListItem(
                        text = { Text("Item $it") },
                        icon = {
                            Icon(
                                Icons.Default.Favorite,
                                contentDescription = "Localized description"
                            )
                        }
                    )
                }
            }
        },
        sheetPeekHeight = 50.dp,
        content = content
    )
}