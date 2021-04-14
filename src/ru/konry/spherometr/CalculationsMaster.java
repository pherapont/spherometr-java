package ru.konry.spherometr;

import ru.konry.spherometr.cli.*;
import ru.konry.spherometr.parametrs.*;

// ! [ ] Попробовать осуществить восходящее преобразование типов к интерфейсу Calculator in class SpherometrBig and SphermetrSmall
// ? [ ] Добавление TODO в Idea нижняя панель

public class CalculationsMaster {

    SpherometrBig spherometrBig;
    SpherometrSmall spherometrSmall;

    public CalculationsMaster(
            int ringNumber, SurfaceRadius radius, SurfaceType surfaceType, SpherometrType spherometrType
    ) {
        if (spherometrType == SpherometrType.BIG) {
            spherometrBig = new SpherometrBig(ringNumber, radius, surfaceType);
        } else {
            spherometrSmall = new SpherometrSmall(ringNumber, radius, surfaceType);
        }
    }

    public CalculationsMaster(
            int ringNumber, SurfaceClearance clearance, SurfaceType surfaceType, SpherometrType spherometrType
    ) {
        if (spherometrType == SpherometrType.BIG) {
            spherometrBig = new SpherometrBig(ringNumber, clearance, surfaceType);
        } else {
            spherometrSmall = new SpherometrSmall(ringNumber, clearance, surfaceType);
        }
    }

    public static void main(String[] args) {
        UserInputRegistrator registrator = new UserInputRegistrator();
        UserSpherometrData userData = registrator.getUserData();
        System.out.println(userData);
    }
}
