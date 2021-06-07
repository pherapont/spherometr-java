package ru.konry.spherometr;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.konry.spherometr.exceptions.OutOfRangeSpherometrMeasureException;
import ru.konry.spherometr.parametrs.SpherBigData;
import ru.konry.spherometr.parametrs.SpherSmallData;

import java.lang.reflect.Method;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource({"100, 10.355",
            "200, 5.057",
            "777.777, 1.3",
            "9535.2, 0.106"})
    void big_Ring1_CalcConvexHeightTest(double radius, double height) throws OutOfRangeSpherometrMeasureException {
        SpherBigData ring1 = SpherBigData.RING_1;
        Calculator calculator = new Calculator(radius, ring1.ringRadius, ring1.ballRadius);
        assertEquals(height, calculator.calcConvexClearance());
    }

    @ParameterizedTest
    @CsvSource({"120, 7.439",
            "205, 4.343"})
    void small_Ring2_CalcConvexHeightTest(double radius, double height) throws OutOfRangeSpherometrMeasureException {
        SpherSmallData ring2 = SpherSmallData.RING_2;
        Calculator calculator = new Calculator(radius, ring2.ringRadius, ring2.ballRadius);
        assertEquals(height, calculator.calcConvexClearance());
    }

    @ParameterizedTest
    @CsvSource({"100, 11.115",
            "200, 5.224",
            "777.777, 1.311",
            "9535.2, 0.106"})
    void big_Ring1_CalcConcaveHeightTest(double radius, double height) throws OutOfRangeSpherometrMeasureException {
        SpherBigData ring1 = SpherBigData.RING_1;
        Calculator calculator = new Calculator(radius, ring1.ringRadius, ring1.ballRadius);
        assertEquals(height, calculator.calcConcaveClearance());
    }

    @Test
    void calcConvexRadius() {
        
    }

    @Test
    void calcConcaveRadius() {
    }
}