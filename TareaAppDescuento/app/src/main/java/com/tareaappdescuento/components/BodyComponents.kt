package com.tareaappdescuento.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SpaceH(size: Dp = 10.dp) {
    Spacer(modifier = Modifier.height(size))
}

@Composable
fun SpaceW(size: Dp = 10.dp) {
    Spacer(modifier = Modifier.width(size))
}

@Composable
fun MainTextField(value: String, myOnValueChange: (String) -> Unit, label: String) {
    OutlinedTextField(
        value = value,
        onValueChange = myOnValueChange,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    )
}

@Composable
fun MainButton(
    myText: String,
    color: Color = MaterialTheme.colorScheme.primary,
    myOnClick: () -> Unit
) {
    OutlinedButton(
        onClick = myOnClick, colors = ButtonDefaults.outlinedButtonColors(
            contentColor = color,
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    ) {
        Text(myText)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Alert(
    title: String,
    message: String,
    confirmText: String,
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissClick,
        title = { Text(title) },
        text = { Text(message) },
        confirmButton = {
            Button(onClick = { onConfirmClick() }) {
                Text(confirmText)
            }
        }
    )
}