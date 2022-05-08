package org.example.benchmark

import java.io.File

// R = O(N)
// T = O(N)
fun sieveOfAtkinCombined(limit: Int): Int {
    val sieve = BooleanArray(limit + 1) { false }

    var x = 1
    while (x * x <= limit) {
        var y = 1
        while (y * y <= limit) {
            var n = 4 * x * x + y * y
            if (n <= limit && (n % 12 == 1 || n % 12 == 5)) sieve[n] = sieve[n] xor true
            n = 3 * x * x + y * y
            if (n <= limit && n % 12 == 7) sieve[n] = sieve[n] xor true
            n = 3 * x * x - y * y
            if (x > y && n <= limit && n % 12 == 11) sieve[n] = sieve[n] xor true
            y++
        }
        x++
    }

    var r = 5
    while (r * r <= limit) {
        if (sieve[r]) {
            var i = r * r
            while (i <= limit) {
                sieve[i] = false
                i += r * r
            }
        }
        r++
    }

    var primeNumber = when {
        limit > 2 -> 2
        limit > 1 -> 1
        else -> 0
    }
    for (a in 5..limit) if (sieve[a]) primeNumber++
    return primeNumber
}

fun sieveOfAtkinPart1(limit: Int): BooleanArray {
    val sieve = BooleanArray(limit + 1) { false }
    var x = 1
    while (x * x <= limit) {
        var y = 1
        while (y * y <= limit) {
            var n = 4 * x * x + y * y
            if (n <= limit && (n % 12 == 1 || n % 12 == 5)) sieve[n] = sieve[n] xor true
            n = 3 * x * x + y * y
            if (n <= limit && n % 12 == 7) sieve[n] = sieve[n] xor true
            n = 3 * x * x - y * y
            if (x > y && n <= limit && n % 12 == 11) sieve[n] = sieve[n] xor true
            y++
        }
        x++
    }
    return sieve
}

fun sieveOfAtkinPart2(sieve: BooleanArray, limit: Int): BooleanArray {
    var r = 5
    while (r * r <= limit) {
        if (sieve[r]) {
            var i = r * r
            while (i <= limit) {
                sieve[i] = false
                i += r * r
            }
        }
        r++
    }
    return sieve
}


fun sieveOfAtkinPart3(limit: Int, sieve: BooleanArray): Int {
    var primeNumber = when {
        limit > 2 -> 2
        limit > 1 -> 1
        else -> 0
    }
    for (a in 5..limit) if (sieve[a]) primeNumber++
    return primeNumber
}





// R = O(N/2)
// T = O(N/2 *(ln(ln(N/2)))
fun calcPrimesNumberArray(limit: Int): Int {
    if (limit < 2) return 0
    val size = if (limit % 2 == 0) limit / 2 - 1 else limit / 2
    val primesList = BooleanArray(size) { true }
    for (i in 3..limit step 2) {
        if (primesList[i / 2 - 1] && i < Int.MAX_VALUE / 3) {
            for (j in i + i + i..limit step i + i) {
                if (j % 2 != 0) {
                    primesList[j / 2 - 1] = false
                }
            }
        }
    }
    var primeNumber = 1
    for (i in 0 until size) if (primesList[i]) primeNumber++
    return primeNumber
}


