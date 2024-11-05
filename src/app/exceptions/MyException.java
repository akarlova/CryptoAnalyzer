package app.exceptions;

import java.util.Arrays;

public class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
        System.out.println("У тебя получилось всё уронить! " + Arrays.toString(getStackTrace()));
    }
}
