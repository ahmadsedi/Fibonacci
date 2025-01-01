package com.ahmadsedi.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 01/01/2025
 * Time: 16:47
 */

public class FibonacciViolationFinderTest {

    @Test
    void isViolated_givenVilation_returnTrue(){
        int[] numbers = {89, 143};
        boolean isViolated = FibonacciViolationFinder.isViolated(numbers);
        Assertions.assertTrue(isViolated);
    }
    @Test
    void isViolated_givenValid_returnFalse(){
        int[] numbers = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};
        boolean isViolated = FibonacciViolationFinder.isViolated(numbers);
        Assertions.assertFalse(isViolated);
    }
}
