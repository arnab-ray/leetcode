package map.easy;

import java.util.HashSet;

public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer i : candyType)
            set.add(i);

        return Math.min(set.size(),  candyType.length / 2);
    }
}
