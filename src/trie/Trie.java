package trie;

public class Trie {
    private final static int ALPHABET_SIZE = 26;

    private static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            this.isEndOfWord = false;
            this.children = new TrieNode[ALPHABET_SIZE];
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    TrieNode root;


    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode();
            }

            temp = temp.children[index];
        }

        temp.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (temp.children[index] == null)
                return false;

            temp = temp.children[index];
        }

        return temp.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;

        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (temp.children[index] == null)
                return false;

            temp = temp.children[index];
        }

        return true;
    }
}
