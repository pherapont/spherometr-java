package ru.konry.spherometr.exceptions;

public class RingTypeException extends Exception
{
    public RingTypeException() {
    }

    public RingTypeException(String message) {
        super(message);
    }

    public RingTypeException(Throwable cause) {
        super(cause);
    }
}
