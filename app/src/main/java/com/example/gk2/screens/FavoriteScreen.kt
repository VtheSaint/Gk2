package com.example.gk2.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gk2.fakeDATA.FakeDialogList
import com.example.gk2.ui.theme.Dialog
import com.example.gk2.ui.theme.primaryColor
import com.example.gk2.ui.theme.typography




@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FavoriteScreen(dialogs: List<Dialog>,navController: NavController){
    Scaffold(topBar = { favoriteScreenTopAppBar()}) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(all = 4.dp)
        ) {
            items(items = FakeDialogList){
                dialogCard(
                    title = it.name,
                    date = it.date,
                    words = it.words,
                    NavController = navController
                )
            }
        }
    }
}








@Composable
fun favoriteScreenTopAppBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(primaryColor)
    ) {
        TextButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = primaryColor,
                contentColor = primaryColor
            ),
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit",
                modifier = Modifier.background(primaryColor)
            )
        }
        Spacer(modifier = Modifier.weight(1.0f))

        Text(text = "Favorite", style = typography.h2)

        Spacer(modifier = Modifier.weight(1.0f))

        TextButton(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                backgroundColor = primaryColor,
                contentColor = Color.White,
            )
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                modifier = Modifier.background(primaryColor)

            )
        }
    }
}