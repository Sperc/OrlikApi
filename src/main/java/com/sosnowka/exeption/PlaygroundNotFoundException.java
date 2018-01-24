package com.sosnowka.exeption;

/**
 * Created by Pawel on 06.01.2018.
 */
public class PlaygroundNotFoundException extends Exception {
    public PlaygroundNotFoundException() {
    }

    public PlaygroundNotFoundException(String message) {
        super(message);
    }
}
