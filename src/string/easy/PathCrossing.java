package string.easy;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int x = 0, y = 0;

        set.add(x + "," + y);
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N')
                x++;
            else if (path.charAt(i) == 'S')
                x--;
            else if (path.charAt(i) == 'E')
                y++;
            else
                y--;

            if (!set.contains(x + "," + y))
                set.add(x + "," + y);
            else
                return true;
        }

        return false;
    }
}
