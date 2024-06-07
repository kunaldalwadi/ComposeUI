package com.example.composeui.ui.customui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeui.R


@Composable
fun DividerWithText(
    text: Int,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        HorizontalDivider(
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.surfaceTint,
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
        )
        Text(
            text = stringResource(id = text), modifier = modifier.padding(8.dp)
        )
        HorizontalDivider(
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.surfaceTint,
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
        )
    }
}

@Composable
fun StylizedText(
    text: Int,
    color: Color,
    textStyle: TextStyle,
    textDecoration: TextDecoration,
    onclick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = text),
        style = textStyle,
        textDecoration = textDecoration,
        color = color,
        modifier = modifier
            .clickable(
                onClick = onclick
            )
            .wrapContentSize()
    )
}

@Composable
fun AcceptTermsAndConditionCheckbox(
    checked: Boolean, onCheckedChange: (Boolean) -> Unit, modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = modifier
        )
        Column(
            modifier = modifier
        ) {
            Row(
                modifier = modifier
            ) {
                Text(
                    text = stringResource(R.string.by_continuing_you_accept_our) + " "
                )
                StylizedText(text = R.string.privacy_policy,
                    color = MaterialTheme.colorScheme.primary,
                    textStyle = MaterialTheme.typography.bodySmall,
                    textDecoration = TextDecoration.Underline,
                    onclick = { /*TODO*/ })
            }
            Row(
                modifier = modifier
            ) {
                Text(
                    text = stringResource(R.string.and) + " "
                )
                StylizedText(text = R.string.terms_of_service,
                    color = MaterialTheme.colorScheme.primary,
                    textStyle = MaterialTheme.typography.bodySmall,
                    textDecoration = TextDecoration.Underline,
                    onclick = { /*TODO*/ })
            }
        }
    }
}

@Composable
fun AcceptTermsAndConditionClickableText(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val initialString = stringResource(id = R.string.by_continuing_you_accept_our)
    val privacyPolicyString = stringResource(id = R.string.privacy_policy)
    val andString = stringResource(id = R.string.and)
    val termsOfServiceString = stringResource(id = R.string.terms_of_service)

    val annotatedString = buildAnnotatedString {
        append(initialString)
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )
        ) {
            pushStringAnnotation(tag = privacyPolicyString, annotation = privacyPolicyString)
            append(privacyPolicyString)
        }
        append(andString)
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )
        ) {
            pushStringAnnotation(tag = termsOfServiceString, annotation = termsOfServiceString)
            append(termsOfServiceString)
        }
    }

    ClickableText(
        text = annotatedString,
        onClick = {
            annotatedString.getStringAnnotations(it, it).firstOrNull()?.let { stringAnnotation ->
                if (stringAnnotation.tag == privacyPolicyString) {
                    onClick()
                }
            }
        })
}


@Preview(showBackground = true)
@Composable
fun UsernameTextFieldsPreview() {
    CredentialTextField(
        label = R.string.username,
        leadingIcon = R.drawable.username_icon,
        trailingIcon = null,
        value = "Synchrony",
        onValueChange = {},
        keyboardOptions = KeyboardOptions(),
        visualTransformation = VisualTransformation.None
    )
}

@Preview(showBackground = true)
@Composable
fun PasswordTextFieldsPreview() {
    CredentialTextField(
        label = R.string.password,
        leadingIcon = R.drawable.password_24px,
        trailingIcon = R.drawable.check_icon,
        value = "Password",
        onValueChange = {},
        keyboardOptions = KeyboardOptions(),
        visualTransformation = PasswordVisualTransformation()
    )
}

@Preview(showBackground = true)
@Composable
fun AcceptTermsAndConditionCheckboxPreview(
    modifier: Modifier = Modifier
) {
    AcceptTermsAndConditionCheckbox(
        checked = true, onCheckedChange = {}, modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun DividerWithTextPreview() {
    DividerWithText(text = R.string.Or)
}

@Preview(showBackground = true)
@Composable
private fun AcceptTermsAndConditionClickableTextPreview() {
    AcceptTermsAndConditionClickableText(onClick = { /*TODO*/ })
}