package sampling.medium;

import java.util.*;

public class RandomPickIndex {
    Map<Integer, List<Integer>> map;
    Random rand;

    public void Solution(int[] nums) {
        map = new HashMap<>();
        rand = new Random();
        List<Integer> list;
        for(int i = 0; i < nums.length; i++) {
            list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(rand.nextInt(list.size()));
    }
}
