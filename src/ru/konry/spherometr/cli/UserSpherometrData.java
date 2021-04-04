package ru.konry.spherometr.cli;

import ru.konry.spherometr.parametrs.CalculationType;
import ru.konry.spherometr.parametrs.SpherometrType;
import ru.konry.spherometr.parametrs.SurfaceType;

public class UserSpherometrData {
    private SurfaceType surfaceType;
    private double surfaceMeasure;
    private SpherometrType spherometrType;
    private CalculationType calculationType;
    private int ringNumber;

    public SurfaceType getSurfaceType() {
        return surfaceType;
    }

    public void setSurfaceType(SurfaceType surfaceType) {
        this.surfaceType = surfaceType;
    }

    public double getSurfaceMeasure() {
        return surfaceMeasure;
    }

    public void setSurfaceMeasure(double surfaceMeasure) {
        this.surfaceMeasure = surfaceMeasure;
    }

    public SpherometrType getSpherometrType() {
        return spherometrType;
    }

    public void setSpherometrType(SpherometrType spherometrType) {
        this.spherometrType = spherometrType;
    }

    public CalculationType getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(CalculationType calculationType) {
        this.calculationType = calculationType;
    }

    public int getRingNumber() {
        return ringNumber;
    }

    public void setRingNumber(int ringNumber) {
        this.ringNumber = ringNumber;
    }
}
