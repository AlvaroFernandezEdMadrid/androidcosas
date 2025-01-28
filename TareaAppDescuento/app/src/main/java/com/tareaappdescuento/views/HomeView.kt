package com.tareaappdescuento.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tareaappdescuento.components.Alert
import com.tareaappdescuento.components.MainButton
import com.tareaappdescuento.components.MainTextField
import com.tareaappdescuento.components.SpaceH
import com.tareaappdescuento.components.TwoCards

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView() {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(text = "App Descuento", color = Color.White)
            }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        )
    }) {
        ContentHomeView(it)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var precio by remember { mutableStateOf("") }
        var descuento by remember { mutableStateOf("") }
        var precioDescuento by remember { mutableStateOf(0.0) }
        var totalDescuento by remember { mutableStateOf(0.0) }
        var mostrarAlerta by remember { mutableStateOf(false) }

        TwoCards(
            title1 = "Total",
            number1 = totalDescuento,
            title2 = "Descuento",
            number2 = precioDescuento
        )

        MainTextField(precio, myOnValueChange = { precio = it }, label = "Precio")
        SpaceH()
        MainTextField(descuento, myOnValueChange = { descuento = it }, label = "Descuento")
        SpaceH()
        MainButton(myText = "Generar descuento") {
            if (precio != "" && descuento != "") {
                precioDescuento = calcularPrecio(precio.toDouble(), descuento.toDouble())
                totalDescuento = calcularDescuento(precio.toDouble(), descuento.toDouble())
            } else {
                mostrarAlerta = true
            }

        }
        SpaceH()
        MainButton(myText = "Limpiar", color = Color.Red) {
            precio = ""
            descuento = ""
            precioDescuento = 0.0
            totalDescuento = 0.0
        }
        if (mostrarAlerta) {
            Alert(title = "Alerta",
                message = "Escribe el precio y el descuento",
                confirmText = "Aceptar",
                onConfirmClick = { mostrarAlerta = false }) { }
        }
    }
}

fun calcularPrecio(precio: Double, descuento: Double): Double {
    val respuesta = precio - calcularDescuento(precio, descuento)
    return kotlin.math.round(respuesta * 100) / 100
}

fun calcularDescuento(precio: Double, descuento: Double): Double {
    val respuesta = precio * (1 - descuento / 100)
    return kotlin.math.round(respuesta * 100) / 100
}