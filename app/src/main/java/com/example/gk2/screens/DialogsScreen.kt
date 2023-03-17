package com.example.gk2.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gk2.ui.theme.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DialogsScreen(navController: NavController, names: List<String> = List(10) { "$it" }){
    Scaffold(topBar = { dialogsScreenTopAppBar() }) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(all = 4.dp)
        ) {
            items(items = names) {
                dialogCard(
                    title = "еуу",
                    date = "sdfas",
                    words = 145,
                    NavController = navController
                )
            }
        }
    }
}


@Composable
fun dialogCard(title: String, date: String, words: Int, NavController: NavController) {
    Box(modifier = Modifier
        .height(90.dp)
        .fillMaxWidth()
        .background(backgroundColor)
        .padding(4.dp)
    ) {
        Card(
            shape = RoundedCornerShape(4.dp),
            //elevation = 4.dp,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    onClick = { NavController.navigate("ReadDialog") }
                )
        ) {
            Box(
                modifier = Modifier
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                extraColor,
                                darkExtraColor
                            )
                        )
                    )
                    .padding(8.dp)
            ) {
                Row(Modifier.fillMaxWidth()) {
                    Column(horizontalAlignment = Alignment.Start) {
                        Spacer(Modifier.weight(1.0f))

                        Text(title, style = typography.h1)

                        Spacer(Modifier.weight(1.0f))
                    }

                    Spacer(Modifier.weight(1.0f))
                    Column(horizontalAlignment = Alignment.End) {
                        Spacer(Modifier.weight(1.0f))

                        Text(date, style = typography.h3)

                        Spacer(Modifier.height(8.dp))

                        Text("$words words", style = typography.h4)

                        Spacer(Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun dialogsScreenTopAppBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(primaryColor)
    ) {
        TextButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = primaryColor,
                contentColor = Color.White
            ),
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Search",
                modifier = Modifier.background(primaryColor)
            )
        }
        Spacer(modifier = Modifier.weight(1.0f))

        Text(text = "Dialogs", style = typography.h2)

        Spacer(modifier = Modifier.weight(1.0f))
        TextButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = primaryColor,
                contentColor = Color.White
            ),
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                modifier = Modifier.background(primaryColor)
            )
        }
    }
}


