package app.constants;

import java.util.LinkedHashMap;
public class Alphabet {

    public static final char[] ALPHABET = "абвгдежзийклмнопрстуфхцчшщъыьэюя1234567890!@#$%^&*()_+-=[]{}:;',./<>? ".toCharArray();
    public static final int alphabetLength = ALPHABET.length;
    public static final LinkedHashMap<Character, Integer> ALPHABET_MAP = fillMap();

    private static LinkedHashMap<Character, Integer> fillMap() {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < alphabetLength; i++) {
            map.put(ALPHABET[i], i);
        }
        return map;
    }
}
