package com.ahmadsedi.fibonacci;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 01/01/2025
 * Time: 15:42
 */

public class FibonacciViolationFinder {

    public static boolean isViolated(int[] array) {
        Arrays.sort(array);
        FibonacciViolationFinder.generate().takeWhile(i->i<=array[array.length-1]).mapToObj(String::valueOf).collect(Collectors.toList());
        return FibonacciViolationFinder.generate().takeWhile(i->i<=array[array.length-1]).filter(i->
            IntStream.rangeClosed(0, array.length-1).filter(j->array[j]==i).findFirst().isPresent()
        ).count() != array.length;
    }

    private static LongStream generate() {
        return Stream.iterate(new long[]{0, 1}, (f) -> {
            long result = f[0] + f[1];
            f[0] = f[1];
            f[1] = result;
            return f;
        }).mapToLong(f -> f[1]);
    }

}
