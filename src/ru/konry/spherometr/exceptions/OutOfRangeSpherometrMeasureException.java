package ru.konry.spherometr.exceptions;

public class OutOfRangeSpherometrMeasureException extends Exception
{
    public OutOfRangeSpherometrMeasureException() {
    }

    public OutOfRangeSpherometrMeasureException(String message) {
        super(message);
    }

    public OutOfRangeSpherometrMeasureException(Throwable cause) {
        super(cause);
    }
}
