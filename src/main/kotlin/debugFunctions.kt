fun calcPrimesNumberArrayDebug(limit: Int): Int {
    if (limit < 2) return 0
    val size = if (limit % 2 == 0) limit / 2 - 1 else limit / 2
    val primesList = BooleanArray(size) { true }
    var iterationsTotal = 0

    for (i in 3..limit step 2) {
        if (primesList[i / 2 - 1] && i < Int.MAX_VALUE / 3) {
            for (j in i + i + i..limit step i + i) {
                if (j % 2 != 0) {
                    primesList[j / 2 - 1] = false
                }
                iterationsTotal += 1
            }
        }
    }

    print("$iterationsTotal, ")
    var primeNumber = 1
    for (i in 0 until size) if (primesList[i]) primeNumber++
    return primeNumber
}

fun sieveOfAtkinPart2Debug(sieve: BooleanArray, limit: Int): BooleanArray {
    var r = 5

    var rCount = 0
    var iTotal = 0
    var rWithIf = 0
    while (r * r <= limit) {

        rCount++

        if (sieve[r]) {
            rWithIf++
            var iCount = 0

            var i = r * r
            while (i <= limit) {
                iTotal++
                iCount++

                sieve[i] = false
                i += r * r
            }
            if (iCount != 0) {
//                println("For r= $r, iCount = $iCount")
            } else {

            }

        }
        r++
    }
    println("for limit= $limit: rCount= $rCount iTotal= $iTotal rWithIf= $rWithIf, difference=${rCount - rWithIf}")
    return sieve
}

fun sieveOfAtkinCombinedDebug(limit: Int): Int {
    val sieve = BooleanArray(limit + 1) { false }

    var iter1 = 0
    var iter2 = 0

    var x = 1
    while (x * x <= limit) {
        var y = 1
        while (y * y <= limit) {

            iter1++

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

                iter2++

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

    print("$iter2, ")

    return primeNumber
}

fun main() {
//    var limit = 10
//    val stop = 100_000_000
//    while (limit <= stop) {
//        sieveOfAtkinCombinedDebug(limit)
////        val list = sieveOfAtkinPart1(limit)
////        val list2 = sieveOfAtkinPart2(list, limit)
////        val res = sieveOfAtkinPart3(limit, list2)
//        limit *= 10
//    }


    val primesInInterval = listOf(4, 21, 143, 1061, 8363, 68906, 586081, 5096876)


    var start = 10.0f
    var i = 0
    var sum = 0
    while (start <= 100_000_000) {
        sum += primesInInterval[i]
        print("${sum}, ")
        i++
        start *= 10
    }

//    val eratIters = listOf<Int>(1, 45, 701, 8834, 101855, 1125071, 12127313, 128726721)
//    val atkinIters1 = listOf<Int>(9, 100, 961, 10000, 99856, 1000000, 9998244, 100000000)
//    val atkinIters2 = listOf<Int>(0, 6, 81, 881, 9040, 90937, 910802, 9112081)
//
//    val divided = mutableListOf<Double>()
//    for (i in 0..eratIters.size - 1) {
//        divided.add(eratIters[i].toDouble()/ (atkinIters1[i] + atkinIters2[i]))
//    }
//
//    println(divided)
//    val atkin = StringBuilder()
//    val eratosthenes  = StringBuilder()
//    File("build/results/jmh/results.txt").bufferedReader().use {
//        it.forEachLine { line ->
//            if (line.startsWith("AtkinVsEratosthenes.testAtkin")) {
//                val splitLine = line.split(Regex("""\s+"""))
//                println(splitLine)
//                atkin.append(splitLine[3])
//                atkin.append(", ")
//            } else if (line.startsWith("AtkinVsEratosthenes.testEratosthenes")) {
//                val splitLine = line.split(Regex("""\s+"""))
//                println(splitLine)
//                eratosthenes.append(splitLine[3])
//                eratosthenes.append(", ")
//            }
//        }
//    }
//    println(atkin.toString())
//    println(eratosthenes.toString())



//    var f = 0
//    var s = 0
//    val time = measureNanoTime {
//        f = calcPrimesNumberArray(limit)
//    }
//    val time2 = measureNanoTime {
//        s = sieveOfAtkin(limit)
//    }
//    println("$f: $time Eratosphen\n$s: $time2 Atkin")
}