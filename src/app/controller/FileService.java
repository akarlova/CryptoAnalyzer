package app.controller;

import app.exceptions.MyException;
import app.model.BruteForceDecoder;
import app.model.Encryptor;
import app.model.Decryptor;
import app.constants.Messages;
import app.view.AppMenu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    AppMenu menu = new AppMenu();
    boolean isExit = false;


    public void startService() {

        while (!isExit) {
            try {
                int option = menu.getOption();
                if (option == 5) {
                    isExit = true;
                }
                ArrayList<String> data = menu.getData(option);
                if (data.size() < 2) {
                    continue;
                }
                Path fileNameToRead = Path.of(data.get(0));
                Path fileNameToWrite = Path.of(data.get(1));
                switch (option) {
                    case 1 -> {
                        int shift = Integer.parseInt(data.get(2));
                        encryptData(fileNameToRead, fileNameToWrite, shift);
                        System.out.println(Messages.SUCCESS + fileNameToWrite.toString());
                    }
                    case 2 -> {
                        int shift = Integer.parseInt(data.get(2));
                        decryptData(fileNameToRead, fileNameToWrite, shift);
                        System.out.println(Messages.SUCCESS + fileNameToWrite.toString());
                    }
                    case 3 -> {
                        bruteForceData(fileNameToRead, fileNameToWrite);
                        System.out.println(Messages.SUCCESS + fileNameToWrite.toString());
                    }
                    case 4 -> {
                        System.out.println("Тут должен появиться статистический анализ");
                    }
                    default -> System.out.println(Messages.INVALID_OPTION);
                }
            } catch (IOException e) {
                System.out.println(Messages.HANDLING_FILE_EXCEPTION + e.getMessage());
            } catch (NullPointerException npe) {
                System.out.println(Messages.EMPTY_DATA + npe.getMessage());
            } catch (MyException my) {
                System.out.println(my.getMessage());
            }
        }
    }

    //    private void encryptData() throws IOException {
//
//        try (BufferedReader reader = Files.newBufferedReader(fileNameToRead, StandardCharsets.UTF_8);
//             BufferedWriter writer = Files.newBufferedWriter(fileNameToWrite, StandardCharsets.UTF_8);
//        ) {
//            int character;
//            while ((character = reader.read()) != -1) {
//                char toLowerCaseCharacter = Character.toLowerCase((char) character);
//                char encryptedChar = Encryptor.encrypt(toLowerCaseCharacter, shift);
//                writer.write(encryptedChar);
//            }
//        }
//    }
    private void encryptData(Path fileNameToRead, Path fileNameToWrite, int shift) throws IOException {

        try (BufferedReader reader = Files.newBufferedReader(fileNameToRead, StandardCharsets.UTF_8);
             BufferedWriter writer = Files.newBufferedWriter(fileNameToWrite, StandardCharsets.UTF_8);
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                String encryptedLine = Encryptor.encrypt(line, shift);
                writer.write(encryptedLine);
                writer.newLine();
            }
        }
    }

    //    private void decryptData() throws IOException {
//
//        try (BufferedReader reader = Files.newBufferedReader(fileNameToRead, StandardCharsets.UTF_8);
//             BufferedWriter writer = Files.newBufferedWriter(fileNameToWrite, StandardCharsets.UTF_8);
//        ) {
//            int character;
//            while ((character = reader.read()) != -1) {
//                char toLowerCaseCharacter = Character.toLowerCase((char) character);
//                char encryptedChar = Decryptor.decrypt(toLowerCaseCharacter, shift);
//                writer.write(encryptedChar);
//            }
//        }
//    }
    private void decryptData(Path fileNameToRead, Path fileNameToWrite, int shift) throws IOException {

        try (BufferedReader reader = Files.newBufferedReader(fileNameToRead, StandardCharsets.UTF_8);
             BufferedWriter writer = Files.newBufferedWriter(fileNameToWrite, StandardCharsets.UTF_8);
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                String encryptedLine = Decryptor.decrypt(line, shift);
                writer.write(encryptedLine);
                writer.newLine();
            }
        }
    }

    private void bruteForceData(Path fileNameToRead, Path fileNameToWrite) throws IOException {
        List<String> lines = Files.readAllLines(fileNameToRead, StandardCharsets.UTF_8);
        BruteForceDecoder bfDecoder = new BruteForceDecoder();
        List<String> decryptedLines = bfDecoder.bruteForceDecoding(lines);
        try (BufferedWriter writer = Files.newBufferedWriter(fileNameToWrite)) {
            for (String line : decryptedLines) {
                line = line.toLowerCase();
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
