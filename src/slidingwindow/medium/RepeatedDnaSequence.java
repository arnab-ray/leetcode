package slidingwindow.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDnaSequence {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> stringCount = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10 && i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        if(sb.length() == 10) {
            stringCount.put(sb.toString(), 1);
        } else {
            return result;
        }

        for(int i = 10; i < s.length(); i++) {
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));

            stringCount.put(sb.toString(), stringCount.getOrDefault(sb.toString(), 0) + 1);
        }

        for(Map.Entry<String, Integer> entry : stringCount.entrySet()) {
            if(entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
