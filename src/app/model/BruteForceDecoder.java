package app.model;

import static app.constants.Alphabet.*;
import static app.constants.CommonWordsDictionary.*;

import java.util.*;

public class BruteForceDecoder {

    public List<String> bruteForceDecodingJunior(List<String> lines) {
            List<String> decryptedFile = new ArrayList<>();
            for (int i = 0; i < alphabetLength; i++) {

                decryptedFile.add("\nKey number " + i);
                for (String line : lines) {
                    decryptedFile.add(Decryptor.decrypt(line.toLowerCase(), i));
                }
                decryptedFile.add("\n************************************\n ");
            }
            return decryptedFile;
        }

    public List<String> bruteForceDecoding(List<String> lines) {
        Map<Integer, Integer> mapOfMatchesByKey = new HashMap<>();
        for (int i = 0; i < alphabetLength; i++) {
            List<String> decryptedFile = new ArrayList<>();
            for (String line : lines) {
                decryptedFile.add(Decryptor.decrypt(line.toLowerCase(), i));
            }
            Integer matches = getNumberOfMatches(decryptedFile);
            mapOfMatchesByKey.put(i, matches);
        }
        Integer bestKey = getBestKey(mapOfMatchesByKey);
        return StatisticAnalyzer.getTheBestResultAfterDecryption(bestKey,lines);
    }

private Integer getBestKey(Map<Integer, Integer> mapOfMatchesByKey) {
    Integer bestKey = null;
    if (!mapOfMatchesByKey.isEmpty()) {
        int maxValue = 0;
        for (int value : mapOfMatchesByKey.values()) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        //System.out.println(mapOfMatchesByKey);
        for (Map.Entry<Integer, Integer> entry : mapOfMatchesByKey.entrySet()) {
            if (entry.getValue().equals(maxValue)) {
                bestKey = entry.getKey();
            }
        }
    }
    //System.out.println(bestKey);
    return bestKey;
}

private Integer getNumberOfMatches(List<String> lines) {
    int counter = 0;
    for (String line : lines) {
        String[] words = line.toLowerCase().split(" ");
        for (String word : words) {
            if (commonWords.contains(word)) {
                counter++;
            }
        }
    }
    return counter;
}
}

