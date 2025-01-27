package com.example.navegacioncomposeapp.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.navegacioncomposeapp.components.BarTitle
import com.example.navegacioncomposeapp.components.MainButton
import com.example.navegacioncomposeapp.components.MainIconButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(navCont: NavController) {
    Scaffold(topBar = {
        TopAppBar(title = { BarTitle(name = "Detalle View") },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.Blue
            ),
            navigationIcon = {
                MainIconButton(
                    icon = Icons.AutoMirrored.Filled.ArrowBack
                ) {
                    navCont.popBackStack()
                }
            })
    }) { ContentDetailView(navCont) }
}

@Composable
fun ContentDetailView(navCont: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MainButton(
            name = "Retornar Home", bgColor = Color.Blue, myColor = Color.White
        ) {
            //println("Boton generico en details")
            navCont.popBackStack()
        }
    }
}