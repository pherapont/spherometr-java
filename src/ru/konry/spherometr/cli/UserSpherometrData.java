package ru.konry.spherometr.cli;

import ru.konry.spherometr.exceptions.RingTypeException;
import ru.konry.spherometr.parametrs.*;

public class UserSpherometrData {
    private SurfaceType surfaceType;
    private double surfaceMeasure;
    private SpherometrType spherometrType;
    private CalculationType calculationType;
    private int ringNumber;

    @Override
    public String toString() {
        return "UserSpherometrData{" +
                "surfaceType=" + surfaceType +
                ", surfaceMeasure=" + surfaceMeasure +
                ", spherometrType=" + spherometrType +
                ", calculationType=" + calculationType +
                ", ringNumber=" + ringNumber +
                '}';
    }

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

//    TODO Write tests for method setRingNumber

    public void setRingNumber(int ringNumber) throws RingTypeException {
        if((spherometrType == SpherometrType.BIG && SpherBigData.values()[ringNumber].ringRadius >= surfaceMeasure) ||
            (spherometrType == SpherometrType.SMALL && SpherSmallData.values()[ringNumber].ringRadius >= surfaceMeasure)) {
            throw new RingTypeException("Невозможно провести измерения для данного радиуса с выбранным кольцом.");
        }
        this.ringNumber = ringNumber;
    }

    public static void main(String[] args) {
        UserSpherometrData usd = new UserSpherometrData();
        System.out.println(usd);
    }
}
