package arrays.medium;

import java.util.*;

public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> rows = new TreeMap<>();
        for(int[] point : points) {
            rows.computeIfAbsent(point[0], f -> new LinkedList<>()).add(point[1]);
        }

        int result = Integer.MAX_VALUE;
        Map<Integer, Integer> lastX = new HashMap<>();
        for(int x : rows.keySet()) {
            List<Integer> row = rows.get(x);
            Collections.sort(row);

            for(int i = 0; i < row.size(); i++) {
                for(int j = i + 1; j < row.size(); j++) {
                    int y1 = row.get(i), y2 = row.get(j);
                    int code = 40001 * y1 + y2;
                    if(lastX.containsKey(code)) {
                        result = Math.min(result, (x - lastX.get(code)) * (y2 - y1));
                    }
                    lastX.put(code, x);
                }
            }
        }

        return result < Integer.MAX_VALUE ? result : 0;
    }
}
