package com.example.gk2.screens.chat

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController


@Composable
fun TestChatScreen(
    navController: NavController,
    chatScreenViewModel: ChatScreenViewModel
) {
    val viewState = chatScreenViewModel.chatScreenViewState.observeAsState()

    ChatScreen(navController = navController, chatScreenViewModel)
}