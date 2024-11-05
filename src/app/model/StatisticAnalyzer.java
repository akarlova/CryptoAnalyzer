package app.model;

import static app.constants.Statistic.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static app.constants.Alphabet.alphabetLength;

public class StatisticAnalyzer {

    public List<String> statisticAnalyzerDecoder(List<String> lines) {
        Map<Integer, Double> mapOfFrequencyVariants = new HashMap<>();
        for (int i = 0; i < alphabetLength; i++) {
            List<String> decryptedFile = new ArrayList<>();
            for (String line : lines) {
                decryptedFile.add(Decryptor.decrypt(line.toLowerCase(), i));
            }
            double squareDifference = calcFrequencyDifference(decryptedFile);
            mapOfFrequencyVariants.put(i, squareDifference);
        }
        int bestKey = getBestFrequency(mapOfFrequencyVariants);
        return getTheBestResultAfterDecryption(bestKey,lines);

    }

    public static List<String> getTheBestResultAfterDecryption(int bestKey, List<String> originalLines) {
        if (bestKey == 0) {
            return originalLines;
        } else {
            List<String> bestVariant = new ArrayList<>();
            for (String line : originalLines) {
                line = line.toLowerCase();
                bestVariant.add(Decryptor.decrypt(line, bestKey));
            }
            return bestVariant;
        }
    }

    private static int getBestFrequency(Map<Integer, Double> mapOfFrequencyVariants) {
        int bestKey = 0;
        if (!mapOfFrequencyVariants.isEmpty()) {
            double minValue = Double.MAX_VALUE;
            for (Map.Entry<Integer, Double> entry : mapOfFrequencyVariants.entrySet()) {
                if (entry.getValue()< minValue) {
                    minValue = entry.getValue();
                    bestKey = entry.getKey();
                }

            }
            //System.out.println(mapOfFrequencyVariants);
        }
        //System.out.println(bestKey);
        return bestKey;
    }

    private static Double calcFrequencyDifference(List<String> lines) {
        Map<Character, Double> textFrequency = new HashMap<>();
        int totalLetters = 0;
        for (String line : lines) {
            for (Character symbol : line.toCharArray()) {
                if (Character.isLetter(symbol)) {
                    symbol = Character.toLowerCase(symbol);
                    textFrequency.put(symbol, textFrequency.getOrDefault(symbol, 0.0) + 1);
                    totalLetters++;
                }
            }
        }
        double squareDifference = 0;
        for (Map.Entry<Character, Double> entry : statisticFrequency.entrySet()) {
            char symbol = entry.getKey();
            double expectedFrequency = entry.getValue();
            double actualFrequency = textFrequency.getOrDefault(symbol, 0.0) / (double) totalLetters;
            squareDifference += Math.pow(expectedFrequency - actualFrequency, 2);
        }
        return squareDifference;
    }
}
