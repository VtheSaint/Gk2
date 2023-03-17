package com.example.gk2.ui.theme

data class Dialog(val name: String, val date: String, val words: Int, var isDeleted: Boolean)

data class Message(val title: String, val id: Int, val sender: Int = 0 )