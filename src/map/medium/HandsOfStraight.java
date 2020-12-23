package map.medium;

import java.util.TreeMap;

public class HandsOfStraight {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0)
            return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int val : hand)
            map.put(val, map.getOrDefault(val, 0) + 1);

        while (!map.isEmpty()) {
            int firstNum = map.firstKey();
            for (int i = 0; i < W; i++) {
                Integer count = map.get(firstNum + i);
                if (count == null) return false;
                if (count == 1) {
                    map.remove(firstNum + i);
                } else {
                    map.put(firstNum + i, count - 1);
                }
            }
        }

        return true;
    }
}
