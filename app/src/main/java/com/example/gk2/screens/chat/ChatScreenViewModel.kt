package com.example.gk2.screens.chat

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gk2.fakeDATA.colleagueProfile
import com.example.gk2.fakeDATA.meProfile
import com.example.gk2.ui.theme.Message

class ChatScreenViewModel: ViewModel() {
    private val _chatScreenViewState: MutableLiveData<ChatScreenState> =
        MutableLiveData(ChatScreenState(0, null,"", null))
    val chatScreenViewState: LiveData<ChatScreenState> = _chatScreenViewState

    private var userId: Long = 0
    fun setUserId(newUserId: Long?) {
        if (newUserId != userId) {
            userId = newUserId ?: meProfile.userId
        }
        _userData.value = if (userId == meProfile.userId) {
            meProfile
        } else {
            colleagueProfile
        }
    }

    private val _messages: MutableList<Message> = mutableListOf()
    val messages: List<Message> = _messages

    fun addMessage(msg: Message){
        _messages.add(element = msg, index = 0)
    }

    private val _userData = MutableLiveData<ChatScreenState>()
    val userData: LiveData<ChatScreenState> = _userData
}

@Immutable
data class ChatScreenState(
    val userId: Long,
    @DrawableRes val photo: Int?,
    val username: String,
    val lastVisit: String?
    ) {
    fun isMe() = userId == meProfile.userId
}

