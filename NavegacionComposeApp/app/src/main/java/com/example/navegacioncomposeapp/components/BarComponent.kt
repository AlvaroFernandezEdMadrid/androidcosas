package com.example.navegacioncomposeapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp

@Composable
fun BarTitle(name: String) {
    Text(text = name, fontSize = 25.sp, color = Color.White)
}

@Composable
fun ActionButton() {
    FloatingActionButton(onClick = {}, containerColor = Color.Green, contentColor = Color.Yellow) {
        Icon(imageVector = Icons.Default.Call, contentDescription = "MalphiteWasap")
    }
}

@Composable
fun MainIconButton(icon: ImageVector, myOnClick: () -> Unit) {
    IconButton(onClick = myOnClick) {
        Icon(imageVector = icon, contentDescription = null, tint = Color.White)
    }
}