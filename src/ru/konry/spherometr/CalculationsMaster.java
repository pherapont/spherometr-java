package ru.konry.spherometr;

import ru.konry.spherometr.cli.*;
import ru.konry.spherometr.parametrs.*;

public class CalculationsMaster {

    private double surfaceMeasure;
    RadiusCalculator radiusCalculator;
    ClearanceCalculator clearanceCalculator;

    public CalculationsMaster(SurfaceRadius sr) {
        surfaceMeasure = sr.radius;
        clearanceCalculator = new ClearanceCalculator(0, 0, 0)
    }

    public CalculationsMaster(SurfaceClearance sc) {
        surfaceMeasure = sc.clearance;
        radiusCalculator = new RadiusCalculator(0,0,0);
    }

    public static void main(String[] args) {
        SurfaceClearance result;
        UserInputRegistrator uir = new UserInputRegistrator();
        UserSpherometrData usd = uir.getUserData();
        System.out.println(usd);
        SurfaceParameter sParameter;

    }
}
