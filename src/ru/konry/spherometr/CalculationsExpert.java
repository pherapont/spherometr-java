package ru.konry.spherometr;

import ru.konry.spherometr.cli.UserInputRegistrator;
import ru.konry.spherometr.cli.UserSpherometrData;
import ru.konry.spherometr.exceptions.OutOfRangeSpherometrMeasureException;
import ru.konry.spherometr.parametrs.CalculationType;
import ru.konry.spherometr.parametrs.Spherometr;
import ru.konry.spherometr.parametrs.SurfaceType;

public class CalculationsExpert
{
    private final UserSpherometrData usd;
    private final Calculator calculator;

    public CalculationsExpert(UserSpherometrData usd) {
        this.usd = usd;
        Spherometr sph = new Spherometr(usd);
        calculator = new Calculator(usd.getSurfaceMeasure(), sph.getRingRadius(), sph.getBallRadius());
    }

//    TODO Создать interface Calculator и фабрику калькуляторов, которая в зависимости от переданных параметров будет создавать нужный калькулятор

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
            e.printStackTrace();
        }
        System.out.println("Результат вычисления: " + result + "мм.");
    }
}