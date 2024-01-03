package greedy.medium;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrows {
    private static Comparator<int[]> comparator = (o1, o2) -> o1[1] - o2[1];

    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if(n == 0 || n == 1)
            return n;

        Arrays.sort(points, comparator);
        int count = 1;
        int last = points[0][1];

        for(int i = 1; i < points.length; i++) {
            if(points[i][0] > last) {
                count++;
                last = points[i][1];
            }
        }

        return count;
    }
}
