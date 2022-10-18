package com.philipademba.takehome.shared.util

import java.text.DecimalFormat
import java.util.*

fun String.validateSpaces(): String {
    return if (this.replace(" ", "").isEmpty()) {
        ""
    } else {
        this
    }
}

fun String.sanitizeToBinary(): String {
    return this.toCharArray().filter { it == '1' || it == '0' }.joinToString("")
}


fun String.processBinaryRate(rate: Double = 361.50): String {
    var res = this.toBigInteger(radix = 2)
    res = (res.toBigDecimal() * rate.toBigDecimal()).toBigInteger()

    return String.format(
        "%" + 14 + "s",
        res.toString(2)
    ).replace(" ".toRegex(), "0")
}

fun String.capitalizeFirst(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}

fun String.binaryToCurrency(): String {
    if (this.isEmpty()) {
        return "0"
    }
    if (this == Constants.NULL_AMOUNT) {
        return this
    }
    val formatter = DecimalFormat("#,###")
    return formatter.format(this.toBigInteger(radix = 2))
}

fun String.toCurrency(): String {
    if (this.isEmpty()) {
        return "0"
    }
    val formatter = DecimalFormat("#,###")
    return formatter.format(this.toBigInteger())
}

fun String.isAboveLimit(limit: Int): Boolean {
    if (this.isEmpty()) {
        return false
    }
    return this.toBigInteger(radix = 2) > limit.toBigInteger()
}

fun String.pathToTitle(): String {
    return this.replace("_", " ").capitalizeFirst()
}

