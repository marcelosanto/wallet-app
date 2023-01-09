package br.com.developermarcelo.walletapp.presentation.state

import androidx.compose.ui.graphics.Color

data class TransactionUiItem(
    val description: String,
    val value: Float,
    val date: String,
    val color: Color
)
