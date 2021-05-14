package ru.konry.spherometr.helpers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoundersTest {

    @Test
    void roundToTopTest() {
        assertEquals(200.234, Rounders.roundToThreeDecimalPlaces(200.233999));
    }

    @Test
    void roundToBottomTest() {
        assertEquals(200.234, Rounders.roundToThreeDecimalPlaces(200.234321));
    }

    @Test
    void roundEqualsTest() {
        assertEquals(200.230, Rounders.roundToThreeDecimalPlaces(200.23));
    }

    @Test
    void roundZeroTest() {
        assertEquals(0.000, Rounders.roundToThreeDecimalPlaces(0));
    }
}