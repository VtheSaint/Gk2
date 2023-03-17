package com.example.gk2.fakeDATA

import com.example.gk2.screens.chat.ChatScreenState
import com.example.gk2.ui.theme.Dialog
import com.example.gk2.ui.theme.Message



var FakeDialogCardData = mutableListOf<Message>(
    Message(title = "Hello", id = 0, sender = 0),
    Message(title = "Hi", id = 1, sender = 1),
    Message(title = "What do you know about this app", id = 2, sender = 0),
    Message(title = "This app is great opportunity for:", id = 3, sender = 1),
    Message(title = "Making anonymous surveys", id = 4, sender = 0),
    Message(title = "And collecting information about user needs", id = 5, sender = 1),
    Message(title = "Also you can", id = 6, sender = 0),
    Message(title = "Get some interesting information from all of the world", id = 7, sender = 1),
    Message(title = "Say what you want and have no consequences", id = 8, sender = 0),
    Message(title = "Form alternative opinion", id = 9, sender = 1),
    Message(title = "And just find interesting persons for talking", id = 10, sender = 0),
)


var FakeChatData = mutableListOf<Message>(
    Message( "Пацаны, я вас ненавижу", id = 1, sender = 0),
    Message( "Особенно Кенни", 2, 1),
    Message( "Ну давайте, пацаны, подпевайте, вы же знаете слова.", 3, 0),
    Message( "Пошел в жопу Картман", 4, 1),
    Message( "asjfkljsdflkjasdlfjkas;ldkfjasl;d lkaj kjlk j;laks kdjfljl asjkfl klkjdlkfjalskdj lasdfkasjdfksjdk sdjfkskjkjk for i in adf ag", 5, 0),
    Message( "asjfkljsdflkjasdlfjkas;ldkfjasl;d lkaj kjlk j;laks kdjfljl asjkfl klkjdlkfjalskdj lasdfkasjdfksjdk sdjfkskjkjk for i in adf ag", 6,1),
    Message( "Пацаны, я вас ненавижу", 7,0),
    Message( "Особенно Кенни", 8,1),
    Message( "Ну давайте, пацаны, подпевайте, вы же знаете слова.", 9,0),
    Message( "Пошел в жопу Картман", 10, 1),
    Message( "asjfkljsdflkjasdlfjkas;ldkfjasl;d lkaj kjlk j;laks kdjfljl asjkfl klkjdlkfjalskdj lasdfkasjdfksjdk sdjfkskjkjk for i in adf ag", 11, 0),
    Message( "asjfkljsdflkjasdlfjkas;ldkfjasl;d lkaj kjlk j;laks kdjfljl asjkfl klkjdlkfjalskdj lasdfkasjdfksjdk sdjfkskjkjk for i in adf ag", 12, 1)
)


var FakeDialogList = mutableListOf<Dialog>(
    Dialog(name = "x-y", date = "18:30, 18/02/22", words = 345, isDeleted = false),
    Dialog(name = "d-g", date = "23:30, 30/02/22", words = 34, isDeleted = false),
    Dialog(name = "xd - iii", date = "8:30, 22/02/22", words = 300, isDeleted = false),
    Dialog(name = "XV-XIX", date = "1:30, 19/02/22", words = 256, isDeleted = false),
    Dialog(name = "XX-TY", date = "10:30, 18/01/22", words = 388, isDeleted = false),
)

val meProfile = ChatScreenState(
    userId = 234123412,
    username = "Ali Conors",
    photo = null,
    lastVisit = null
)

val colleagueProfile = ChatScreenState(
    userId = 1234142134,
    username = " ",
    photo = null,
    lastVisit = null
)
