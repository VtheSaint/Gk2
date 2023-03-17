package com.example.gk2.screens.chat

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gk2.fakeDATA.FakeChatData
import com.example.gk2.ui.theme.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ChatScreen(navController: NavController){
    var count by remember { mutableStateOf(FakeChatData.count()) }
    val scrollState = rememberLazyListState()
    Scaffold(
        topBar = {chatScreenTopAppBar(navController = navController) },
    ) {
        Column (Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.weight(1.0f)){
                MessageList(messages = FakeChatData)
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .background(backgroundColor)
            ) {
                var textValue by remember { mutableStateOf(TextFieldValue("")) }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(backgroundColor)
                ) {
                    OutlinedTextField(
                        value = textValue,
                        onValueChange = { textValue = it},
                        placeholder = { Text(text = "Start typing..") },
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
                        keyboardActions = KeyboardActions(
                            onSend = {
                                FakeChatData.add(Message(title = textValue.text, id = FakeChatData.size, sender = 0))
                                textValue = TextFieldValue("")
                                count++
                            }
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                    )
                }
            }
            //Spacer(modifier = Modifier.height(56.dp))
        }
    }
}

@Composable
fun MessageList(messages: List<Message>) {
    LazyColumn(
        Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(items = messages) {
            if (it.sender == 1){
                MessageCard(msg = it)
            } else {
                HostMessageCard(msg = it)
            }
        }
    }
}



@Composable
fun MessageCard(msg: Message) {
    Box(
        Modifier
            .background(backgroundColor)
            .padding(4.dp)
    ) {
        Row(horizontalArrangement = Arrangement.Start) {
            Column(Modifier.weight(3.0f)) {
                // Text(msg.author, style = typography.h3, color = Color.Black)
                Card(
                    shape = RoundedCornerShape(4.dp),
                    //border = BorderStroke(1.dp, Color.LightGray),
                ) {
                    Box(modifier = Modifier.background(Color.White)){
                        Row(Modifier.padding(8.dp)) {
                            Column {
                                Text(msg.title, style = typography.h5, color = Color.Black)
                            }
                        }
                    }
                }
            }
            Column (Modifier.weight(1.0f)) {
                Spacer(Modifier.weight(1.0f))
            }
        }

    }
}

@Composable
fun HostMessageCard(msg: Message) {
    Box(
        Modifier
            .background(backgroundColor)
            .padding(4.dp)
    ) {
        Row(horizontalArrangement = Arrangement.End) {
            Column(Modifier.weight(1.0f)) {
                Spacer(Modifier.weight(1.0f))
            }
            Column(Modifier.weight(3.0f), horizontalAlignment = Alignment.End) {
                // Text(msg.author, style = typography.h3, color = Color.Black)
                Card(
                    shape = RoundedCornerShape(4.dp),
                    //border = BorderStroke(1.dp, Color.LightGray),
                ) {
                    Box(modifier = Modifier.background(chatBackgroundColor)){
                        Row(Modifier.padding(8.dp)) {
                            Column {
                                Text(msg.title, style = typography.h5)
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun chatScreenTopAppBar(navController: NavController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(primaryColor)
    )
    {
        TextButton(
            onClick = {navController.navigate("Dialogs")},

            colors = ButtonDefaults.buttonColors(
                backgroundColor = primaryColor,
                contentColor = Color.White
            ),
            modifier = Modifier
                .background(primaryColor)
        ) { Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            modifier = Modifier.background(primaryColor)
        )
        }

        Spacer(modifier = Modifier.weight(1.0f))

        Text(text = "User X", style = typography.h2)

        Spacer(modifier = Modifier.weight(1.0f))

        TextButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = primaryColor,
                contentColor = Color.White
            ),
            modifier = Modifier
                .background(primaryColor)
        ) { Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            modifier = Modifier.background(primaryColor)
        )
        }
    }
}
