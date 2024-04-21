package com.example.composeui.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeui.ui.customui.Example

@Composable
fun TextFieldScreen(
    gotoButtonScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    Example(
        gotoButtonScreen = gotoButtonScreen,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldScreenPreview() {
    Example({})
}