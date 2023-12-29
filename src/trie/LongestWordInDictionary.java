package trie;

public class LongestWordInDictionary {

    private static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }

            isEndOfWord = false;
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

    private boolean search(String word) {
        TrieNode temp = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (temp.children[index] == null)
                return false;

            temp = temp.children[index];
        }

        return temp.isEndOfWord;
    }

    public String longestWord(String[] words) {
        String result = null;

        for (String word : words) {
            addWord(word);
        }

        for (String word : words) {
            for (int i = 1; i < word.length() + 1; i++) {
                String subStr = word.substring(0, i);
                if (!search(subStr)) {
                    break;
                } else {
                    if (result == null) {
                        result = subStr;
                    } else if (result.length() < i) {
                        result = subStr;
                    } else if (i == result.length() && subStr.compareTo(result) < 0) {
                        result = subStr;
                    }
                }
            }
        }

        return  (result == null) ? "" : result;
    }
}
