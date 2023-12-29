package trie;

public class WordDictionary {
    private static final int ALPHABET_SIZE = 26;

    private static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        public TrieNode() {
            children = new TrieNode[ALPHABET_SIZE];
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
            isEndOfWord = false;
        }
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode temp = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (temp.children[index] == null)
                temp.children[index] = new TrieNode();

            temp = temp.children[index];
        }

        temp.isEndOfWord = true;
    }

    private boolean searchUtil(String word, int index, TrieNode root) {
        if (index == word.length()) return root.isEndOfWord;

        char c = word.charAt(index);

        if (c == '.') {
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                if (root.children[i] != null && searchUtil(word, index + 1, root.children[i]))
                    return true;
            }

            return false;
        } else {
            if (root.children[c - 'a'] == null)
                return false;
            return searchUtil(word, index + 1, root.children[c - 'a']);
        }
    }

    public boolean search(String word) {
        TrieNode temp = root;
        return searchUtil(word, 0, temp);
    }
}
