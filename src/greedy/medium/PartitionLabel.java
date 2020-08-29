package greedy.medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabel {
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++)
            last[S.charAt(i) - 'a'] = i;

        int i = 0;
        while (i < S.length()) {
            int end = last[S.charAt(i) - 'a'];
            int j = i;
            while (j < end) {
                end = Math.max(end, last[S.charAt(j) - 'a']);
                j++;
            }

            list.add(end - i + 1);
            i = j + 1;
        }

        return list;
    }
}
