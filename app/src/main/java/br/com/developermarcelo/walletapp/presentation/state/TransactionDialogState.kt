package br.com.developermarcelo.walletapp.presentation.state

data class TransactionDialogState(
    val isOpen: Boolean = false,
    val type: TransactionType = TransactionType.Deposit,
    val isConfirmButtonEnabled: Boolean = false,
    val currentValueInput: String = ""
)

enum class TransactionType {
    Deposit, Withdraw
}
