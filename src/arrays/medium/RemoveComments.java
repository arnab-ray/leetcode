package arrays.medium;

import java.util.LinkedList;
import java.util.List;

public class RemoveComments {
    public List<String> removeComments(String[] source) {
        if(source.length == 0)
            return new LinkedList<>();

        List<String> result = new LinkedList<>();
        boolean inBlock = false;
        StringBuilder line = new StringBuilder();

        for(String s : source) {
            char[] arr = s.toCharArray();
            if(!inBlock) line = new StringBuilder();
            for(int i = 0; i < s.length();) {
                if(!inBlock && i + 1 < s.length() && arr[i] == '/' && arr[i + 1] == '*') {
                    inBlock = true;
                    i++;
                } else if(inBlock && i + 1 < s.length() && arr[i] == '*' && arr[i + 1] == '/') {
                    inBlock = false;
                    i++;
                } else if(!inBlock && i + 1 < s.length() && arr[i] == '/' && arr[i + 1] == '/') {
                    break;
                } else if(!inBlock) {
                    line.append(arr[i]);
                }
                i++;
            }

            if(!inBlock && line.length() > 0)
                result.add(line.toString());
        }

        return result;
    }
}
