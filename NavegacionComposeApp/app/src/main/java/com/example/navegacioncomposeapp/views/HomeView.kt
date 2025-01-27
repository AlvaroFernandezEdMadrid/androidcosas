package com.example.navegacioncomposeapp.views

import android.annotation.SuppressLint
import android.app.Notification.Action
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.navegacioncomposeapp.components.ActionButton
import com.example.navegacioncomposeapp.components.BarTitle
import com.example.navegacioncomposeapp.components.ElementSpacer
import com.example.navegacioncomposeapp.components.MainButton
import com.example.navegacioncomposeapp.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navCont: NavController) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { BarTitle(name = "Patatunga2") },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Red
            )
        )
    },

        floatingActionButton = {
            ActionButton()
        }) {
        ContentHomeView(navCont)

    }
}

@Composable
fun ContentHomeView(navCont: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TitleView("Cositas")
        ElementSpacer()
        TitleView("Patata2")
        ElementSpacer()
        MainButton(
            name = "Detalle View", bgColor = Color.Red, myColor = Color.White
        ) {
            //println("Boton generico")
            navCont.navigate("Detail")
        }
    }
}

