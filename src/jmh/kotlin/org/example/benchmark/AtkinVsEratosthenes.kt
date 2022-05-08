package org.example.benchmark

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.TimeUnit


@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
open class AtkinVsEratosthenes {

    companion object {
        const val limit_10 = 10
        const val limit_100 = 100
        const val limit_1_000 = 1_000
        const val limit_10_000 = 10_000
        const val limit_100_000 = 100_000
        const val limit_1_000_000 = 1_000_000
        const val limit_10_000_000 = 10_000_000
        const val limit_100_000_000 = 100_000_000
    }

    @Benchmark
    fun testEratosthenes_10(blackhole: Blackhole) {
        blackhole.consume(calcPrimesNumberArray(limit_10));
    }


    @Benchmark
    fun testEratosthenes_100(blackhole: Blackhole) {
        blackhole.consume(calcPrimesNumberArray(limit_100));
    }

    @Benchmark
    fun testEratosthenes_1_000(blackhole: Blackhole) {
        blackhole.consume(calcPrimesNumberArray(limit_1_000));
    }

    @Benchmark
    fun testEratosthenes_10_000(blackhole: Blackhole) {
        blackhole.consume(calcPrimesNumberArray(limit_10_000));
    }

    @Benchmark
    fun testEratosthenes_100_000(blackhole: Blackhole) {
        blackhole.consume(calcPrimesNumberArray(limit_100_000));
    }

    @Benchmark
    fun testEratosthenes_1_000_000(blackhole: Blackhole) {
        blackhole.consume(calcPrimesNumberArray(limit_1_000_000));
    }

    @Benchmark
    fun testEratosthenes_10_000_000(blackhole: Blackhole) {
        blackhole.consume(calcPrimesNumberArray(limit_10_000_000));
    }

    @Benchmark
    fun testEratosthenes_100_000_000(blackhole: Blackhole) {
        blackhole.consume(calcPrimesNumberArray(limit_100_000_000));
    }

    /// Atkin

    @Benchmark
    fun testAtkin_10(blackhole: Blackhole) {
        blackhole.consume(sieveOfAtkinCombined(limit_10));
    }

    @Benchmark
    fun testAtkin_100(blackhole: Blackhole) {
        blackhole.consume(sieveOfAtkinCombined(limit_100));
    }

    @Benchmark
    fun testAtkin_1_000(blackhole: Blackhole) {
        blackhole.consume(sieveOfAtkinCombined(limit_1_000));
    }

    @Benchmark
    fun testAtkin_10_000(blackhole: Blackhole) {
        blackhole.consume(sieveOfAtkinCombined(limit_10_000));
    }

    @Benchmark
    fun testAtkin_100_000(blackhole: Blackhole) {
        blackhole.consume(sieveOfAtkinCombined(limit_100_000));
    }

    @Benchmark
    fun testAtkin_1_000_000(blackhole: Blackhole) {
        blackhole.consume(sieveOfAtkinCombined(limit_1_000_000));
    }

    @Benchmark
    fun testAtkin_10_000_000(blackhole: Blackhole) {
        blackhole.consume(sieveOfAtkinCombined(limit_10_000_000));
    }

    @Benchmark
    fun testAtkin_100_000_000(blackhole: Blackhole) {
        blackhole.consume(sieveOfAtkinCombined(limit_100_000_000));
    }
}