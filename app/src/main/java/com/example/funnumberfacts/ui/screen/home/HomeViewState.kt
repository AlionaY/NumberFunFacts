package com.example.funnumberfacts.ui.screen.home

import com.example.funnumberfacts.data.NumberFact

data class HomeViewState(
    val textInput: String = "",
    val isValidInput: Boolean = true,
    val number: Int = 0,
//    todo: make list which contains history (db) + current request
    val fact: NumberFact? = null
)