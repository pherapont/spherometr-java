package ru.konry.spherometr.helpers;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rounders {
    public Rounders() {
    }

    public static double roundToThreeDecimalPlaces(double number) {
        BigDecimal result = new BigDecimal(number);
        result = result.setScale(3, RoundingMode.HALF_UP);
        return result.doubleValue();
    }
}