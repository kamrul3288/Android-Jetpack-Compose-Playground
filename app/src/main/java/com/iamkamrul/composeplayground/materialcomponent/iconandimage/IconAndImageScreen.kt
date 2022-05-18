package com.iamkamrul.composeplayground.materialcomponent.iconandimage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.iamkamrul.composeplayground.R
import com.iamkamrul.composeplayground.routing.Navigator
import com.iamkamrul.composeplayground.routing.ScreenName
import com.iamkamrul.composeplayground.widget.CustomAppbar

@Preview
@Composable
fun PreviewIconAndImageActivity(){
    IconAndImageActivity()
}

@Composable
fun IconAndImageActivity(){
    CustomAppbar(
        appBarTitle = "Icon & Image",
        navigationIconPressed = {
            Navigator.navigateTo(ScreenName.MaterialComponentListScreen)
        }
    ){
        LazyColumn{
            item {
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    //default icon example
                    Text(text = "Default Icon")
                    Icon(imageVector = Icons.Default.Favorite, contentDescription = "")

                    //default icon with custom color example
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Default Icon with custom color")
                    Icon(
                        imageVector =
                        Icons.Default.Favorite,
                        contentDescription = "",
                        tint = Color.Red
                    )

                    //icon from resources example
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Icon From Resources")
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_24),
                        contentDescription = ""
                    )


                    //Default Image View Example
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "ImageView Example")
                    Image(
                        painter = painterResource(id = R.drawable.bunny),
                        contentDescription = "",
                    )


                    //Circular Image View Example
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Circular ImageView Example")
                    Image(
                        painter = painterResource(id = R.drawable.bunny),
                        contentDescription = "",
                        modifier = Modifier
                            .size(80.dp)
                            .aspectRatio(1f)
                            .clip(CircleShape)
                            .border(2.dp, Color.Gray, CircleShape)
                    )


                    //Network Image View Example
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Network ImageView Example")
                    Image(
                        painter =  rememberAsyncImagePainter(model = "https://developer.android.com/codelabs/jetpack-compose-animation/img/ea1442f28b3c3b39.png"),
                        contentDescription = "",
                        modifier = Modifier.fillMaxWidth()
                            .height(150.dp)

                    )



                }
            }
        }
    }
}