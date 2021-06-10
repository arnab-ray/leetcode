package string.easy;

import java.util.ArrayList;
import java.util.List;

public class RearrangeSpacesBetweenWords {
    public String reorderSpaces(String text) {
        int textLen = text.length();
        int countSpaces = 0;
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < textLen; i++) {
            if (text.charAt(i) == ' ') {
                if (sb.length() > 0)
                    list.add(sb.toString());

                sb = new StringBuilder();
                countSpaces++;
            } else {
                sb.append(text.charAt(i));
            }
        }
        if (sb.length() > 0)
            list.add(sb.toString());

        int sharedSpace = list.size() > 1 ? countSpaces / (list.size() - 1) : 0;
        int extraSpace = list.size() > 1 ? countSpaces % (list.size() - 1) : countSpaces / list.size();

        System.out.println(sharedSpace + " " + extraSpace);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            result.append(list.get(i));
            for (int j = 0; j < sharedSpace; j++)
                result.append(' ');
        }
        result.append(list.get(list.size() - 1));
        for (int j = 0; j < extraSpace; j++)
            result.append(' ');

        return result.toString();
    }
}
