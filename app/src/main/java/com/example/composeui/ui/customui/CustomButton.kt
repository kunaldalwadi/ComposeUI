package com.example.composeui.ui.customui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ComposeIconButton(
    buttonText: String,
    onClickEvent: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = onClickEvent,
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00AAFF),
                contentColor = Color.White
            )
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorite Icon"
            )
            Spacer(modifier = modifier.width(8.dp))
            Text(text = buttonText)
        }
    }
}

@Composable
fun ButtonWithIcon(
    onclick: () -> Unit, image: Int, text: Int, modifier: Modifier = Modifier
) {
    Button(onClick = onclick) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = modifier.size(20.dp)
        )
        Text(
            text = stringResource(id = text), modifier = modifier.padding(start = 10.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ComposeIconButtonPreview() {
    ComposeIconButton(buttonText = "Custom Button", onClickEvent = {})
}