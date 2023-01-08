package br.com.developermarcelo.walletapp.domain.usecase

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ParseTransactionValueInputUseCaseTest {
    private val transactionValueInputUseCase = ParseTransactionValueInputUseCase()

    @Test
    fun testZeroWithoutCommaReturnsFalse(){
        val result = transactionValueInputUseCase("0")
        assertThat(result).isFalse()
    }

    @Test
    fun testZeroWithCommaReturnsFalse(){
        val result = transactionValueInputUseCase("0,00")
        assertThat(result).isFalse()
    }

    @Test
    fun testMultipleZeroWithCommaReturnsFalse(){
        val result = transactionValueInputUseCase("0000,00")
        assertThat(result).isFalse()
    }

    @Test
    fun testZeroBeforeCommaAndaValueAfterCommaReturnsTrue(){
        val result = transactionValueInputUseCase("0,20")
        assertThat(result).isTrue()
    }

    @Test
    fun testSingleValueWithoutOneCommaReturnsTrue(){
        val result = transactionValueInputUseCase("2")
        assertThat(result).isTrue()
    }

    @Test
    fun testNormalValueWithOneCommaValueAfterReturnsTrue(){
        val result = transactionValueInputUseCase("2,1")
        assertThat(result).isTrue()
    }

    @Test
    fun testNormalValueWithTwoCommaValueAfterReturnsTrue(){
        val result = transactionValueInputUseCase("2,13")
        assertThat(result).isTrue()
    }

    @Test
    fun testTooLongValueReturnsFalse(){
        val result = transactionValueInputUseCase("2,131")
        assertThat(result).isFalse()
    }
}