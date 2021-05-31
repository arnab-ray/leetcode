package map.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] str1 = s1.split("\\s+");
        String[] str2 = s2.split("\\s+");

        Map<String, Integer> map = new HashMap<>();
        for (String s : str1) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : str2) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> result = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        return result.toArray(new String[0]);
    }
}
