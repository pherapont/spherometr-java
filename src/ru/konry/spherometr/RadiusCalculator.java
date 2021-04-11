package ru.konry.spherometr;

public class RadiusCalculator
{
    private final double sc;
    private final double ringRadius;
    private final double ballRadius;

    public RadiusCalculator(double surfaceMeasure, double ringRadius, double ballRadius) {
        sc = surfaceMeasure;
        this.ringRadius = ringRadius;
        this.ballRadius = ballRadius;
    }

    public double calcConvex() {
        double term_1 = ringRadius * ringRadius / sc;
        double term_2 = sc / 2;
        return term_1 + term_2 - ballRadius;
    }
    public double calcConcave() {
        double term_1 = ringRadius * ringRadius / sc;
        double term_2 = sc / 2;
        return term_1 + term_2 + ballRadius;
    }
}
