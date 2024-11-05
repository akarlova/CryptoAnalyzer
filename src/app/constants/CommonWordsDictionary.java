package app.constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class CommonWordsDictionary {
    public static final Set<String> commonWords = getListOfWords();
    private static HashSet<String> getListOfWords() {
        HashSet<String> words = new HashSet<>();
        try (BufferedReader buffer = Files.newBufferedReader(Path.of("src/app/resources/dictionary.txt"))) {
            String word;
            while ((word = buffer.readLine()) != null) {
                words.add(word.toLowerCase());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return words;
    }

}
