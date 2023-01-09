package br.com.developermarcelo.walletapp.util

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.util.*

class FloatExtensionKtTest {
    @Test
    fun testFloatToRootFormatWithoutCommaValue() {
        val number = 10f
        val result = number.formatToPrice(Locale.ROOT)
        assertThat(result).isEqualTo("R$ 10")
    }

    @Test
    fun testFloatToUSFormatWithoutCommaValue() {
        val number = 10f
        val result = number.formatToPrice(Locale.US)
        assertThat(result).isEqualTo("R$ 10")
    }

    @Test
    fun testFloatToRootFormatWithOneCommaValue() {
        val number = 10.5f
        val result = number.formatToPrice(Locale.GERMAN)
        assertThat(result).isEqualTo("R$ 10,50")
    }

    @Test
    fun testFloatToUSFormatWithOneCommaValue() {
        val number = 10.5f
        val result = number.formatToPrice(Locale.US)
        assertThat(result).isEqualTo("R$ 10.50")
    }

    @Test
    fun testFloatFormatWithTwoCommaValues() {
        val number = 11.51f
        val result = number.formatToPrice(Locale.GERMAN)
        assertThat(result).isEqualTo("R$ 11,51")
    }

    @Test
    fun testFloatIsZeroFormatToSingleZero() {
        val number = 0f
        val result = number.formatToPrice(Locale.ROOT)
        assertThat(result).isEqualTo("R$ 0")
    }

    @Test
    fun testFloatIsZeroWithTwoCommaValuesIfThereIsNoCommaValueButItsForced() {
        val number = 0f
        val result = number.formatToPrice(Locale.ROOT, alwaysUseTwoCommaDigits = true)
        assertThat(result).isEqualTo("R$ 0.00")
    }

    @Test
    fun testNegativeFloatWithCommaValueIsFormattedCorrectly() {
        val number = -1.20f
        val result = number.formatToPrice(Locale.ROOT)
        assertThat(result).isEqualTo("R$ -1.20")
    }

    @Test
    fun testNegativeFloatWithoutCommaValueIsFormattedCorrectly() {
        val number = -5f
        val result = number.formatToPrice(Locale.ROOT)
        assertThat(result).isEqualTo("R$ -5")
    }

    @Test
    fun testNegativeFloatWithoutCommaValueAndForcedToTwoCommasIsFormattedCorrectly() {
        val number = -5f
        val result = number.formatToPrice(Locale.ROOT, alwaysUseTwoCommaDigits = true)
        assertThat(result).isEqualTo("R$ -5.00")
    }
}