package string.easy;

import java.util.ArrayList;
import java.util.List;

public class OccurenceAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split("\\s+");
        List<String> result = new ArrayList<>();

        for (int i = 2; i < words.length; i++)
            if (words[i - 1].equals(second) && words[i - 2].equals(first))
                result.add(words[i]);

        int len = 0;
        String[] thirds = new String[result.size()];
        for (String s : result)
            thirds[len++] = s;

        return thirds;
    }
}
