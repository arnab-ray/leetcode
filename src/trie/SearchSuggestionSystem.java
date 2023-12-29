package trie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SearchSuggestionSystem {

    private static class TrieNode {
        final TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            for (int i = 0; i < 26; i++)
                children[i] = null;
            this.isEndOfWord = false;
        }
    }

    private final TrieNode root = new TrieNode();

    private void addWord(String word) {
        TrieNode temp = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (temp.children[index] == null)
                temp.children[index] = new TrieNode();

            temp = temp.children[index];
        }

        temp.isEndOfWord = true;
    }

    private void getSuffix(TrieNode newRoot, StringBuilder sb, List<String> result) {
        if (newRoot.isEndOfWord) {
            result.add(sb.toString());
        }

        for (int i = 0; i < 26; i++) {
            if (newRoot.children[i] != null) {
                sb.append((char) ('a' + i));
                getSuffix(newRoot.children[i], sb, result);
                sb.setLength(sb.length() - 1);
            }
        }
    }

    private List<String> getStringsMatchingPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        TrieNode temp = root;

        // Go through prefix and update the string builder
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (temp.children[index] != null) {
                sb.append((char) ('a' + index));
                temp = temp.children[index];
            } else {
                return result;
            }
        }

        // When prefix is exhausted, search for all suffix
        getSuffix(temp, sb, result);
        return result;
    }


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();

        for (String product : products) {
            addWord(product);
        }

        for (int i = 0; i < searchWord.length(); i++) {
            List<String> tempResult = getStringsMatchingPrefix(searchWord.substring(0, i + 1));
            if (tempResult.size() > 3) {
                tempResult.sort(Comparator.naturalOrder());
                result.add(tempResult.subList(0, 3));
            } else {
                result.add(tempResult);
            }
        }

        return result;
    }
}
