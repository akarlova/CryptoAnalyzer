package app.constants;

import java.util.HashMap;
import java.util.Map;

public class Statistic {

    public final static  Map<Character, Double> statisticFrequency = getStatisticFrequency();

    private static Map <Character, Double> getStatisticFrequency() {
        Map<Character, Double> frequency = new HashMap<>();
        frequency.put(' ', 0.2005);
        frequency.put('о', 0.0764);
        frequency.put('е', 0.0732);
        frequency.put('а', 0.0629);
        frequency.put('и', 0.0577);
        frequency.put('т', 0.0549);
        frequency.put('н', 0.049);
        frequency.put('р', 0.0459);
        frequency.put('с', 0.0404);
        frequency.put('в', 0.0355);
        frequency.put('п', 0.033);
        frequency.put('к', 0.0302);
        frequency.put('л', 0.0299);
        frequency.put('м', 0.0275);
        frequency.put('д', 0.0265);
        frequency.put('у', 0.0222);
        frequency.put('я', 0.0153);
        frequency.put('ы', 0.0143);
        frequency.put('ь', 0.0138);
        frequency.put('з', 0.0133);
        frequency.put('й', 0.0125);
        frequency.put('б', 0.0114);
        frequency.put('ч', 0.0094);
        frequency.put('г', 0.0083);
        frequency.put('ю', 0.0081);
        frequency.put('ж', 0.0079);
        frequency.put('х', 0.0048);
        frequency.put('щ', 0.0042);
        frequency.put('ф', 0.0036);
        frequency.put('ш', 0.0026);
        frequency.put('э', 0.0023);
        frequency.put('ц', 0.0021);
        frequency.put('ъ', 0.0003);
        return frequency;
    }
}
