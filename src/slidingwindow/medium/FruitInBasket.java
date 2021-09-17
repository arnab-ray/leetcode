package slidingwindow.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FruitInBasket {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, end = -1;
        int maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < fruits.length; i++) {
            end++;
            if (map.size() == 2 && !map.containsKey(fruits[i])) {
                int minPos = Integer.MAX_VALUE;
                int maxPosFruit = -1;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (minPos > entry.getValue()) {
                        minPos = entry.getValue();
                        maxPosFruit = entry.getKey();
                    }
                }

                map.remove(maxPosFruit);
                start = minPos + 1;
            }
            map.put(fruits[i], i);
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}
