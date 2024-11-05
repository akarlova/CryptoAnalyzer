package app.model;

import static app.constants.Alphabet.*;

public class Encryptor{

    public static String encrypt(String line, int shift){
        StringBuilder encryptedLine = new StringBuilder();
        for(Character symbol : line.toCharArray()){
            encryptedLine.append(encrypt(symbol, shift));
        }
        return encryptedLine.toString();
    }

    public static char encrypt(Character ch, int shift) {
        if (!ALPHABET_MAP.containsKey(ch)) {
            return ch;
        }
        else if (shift >= 0) {
            int encryptedIndex = (ALPHABET_MAP.get(ch) + shift) % alphabetLength;
            return ALPHABET[encryptedIndex];
        } else {
            int encryptedIndex = (ALPHABET_MAP.get(ch) + (alphabetLength + shift % alphabetLength)) % alphabetLength;
            return ALPHABET[encryptedIndex];
        }
    }
}
