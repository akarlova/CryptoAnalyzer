package app.controller;

import app.constants.Messages;
import static app.constants.Alphabet.alphabetLength;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class Validator {

    public boolean validateObtainedData(String data) {
        if (data.isEmpty()) {
            System.out.println(Messages.EMPTY_DATA);
            System.out.println(Messages.TRY_AGAIN);
            return false;
        } else if (Files.notExists(Path.of(data))) {
            System.out.println(Messages.FILE_NOT_FOUND + data);
            System.out.println(Messages.TRY_AGAIN);
            return false;
        }
        return true;
    }

    public String validateKey(String key) {
        int shift;
        try {
            shift = Integer.parseInt(key);
        } catch (NumberFormatException e) {
            Random rand = new Random();
            System.out.println(e.getMessage());
            shift = rand.nextInt(alphabetLength);
            System.out.println(Messages.KEY_IS_GENERATED + String.valueOf(shift));
        }

        System.out.println(Messages.YOUR_KEY + String.valueOf(shift));
        return String.valueOf(shift);
    }
}
