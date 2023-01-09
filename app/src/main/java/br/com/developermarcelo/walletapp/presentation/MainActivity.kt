package br.com.developermarcelo.walletapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import br.com.developermarcelo.walletapp.presentation.components.TransactionDialog
import br.com.developermarcelo.walletapp.presentation.components.TransactionItem
import br.com.developermarcelo.walletapp.presentation.components.WalletOverview
import br.com.developermarcelo.walletapp.ui.theme.WalletAppTheme
import br.com.developermarcelo.walletapp.ui.theme.gray
import br.com.developermarcelo.walletapp.ui.theme.orange
import br.com.developermarcelo.walletapp.ui.theme.white

class MainActivity : ComponentActivity() {
    private val walletViewModel = WalletViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = orange.toArgb()
            window.navigationBarColor = orange.toArgb()

            WalletAppTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(gray)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    WalletOverview(
                        valueBeforeComma = { walletViewModel.totalAmountBeforeComma },
                        valueAfterComma = { walletViewModel.totalAmountAfterComma },
                        onDepositClick = { walletViewModel.onDepositClick() },
                        onWithdrawClick = { walletViewModel.onWithdrawClick() },
                        modifier = Modifier
                            .fillMaxWidth(0.75f)
                            .shadow(5.dp, RoundedCornerShape(15.dp))
                            .background(
                                orange, shape = RoundedCornerShape(15.dp)
                            )
                            .aspectRatio(2f)
                    )
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        items(walletViewModel.transactionList) {
                            TransactionItem(
                                color = it.color,
                                description = it.description,
                                date = it.date,
                                value = 100f,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(white.copy(0.8f), RoundedCornerShape(25.dp))
                                    .padding(12.dp)
                            )
                        }
                    }
                }
            }
            if (walletViewModel.transactionDialogState.isOpen) {
                TransactionDialog(
                    onDismiss = { walletViewModel.onDismissDialog() },
                    value = { walletViewModel.transactionDialogState.currentValueInput },
                    onValueChange = { walletViewModel.onTransactionValueChange(it) },
                    description = walletViewModel.transactionDialogState.type.toString(),
                    onConfirm = { walletViewModel.onTransactionConfirm() },
                    isButtonEnabled = { walletViewModel.transactionDialogState.isConfirmButtonEnabled }
                )


            }
        }
    }
}

