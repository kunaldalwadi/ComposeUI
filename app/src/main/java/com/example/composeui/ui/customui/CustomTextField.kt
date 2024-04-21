package com.example.composeui.ui.customui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeui.ui.screens.LoginScreenViewModel
import com.example.composeui.R

@Composable
fun Example(
    gotoButtonScreen: () -> Unit,
    vm: LoginScreenViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val dataFromVM by vm.uiState.collectAsState()

//    var username by rememberSaveable {
//        mutableStateOf("")
//    }

    var password by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        CustomTextField(
            leadingIcon = R.drawable.edit_24px,
            labelString = stringResource(id = R.string.nickname),
            value = vm.nickname,
            onValueChanged = { vm.updateNickName(it) },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            modifier = modifier
        )
        CustomTextField(
            leadingIcon = R.drawable.user_24px,
            labelString = stringResource(id = R.string.username),
            value = dataFromVM.username,
            onValueChanged = { vm.updateUsername(it) },
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
        Button(onClick = gotoButtonScreen) {
            Text(text = "Go to Button Screen")
        }
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
                "nickname" ->
                    Text(
                        text = stringResource(id = R.string.nickname)
                    )

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
    Example({})
}