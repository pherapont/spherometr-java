package ru.konry.spherometr;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource({"100, 10.355",
            "200, 5.057",
            "777.777, 1.3",
            "9535.2, 0.106"})
    void big_Ring1_CalcConvexHeightTest(double radius, double height) {
        Calculator calculator = new Calculator(radius, 45.0473, 3.158);
        assertEquals(height, calculator.calcConvexClearance());
    }

    @Test
    void calcConcaveClearance() {
    }

    @Test
    void calcConvexRadius() {
    }

    @Test
    void calcConcaveRadius() {
    }
}