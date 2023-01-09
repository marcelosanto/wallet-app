package br.com.developermarcelo.walletapp.domain.usecase

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculateListSumUseCaseTest {
    private val calculateListSumUseCase = CalculateListSumUseCase()

    @Test
    fun testResultWithEmptyListIsNull() {
        val result = calculateListSumUseCase(emptyList())
        assertThat(result).isEqualTo(0f)
    }

    @Test
    fun testResultWithOneListElem() {
        val result = calculateListSumUseCase(listOf(7.3f))
        assertThat(result).isEqualTo(7.3f)
    }

    @Test
    fun testResultWithMultipleListElms() {
        val result = calculateListSumUseCase(listOf(7.3f, 5.16f, 2f))
        assertThat(result).isEqualTo(14.46f)
    }

    @Test
    fun testResultWithMultipleListElmsWhichResultInNegativeNumber() {
        val result = calculateListSumUseCase(listOf(-7.3f, 5.16f, 2f, -18f))
        assertThat(result).isEqualTo(-18.14f)
    }
}