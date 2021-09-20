package string.easy;

import java.util.LinkedList;
import java.util.List;

public class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        int[] count = new int[26];
        for(int i = 0; i < words[0].length(); i++)
            count[words[0].charAt(i) - 'a']++;

        for(int i = 1; i < words.length; i++) {
            int[] temp = new int[26];
            for(int j = 0; j < words[i].length(); j++)
                temp[words[i].charAt(j) - 'a']++;

            for(int j = 0; j < 26; j++)
                count[j] = Math.min(count[j], temp[j]);
        }

        List<String> result = new LinkedList<>();
        for(int i = 0; i < 26; i++){
            if(count[i] > 0){
                for(int j = 0; j < count[i]; j++){
                    result.add((char) (i + 'a') + "");
                }
            }
        }

        return result;
    }
}
