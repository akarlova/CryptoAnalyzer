package app.view;

import app.controller.Validator;
import app.constants.Messages;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class AppMenu {
    public Scanner console = new Scanner(System.in);
    Validator validator = new Validator();

    public int getOption() {
        System.out.println(Messages.START_MENU);
        while(true){
        try {
            int option = Integer.parseInt(console.nextLine());
            if (option >= 1 && option <= 5) {
                return option;
            } else {
                System.out.println(Messages.INVALID_OPTION);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() +" " + Messages.INVALID_OPTION);
        }
        }
    }

    public ArrayList<String> getData(int option) {

        ArrayList<String> data = new ArrayList<>();
        switch (option) {
            case 1, 2 -> {
                data.add(getPathToOriginalFile());
                data.add(getPathToSave());
                System.out.println(Messages.PLEASE_ENTER_KEY);
                String key = console.nextLine();
                data.add(validator.validateKey(key));
                System.out.println(data);
                return data;
            }
            case 3, 4 -> {
                data.add(getPathToOriginalFile());
                data.add(getPathToSave());
                return data;
            }
            case 5 -> {
                System.out.println(Messages.APP_CLOSED);
                console.close();
            }
        }
        return data;
    }

    private String getPathToOriginalFile() {
        while (true) {
            System.out.println(Messages.PLEASE_ENTER_FILE_PATH_FOR_HANDLING);
            try{
            Path originalPath = Path.of(console.nextLine());
            while (!validator.validateObtainedData(originalPath.toString())) {
                originalPath = Path.of(console.nextLine());
            }
            return originalPath.toString();
        } catch(InvalidPathException e) {
                System.out.println(Messages.PATH_NOT_FOUND + " " + e.getMessage());
            }
        }
    }

    private String getPathToSave() {
        while (true) {
            System.out.println(Messages.PLEASE_ENTER_FILE_PATH_FOR_SAVING);
            int attempts = 3;
            try {
                Path pathForSavingFile = Path.of(console.nextLine());

                while (!validator.validateObtainedData(pathForSavingFile.toString()) && --attempts > 0) {
                    pathForSavingFile = Path.of(console.nextLine());
                }
                if (attempts == 0) {
                    pathForSavingFile = Path.of("src/app/user_files/Answer.txt");
                    System.out.println(Messages.RESULT_WILL_BE_SAVED_TO + pathForSavingFile.toString());
                    return (pathForSavingFile.toString());
                }
                System.out.println(Messages.RESULT_WILL_BE_SAVED_TO + pathForSavingFile.toString());
                return pathForSavingFile.toString();
            } catch (InvalidPathException e) {
                System.out.println(Messages.PATH_NOT_FOUND + " " + e.getMessage());
            }
        }
    }
}
