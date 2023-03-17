package com.example.gk2

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gk2.fakeDATA.FakeDialogList
import com.example.gk2.screens.*
import com.example.gk2.screens.chat.ChatScreen
import com.example.gk2.screens.chat.ChatScreenViewModel
import com.example.gk2.ui.theme.Gk2Theme

sealed class Screen( val title: String) {
    object Begin: Screen("Начать")
    object Dialogs: Screen("Диалоги")
    object Favorite: Screen("Избранное")
}

data class BottomNavigationItem(
    val title: String,
    val route: String,
    val icon: ImageVector
)

val BottomNavigationItems = listOf(
    BottomNavigationItem(
        title = Screen.Begin.title,
        route = "Start",
        icon = Icons.Outlined.Add
    ),
    BottomNavigationItem(
        title = Screen.Dialogs.title,
        route = "Dialogs",
        icon = Icons.Outlined.List
    ),
    BottomNavigationItem(
        title = Screen.Favorite.title,
        route = "Favorite",
        icon = Icons.Outlined.Favorite
    )
)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainView(){
    val selectedIndex = remember { mutableStateOf(1) }
    val NavController = rememberNavController()
    val ScaffoldState = rememberScaffoldState()
    Gk2Theme {
        Scaffold(
            scaffoldState = ScaffoldState,
            bottomBar = {
                if (selectedIndex.value < 3){
                    BottomNavigation {
                        BottomNavigationItems.forEachIndexed { i, bottomNavigationItem ->
                            BottomNavigationItem(
                                label = {Text(text = bottomNavigationItem.title)},
                                icon = {
                                    Icon(
                                    imageVector = bottomNavigationItem.icon,
                                    contentDescription = ""
                                    )
                                       },
                                selected = selectedIndex.value == i,
                                onClick = {
                                    NavController.navigate(bottomNavigationItem.route)
                                }
                            )
                        }
                    }
                }
            }
        ) {
            NavHost(navController = NavController, startDestination = "Dialogs"){
                composable("Start") {
                    StartChattingScreen(NavController = NavController)
                    selectedIndex.value = 0
                }
                composable("Dialogs") {
                    DialogsScreen(navController = NavController)
                    selectedIndex.value = 1
                }
                composable("Favorite") {
                    FavoriteScreen(dialogs = FakeDialogList, navController = NavController)
                    selectedIndex.value = 2
                }
                composable("Chat") {
                    ChatScreen(navController = NavController)
                    selectedIndex.value = 3
                }
                composable("ReadDialog"){
                    ReadDialogScreen(navController = NavController)
                    selectedIndex.value = 4
                }
            }
        }
    }
}



