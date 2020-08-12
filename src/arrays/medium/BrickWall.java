package arrays.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        int maxNonOverlappingBricks = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> list : wall) {
            int sum = 0;
            for(int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                int count = map.getOrDefault(sum, 0) + 1;
                if(count > maxNonOverlappingBricks)
                    maxNonOverlappingBricks = count;
                map.put(sum, count);
            }
        }

        int totalLength = 0;
        for(Integer i : wall.get(0))
            totalLength += i;


        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getKey() != totalLength && entry.getValue() > maxNonOverlappingBricks) {
                maxNonOverlappingBricks = entry.getValue();
            }
        }

        return wall.size() - maxNonOverlappingBricks;
    }
}
