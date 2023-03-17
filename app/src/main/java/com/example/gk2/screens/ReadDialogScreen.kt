package com.example.gk2.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.gk2.fakeDATA.FakeDialogCardData
import com.example.gk2.screens.chat.MessageList
import com.example.gk2.screens.chat.chatScreenTopAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ReadDialogScreen(navController: NavController){
    var count by remember { mutableStateOf(FakeDialogCardData.count()) }
    Scaffold(
        topBar = { chatScreenTopAppBar(navController = navController) },
    ) {
        Column (Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.weight(1.0f)){
                MessageList(messages = FakeDialogCardData)
            }
        }
    }
}