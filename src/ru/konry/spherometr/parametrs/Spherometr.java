package ru.konry.spherometr.parametrs;

import ru.konry.spherometr.cli.UserSpherometrData;

public class Spherometr
{
    private double ringRadius;
    private double ballRadius;
    private int ringNumber;
    SpherometrType type;


    public Spherometr(UserSpherometrData usd) {
        this.ringNumber = usd.getRingNumber();
        this.type = usd.getSpherometrType();
    }

    public double getRingRadius() {
        if(type == SpherometrType.BIG) {
            ringRadius = SpherBigData.values()[ringNumber - 1].ringRadius;
        } else {
            ringRadius = SpherSmallData.values()[ringNumber -1].ringRadius;
        }
        return ringRadius;
    }

    public double getBallRadius() {
        if(type == SpherometrType.BIG) {
            ballRadius = SpherBigData.values()[ringNumber - 1].ballRadius;
        } else {
            ballRadius = SpherSmallData.values()[ringNumber -1].ballRadius;
        }
        return ballRadius;
    }
}
