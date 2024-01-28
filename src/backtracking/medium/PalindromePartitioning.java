package backtracking.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();

        partitionUtil(s, 0, new LinkedList<>(), result);
        return result;
    }

    private void partitionUtil(String s, int pos, List<String> tempList, List<List<String>> result) {
        if (pos == s.length()) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = pos; i < s.length(); i++) {
                if (isPalindrome(s, pos, i)) {
                    tempList.add(s.substring(pos, i + 1));
                    partitionUtil(s, i + 1, tempList, result);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--))
                return false;
        }

        return true;
    }
}
