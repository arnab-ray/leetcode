package backtracking.medium;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {
    private void numUtil(String tiles, String currentStr, Set<String> result, boolean[] visited) {
        result.add(currentStr);

        for (int i = 0; i < tiles.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                numUtil(tiles, currentStr + tiles.charAt(i), result, visited);
                visited[i] = false;
            }
        }
    }

    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean[] visited = new boolean[tiles.length()];
        numUtil(tiles, "", set, visited);

        return set.size() - 1;
    }
}
