package ru.konry.spherometr;

public class Calculator
{
    private final double surfaceMeasure;
    private final double ringRadius;
    private final double ballRadius;

    public Calculator(double surfaceMeasure, double ringRadius, double ballRadius) {
        this.surfaceMeasure = surfaceMeasure;
        this.ringRadius = ringRadius;
        this.ballRadius = ballRadius;
    }

    public double calcConvexClearance() {
        double tmpSum = surfaceMeasure + ballRadius;
        double rootExp = tmpSum * tmpSum - ringRadius * ringRadius;
        return tmpSum - Math.sqrt(rootExp);
    }

    public double calcConcaveClearance() {
        double tmpDif = surfaceMeasure - ballRadius;
        double rootExp = tmpDif * tmpDif - ringRadius * ringRadius;
        return tmpDif - Math.sqrt(rootExp);
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
}
