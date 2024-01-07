package backtracking.medium;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {
    private void numUtil(String tiles, StringBuilder sb, Set<String> result, boolean[] visited) {
        result.add(sb.toString());

        for (int i = 0; i < tiles.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(tiles.charAt(i));
                numUtil(tiles, sb, result, visited);
                sb.setLength(sb.length() - 1);
                visited[i] = false;
            }
        }
    }

    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean[] visited = new boolean[tiles.length()];
        numUtil(tiles, new StringBuilder(), set, visited);

        return set.size() - 1;
    }
}
