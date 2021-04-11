package ru.konry.spherometr;

public class ClearanceCalculator
{
    private final double sr;
    private final double ringRadius;
    private final double ballRadius;

    public ClearanceCalculator(double surfaceMeasure, double ringRadius, double ballRadius) {
        sr = surfaceMeasure;
        this.ringRadius = ringRadius;
        this.ballRadius = ballRadius;
    }

    public double calcConvex() {
        double tmpSum = sr + ballRadius;
        double rootExp = tmpSum * tmpSum - ringRadius * ringRadius;
        return tmpSum - Math.sqrt(rootExp);
    }

    public double calcConcave() {
        double tmpDif = sr - ballRadius;
        double rootExp = tmpDif * tmpDif - ringRadius * ringRadius;
        return tmpDif - Math.sqrt(rootExp);
    }
}
