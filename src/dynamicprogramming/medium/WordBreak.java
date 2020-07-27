package dynamicprogramming.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    private boolean wordBreakUtil(String s, List<String> wordDict, Map<String, Boolean> lookup) {
        if(s == null)
            return false;
        else if(s.isEmpty())
            return true;
        else {
            if(lookup.get(s) != null)
                return lookup.get(s);

            for(int i = 1; i <= s.length(); i++) {
                String prefix = s.substring(0, i);
                lookup.computeIfAbsent(prefix, wordDict::contains);
                String suffix = s.substring(i);
                if(lookup.get(prefix) && wordBreakUtil(suffix, wordDict, lookup))
                    return true;
            }

            return false;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> lookup = new HashMap<>();
        return wordBreakUtil(s, wordDict, lookup);
    }
}
