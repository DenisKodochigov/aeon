package com.example.aeon.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.aeon.R
import com.example.aeon.entity.TypeKeyboard
import com.example.aeon.ui.theme.colorApp

@Composable fun TextApp(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    style: TextStyle,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = colorApp.onSurface
) {
    Text(
        text = text,
        style = style,
        maxLines = 1,
        fontWeight = fontWeight,
        overflow = TextOverflow.Ellipsis,
        textAlign = textAlign,
        modifier = modifier,
        color = color
    )
}

@Composable fun HeaderScreen(text: String, modifier: Modifier = Modifier) {
    Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        TextApp(text = text, style = MaterialTheme.typography.headlineSmall)
    }
}
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OutlinedTextFieldMy(
    modifier: Modifier,
    enterValue: MutableState<String>,
    typeKeyboard: TypeKeyboard,
    label: Int = 0,
    keyboardActionsOnDone: (() -> Unit)? = null
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val localFocusManager = LocalFocusManager.current
    var enterText by remember { mutableStateOf(enterValue.value) }

    OutlinedTextField(
        modifier = modifier.background(color = colorApp.surface),
        value = enterText,
        singleLine = true,
        textStyle = MaterialTheme.typography.bodyMedium,
        visualTransformation = if (typeKeyboard == TypeKeyboard.PASSWORD) PasswordVisualTransformation()
                                    else VisualTransformation.None,
        label = {
            TextApp(text = stringResource(label), style = MaterialTheme.typography.titleMedium)
        },
        onValueChange = {
            enterText = it
            enterValue.value = it
        },
        keyboardOptions = keyBoardOpt(typeKeyboard),
        keyboardActions = KeyboardActions(
            onDone =
            {
                localFocusManager.clearFocus()
                enterValue.value = enterText
                enterText = ""
                keyboardActionsOnDone?.let { it.invoke() }
                keyboardController?.hide()
            }
        ),
    )
}

@Composable fun IconButton(onClick: () ->Unit){
    Icon(imageVector = Icons.Default.Logout, "",
        modifier = Modifier.clickable { onClick }
    )
}
@Composable fun ButtonApp(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier =Modifier,
    enabled: Boolean = true,
){
    Button(
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors (
            containerColor= colorApp.tertiaryContainer,
            contentColor = colorApp.onTertiaryContainer ,
            disabledContainerColor = colorApp.surface,
            disabledContentColor = colorApp.onSurface
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 6.dp,
            pressedElevation = 0.dp,
            focusedElevation = 8.dp,
            hoveredElevation = 6.dp,
            disabledElevation= 6.dp
        ),
        modifier = modifier
    ) {
        Text(text = text)
    }
}