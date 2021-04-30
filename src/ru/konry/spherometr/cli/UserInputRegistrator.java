package ru.konry.spherometr.cli;

import ru.konry.spherometr.exceptions.RingTypeException;
import ru.konry.spherometr.parametrs.CalculationType;
import ru.konry.spherometr.parametrs.SpherometrType;
import ru.konry.spherometr.parametrs.SurfaceType;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInputRegistrator {

    private UserSpherometrData userData;
    Scanner input = new Scanner(System.in);

    public UserInputRegistrator() {
        userData = new UserSpherometrData();
    }

    public UserSpherometrData getUserData() {
        writeAllUserInputs();
        return userData;
    }

    public void writeAllUserInputs() {
        inventToInput();
        writeSurfaceTypeInput();
        writeCalculationTypeInput();
        writeSpherometrTypeInput();
        writeSurfaceMeasure();
        writeTypeOfRingInput();
    }

    private void inventToInput() {
        System.out.println("Расчет параметров оптической поверхности.");
    }

    private int getUserInput(int countOfParams){
        ArrayList<Integer> params = new ArrayList<Integer>(countOfParams);
        int response = 0;
        for(int c = 1; c <= countOfParams; c++) {
            params.add(c);
        }
        do {
            try {
                response = input.nextInt();
                if(params.contains(response)){
                    System.out.println("Вы ввели допустимый параметр: " + response);
                }
                else {
                    System.out.println("Вы ввели не допустимый параметр:  " + response);
                    System.out.println("Введите допустимый параметр.");
                }
            } catch (Exception exception){
                System.out.println("Введите допустимое числовое значение!");
                input.next();
            }
        } while (!params.contains(response));
        System.out.println("Ввод закончен!");
        return response;
    }

    private void writeSurfaceTypeInput() {

        System.out.println("Введите тип поверхности:");
        System.out.println("Выпуклая: 1");
        System.out.println("Вогнутая: 2");

        int surfaceType = getUserInput(2);

        if(surfaceType == 1) {
            userData.setSurfaceType(SurfaceType.CONVEX);
        } else {
            userData.setSurfaceType(SurfaceType.CONCAVE);
        }
    }

    private void writeCalculationTypeInput() {
        System.out.println("Введите тип вычисления: ");
        System.out.println("Радиус: 1");
        System.out.println("Стрелка: 2");

        int calculationType = getUserInput(2);

        if(calculationType == 1) {
            userData.setCalculationType(CalculationType.RADIUS);
        } else {
            userData.setCalculationType(CalculationType.HEIGHT);
        }
    }

    private void writeSpherometrTypeInput() {
        System.out.println("Введите тип сферометра: ");
        System.out.println("Большой: 1");
        System.out.println("Малый: 2");

        int spherometrType = getUserInput(2);

        if(spherometrType == 1) {
            userData.setSpherometrType(SpherometrType.BIG);
        } else {
            userData.setSpherometrType(SpherometrType.SMALL);
        }
    }

    private void writeSurfaceMeasure() {
        System.out.println("Введите данные для расчета поверхности (мм)");
        System.out.println("Дробная часть отделяется запятой.");
        double measure = 0;
        while (true) {
            try {
                measure = input.nextDouble();
                break;
            } catch (Exception ex) {
                System.out.println("Введите числовое значение");
                input.next();
            }
        }
        userData.setSurfaceMeasure(measure);
    }

    private void writeTypeOfRingInput() {
        System.out.println("Введите номер кольца: ");

        int ringNumber;
        SpherometrType shpType = userData.getSpherometrType();
        if(shpType == SpherometrType.BIG) {
            ringNumber = getUserInput(4);
        } else {
            ringNumber = getUserInput(7);
        }
        try {
            userData.setRingNumber(ringNumber);
        } catch (RingTypeException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UserInputRegistrator uir = new UserInputRegistrator();
        uir.writeAllUserInputs();
        System.out.println("Тип поверхности: " + uir.userData.getSurfaceType());
        System.out.println("Тип вычисления: " + uir.userData.getCalculationType());
        System.out.println("Тип сферометра: " + uir.userData.getSpherometrType());
        System.out.println("Номер кольца сферометра: " + uir.userData.getRingNumber());
        System.out.println("Входные данные для расчетов: " + uir.userData.getSurfaceMeasure() + "мм");
    }
}
