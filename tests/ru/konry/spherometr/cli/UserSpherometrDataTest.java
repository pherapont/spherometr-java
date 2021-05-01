package ru.konry.spherometr.cli;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.konry.spherometr.exceptions.RingTypeException;
import ru.konry.spherometr.parametrs.SpherometrType;

import static org.junit.jupiter.api.Assertions.*;

class UserSpherometrDataTest {

    UserSpherometrData usd;

    @BeforeEach
    void prepareDataForTest() {
        usd = new UserSpherometrData();
        usd.setSpherometrType(SpherometrType.BIG);
    }

    @Test
    void setRingNumberCorrectTest() {
        usd.setSurfaceMeasure(20);
        try {
            usd.setRingNumber(3);
            assertEquals(usd.getRingNumber(), 3);
        } catch (RingTypeException e) {
            e.printStackTrace();
        };
    }
}