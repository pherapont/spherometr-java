package ru.konry.spherometr;

import ru.konry.spherometr.exceptions.OutOfRangeSpherometrMeasureException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator
{
    private final double surfaceMeasure;
    private final double ringRadius;
    private final double ballRadius;
    public final double rangeOfSpherometrMeasure = 15;

    public Calculator(double surfaceMeasure, double ringRadius, double ballRadius) {
        this.surfaceMeasure = surfaceMeasure;
        this.ringRadius = ringRadius;
        this.ballRadius = ballRadius;
    }

    public double calcConvexClearance() throws OutOfRangeSpherometrMeasureException {
        double tmpSum = surfaceMeasure + ballRadius;
        double rootExp = tmpSum * tmpSum - ringRadius * ringRadius;
        double result = roundToThreeDecimalPlaces(tmpSum - Math.sqrt(rootExp));
        if (result >= rangeOfSpherometrMeasure) {
            throw new OutOfRangeSpherometrMeasureException("Диапазон измерений сферометра не позволит измерить полученную высоту: " +
                    result + "мм.");
        }
        return result;
    }

    public double calcConcaveClearance() throws OutOfRangeSpherometrMeasureException {
        double tmpDif = surfaceMeasure - ballRadius;
        double rootExp = tmpDif * tmpDif - ringRadius * ringRadius;
        double result = roundToThreeDecimalPlaces(tmpDif - Math.sqrt(rootExp));
        if (result >= rangeOfSpherometrMeasure) {
            throw new OutOfRangeSpherometrMeasureException("Диапазон измерений сферометра не позволит измерить полученную высоту: " +
                    result + "мм.");
        }
        return result;
    }

    public double calcConvexRadius() {
        double term_1 = ringRadius * ringRadius / surfaceMeasure;
        double term_2 = surfaceMeasure / 2;
        return term_1 + term_2 - ballRadius;
    }

    public double calcConcaveRadius() {
        double term_1 = ringRadius * ringRadius / surfaceMeasure;
        double term_2 = surfaceMeasure / 2;
        return term_1 + term_2 + ballRadius;
    }

    private double roundToThreeDecimalPlaces(double number) {
        BigDecimal result = new BigDecimal(number);
        result = result.setScale(3, RoundingMode.HALF_UP);
        return result.doubleValue();
    }
}
