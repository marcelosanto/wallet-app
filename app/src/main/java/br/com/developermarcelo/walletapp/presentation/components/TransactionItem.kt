package br.com.developermarcelo.walletapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.developermarcelo.walletapp.util.formatToPrice
import java.util.*

@Composable
fun TransactionItem(
    color: Color,
    description: String,
    date: String,
    value: Float,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = description, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
            Text(text = date, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
        }
        Text(
            text = value.formatToPrice(Locale.getDefault(), true),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = color
        )
    }
}