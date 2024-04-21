package com.example.composeui.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeui.ui.customui.ComposeIconButton

@Composable
fun ButtonScreen(
    gotoStartScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    ComposeIconButton(
        buttonText = "This is custom button",
        onClickEvent = gotoStartScreen
    )
}

@Preview(showBackground = true)
@Composable
fun ButtonScreenPreview() {
    ButtonScreen({})
}