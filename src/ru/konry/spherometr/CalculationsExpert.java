package ru.konry.spherometr;

import ru.konry.spherometr.cli.UserInputRegistrator;
import ru.konry.spherometr.cli.UserSpherometrData;
import ru.konry.spherometr.exceptions.OutOfRangeSpherometrMeasureException;
import ru.konry.spherometr.parametrs.CalculationType;
import ru.konry.spherometr.parametrs.Spherometr;
import ru.konry.spherometr.parametrs.SurfaceType;

public class
CalculationsExpert
{
    private UserSpherometrData usd;
    private Calculator calculator;
    private Spherometr sph;

    public CalculationsExpert(UserSpherometrData usd) {
        this.usd = usd;
        sph = new Spherometr(usd);
        calculator = new Calculator(usd.getSurfaceMeasure(), sph.getRingRadius(), sph.getBallRadius());
    }

    public double calculate() throws OutOfRangeSpherometrMeasureException {
        double result;
        if(usd.getCalculationType() == CalculationType.RADIUS) {
            if(usd.getSurfaceType() == SurfaceType.CONCAVE) {
                result = calculator.calcConcaveRadius();
            } else {
                result = calculator.calcConvexRadius();
            }
        } else {
            if(usd.getSurfaceType() == SurfaceType.CONCAVE) {
                result = calculator.calcConcaveClearance();
            } else {
                result = calculator.calcConvexClearance();
            }
        }
        return result;
    }

    public static void main(String[] args) {

        UserInputRegistrator userInputRegistrator = new UserInputRegistrator();
        UserSpherometrData usd = userInputRegistrator.getUserData();
        CalculationsExpert expert = new CalculationsExpert(usd);
        double result = 0;
        try {
            result = expert.calculate();
        } catch (OutOfRangeSpherometrMeasureException e) {
            e.getMessage();
            e.printStackTrace();
        }
        System.out.println("Результат вычисления: " + result + "мм.");
    }
}