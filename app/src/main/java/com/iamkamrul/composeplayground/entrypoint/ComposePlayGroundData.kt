package com.iamkamrul.composeplayground.entrypoint

data class ComposePlayGroundData(
    val prefix:String,
    val title:String,
    val subTitle:String,
)

fun composePlayGroundDataList():List<ComposePlayGroundData>{
    return listOf(
        ComposePlayGroundData(
            prefix = "M",
            title = "Material Components widgets",
            subTitle = "Visual, behavioral, and motion-rich widgets"
        ),
        ComposePlayGroundData(
            prefix = "L",
            title = "Layouts in Compose",
            subTitle = "Jetpack Compose makes it easy to design"
        ),
        ComposePlayGroundData(
            prefix = "C",
            title = "Compose modifiers",
            subTitle = "Modifiers allow you to decorate or augment a composable"
        ),
        ComposePlayGroundData(
            prefix = "N",
            title = "Navigating with Compose",
            subTitle = "You can navigate between composable"
        ),
        ComposePlayGroundData(
            prefix = "L",
            title = "Lists",
            subTitle = "display collections of items"
        ),
        ComposePlayGroundData(
            prefix = "R",
            title = "Resources in Compose ",
            subTitle = "Resources are the additional files and static content that your code uses,"
        ),
        ComposePlayGroundData(
            prefix = "A",
            title = "Animation ",
            subTitle = "it easy to implement various animations in your app's UI"
        ),
        ComposePlayGroundData(
            prefix = "D",
            title = "DemoUI ",
            subTitle = "Implemented complex app and ui"
        ),
        ComposePlayGroundData(
            prefix = "T",
            title = "Template",
            subTitle = "Carousel slider, Intro & many more"
        )
    )
}