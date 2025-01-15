package com.example.primercomposeapp.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.PI

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(
    showBackground = true, widthDp = 100, heightDp = 60, showSystemUi = true, device = Devices.PIXEL
)
@Composable
fun Ejemplo(a:String="Patata") {
    Text("Mamawebo", color= Color.Cyan, modifier = Modifier.background(Color.Red).padding(horizontal = 2.dp,vertical = 4.dp))
}