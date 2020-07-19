package bfs.medium;

import java.util.*;

public class WordLadder {
    private class Node {
        String val;
        int level;

        Node(String val, int level) {
            this.val = val;
            this.level = level;
        }
    }

    private int hammingDistance(String str1, String str2) {
        int i = 0, count = 0;
        while (i < str1.length()) {
            if(str1.charAt(i) != str2.charAt(i))
                count++;
            i++;
        }

        return count;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord))
            return 0;

        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new Node(beginWord, 1));
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.val.equals(endWord))
                return node.level;
            for(String str : wordList) {
                if(!visited.contains(str) && hammingDistance(node.val, str) == 1) {
                    queue.add(new Node(str, node.level + 1));
                    visited.add(str);
                }
            }
        }
        return 0;
    }
}
