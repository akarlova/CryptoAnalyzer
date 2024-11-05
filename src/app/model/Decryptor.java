package app.model;

import static app.model.Encryptor.*;
import static app.constants.Alphabet.*;

public class Decryptor {

    public static char decrypt(Character ch, int shift) {
        if (shift >= 0) {
            return encrypt(ch, alphabetLength - shift % alphabetLength);
        } else {
            return encrypt (ch, Math.abs(shift % alphabetLength));
        }
    }
    public static String decrypt(String line, int shift) {
     StringBuilder decryptedLine = new StringBuilder();
     for(char symbol : line.toCharArray()) {
         decryptedLine.append(decrypt(symbol, shift));
     }
     return decryptedLine.toString();
    }
}

