package org.example.benchmark

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.TimeUnit


@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
open class AtkinInParts {

    companion object {
        const val limit = 100_000;
        val list1 = sieveOfAtkinPart1(limit)
        val list2 = sieveOfAtkinPart2(list1, limit)
    }


    @Benchmark
    fun testPart1(blackhole: Blackhole) {
        val list = sieveOfAtkinPart1(limit)
        blackhole.consume(list)
    }

    @Benchmark
    fun testPart2(blackhole: Blackhole) {
        val list = sieveOfAtkinPart2(list1, limit)
        blackhole.consume(list)
    }

    @Benchmark
    fun testPart3(blackhole: Blackhole) {
        val result = sieveOfAtkinPart3(limit, list2)
        blackhole.consume(result)
    }
}
