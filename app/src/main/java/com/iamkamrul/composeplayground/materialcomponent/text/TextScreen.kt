package com.iamkamrul.composeplayground.materialcomponent.text

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iamkamrul.composeplayground.R
import com.iamkamrul.composeplayground.resources.Blue700
import com.iamkamrul.composeplayground.routing.Navigator
import com.iamkamrul.composeplayground.routing.ScreenName
import com.iamkamrul.composeplayground.widget.CustomAppbar

@Composable
@Preview
fun PreviewTextScreen(){
    TextScreen()
}

@Composable
fun TextScreen(){
    // handle on back press
    BackHandler(onBack ={
        Navigator.navigateTo(ScreenName.MaterialComponentListScreen)
    })

    CustomAppbar(
        appBarTitle = "Text Screen",
        navigationIconPressed = {
            Navigator.navigateTo(ScreenName.MaterialComponentListScreen)
        }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ){

            Text(text = "Normal default text")
            Text(text = stringResource(id = R.string.title_text_from_resources))
            Text(
                text = "Blue Text Example",
                color = Color.Blue
            )

            Text(
                text = "Changing the text size",
                color = Color.Blue,
                fontSize = 30.sp
            )

            Text(
                text = "Making the text italic",
                color = Blue700,
                fontSize = 30.sp,
                fontStyle = FontStyle.Italic
            )

            Text(
                text = "Making the text Bold",
                color = Blue700,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Center Align Text",
                color = Color.Green,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Left Align Text",
                color = Color.Green,
                fontSize = 20.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Right Align Text",
                color = Color.Green,
                fontSize = 20.sp,
                textAlign = TextAlign.Right,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Custom Font Text",
                color = Color.Magenta,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif
            )

            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append("M")
                    }
                    append("ultiple ")

                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                        append("T")
                    }
                    append("ext Style")
                },
                fontSize = 30.sp
            )

            Text(
                text = "Text Overflow".repeat(50),
                maxLines = 2, overflow = TextOverflow.Ellipsis
            )

            SelectionContainer {
                Text(
                    text = "This text is selectable",
                    color = Color.Red,
                    fontSize = 30.sp,
                )
            }

        }
    }
}