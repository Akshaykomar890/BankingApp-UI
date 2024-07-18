package com.example.bankingapp.data

import androidx.compose.ui.graphics.Brush

data class CardItem(
    val carType:String,
    val cardName:String,
    val cardNumber:String,
    val cardBalance:Double,
    val color:Brush
)
