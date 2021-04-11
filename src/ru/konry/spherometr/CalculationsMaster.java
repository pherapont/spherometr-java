package ru.konry.spherometr;

import ru.konry.spherometr.cli.*;
import ru.konry.spherometr.parametrs.*;

public class CalculationsMaster {

    public static void main(String[] args) {
        SurfaceClearance result;
        UserInputRegistrator uir = new UserInputRegistrator();
        UserSpherometrData usd = uir.getUserData();
        System.out.println(usd);
        Calculator calculator;
        SurfaceParameter sParameter;
        if (usd.getSpherometrType() == SpherometrType.BIG) {
            calculator = new Calculator(SpherBigData.values()[usd.getRingNumber()]);
        } else {
            calculator = new Calculator(SpherSmallData.values()[usd.getRingNumber()]);
        }
        if (usd.getCalculationType() == CalculationType.RADIUS) {
            sParameter = new SurfaceClearance(usd.getSurfaceMeasure());
        } else {
            sParameter = new SurfaceRadius(usd.getSurfaceMeasure());
        }
        if (usd.getSurfaceType() == SurfaceType.CONCAVE) {
            result = calculator.calcConcave((SurfaceClearance) sParameter);
        } else {
            result = calculator.calcConvex((SurfaceRadius) sParameter);
        }
    }
}
