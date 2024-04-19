package com.example.composeui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Example(
    modifier: Modifier = Modifier
) {

    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .statusBarsPadding()
            .padding(16.dp)
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState()),
    ) {
        CustomTextField(
            leadingIcon = R.drawable.user_24px,
            labelString = stringResource(id = R.string.username),
            value = username,
            onValueChanged = { username = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            modifier = modifier
        )

        CustomTextField(
            leadingIcon = R.drawable.password_24px,
            labelString = stringResource(id = R.string.password),
            value = password,
            onValueChanged = { password = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            modifier = modifier
        )
    }
}

@Composable
fun CustomTextField(
    @DrawableRes leadingIcon: Int,
    labelString: String,
    value: String,
    onValueChanged: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        label = {
            when (labelString) {
                "username" ->
                    Text(
                        text = stringResource(id = R.string.username)
                    )

                "password" ->
                    Text(
                        text = stringResource(id = R.string.password)
                    )
            }
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = leadingIcon),
                contentDescription = null
            )
        },
        value = value,
        singleLine = true,
        shape = MaterialTheme.shapes.large,
        modifier = modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            disabledContainerColor = MaterialTheme.colorScheme.surface,
        ),
        onValueChange = onValueChanged,
        keyboardOptions = keyboardOptions
    )
}


@Preview(showBackground = true)
@Composable
fun ExamplePreview() {
    Example()
}